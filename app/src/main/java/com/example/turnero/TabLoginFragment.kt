package com.example.turnero;

// #### IMPORTAMOS ####

// NATIVO
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// DATABINDING
import com.example.turnero.databinding.FragmentTabLoginBinding;

// FIREBASE
import com.google.firebase.auth.FirebaseAuth;

// JAVA
import java.util.Objects;


public class TabLoginFragment extends Fragment {

    // VARIABLES MAIN
    private FirebaseAuth auth;
    // VARIABLES ANIMACION
    float v = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        com.example.turnero.databinding.FragmentTabLoginBinding binding = FragmentTabLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // ## Obtenemos la instancia de FirebaseAuth
        auth = FirebaseAuth.getInstance();

        // ## Creamos e instanciamos las variables donde obtendremos los datos de registro
        final View fragmentBody = view.findViewById(R.id.login_fragmentBody);
        final Button btnLogin = view.findViewById(R.id.login_Btn);
        final EditText login_email = view.findViewById(R.id.login_email);
        final EditText login_password = view.findViewById(R.id.login_password);
        final TextView fgt_password = view.findViewById(R.id.fgtPass);

        // ## Utilidad para esconder el teclado cuando tocamos otra parte de la pantalla
        Utilities.setupUI(fragmentBody, getActivity());

        // ## Animacion de los campos de texto
        login_email.setTranslationX(800);
        login_password.setTranslationX(800);
        fgt_password.setTranslationX(800);
        btnLogin.setTranslationY(-200);

        login_email.setAlpha(v);
        login_password.setAlpha(v);
        btnLogin.setAlpha(v);
        fgt_password.setAlpha(v);

        login_email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        login_password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        fgt_password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btnLogin.animate().translationY(0).alpha(1).setDuration(1200).setStartDelay(600).start();



        // #### CUANDO PULSAMOS EL BOTON DE INGRESO ####
        btnLogin.setOnClickListener(view1 -> {

            // ## Obtenemos los datos desde editText instanciado mas arriba
            String loginEmail = login_email.getText().toString();
            String loginPassword = login_password.getText().toString();

            // #### Condiciones: ####
            // ## 1- si la contrasena es menor a 6, enviar toast ##
            if(loginPassword.length() >= 6){
                // ## Utilizamos el metodo login para acceder con las credenciales proporcionadas
                login(loginEmail, loginPassword);
            }
            else {
                Toast.makeText(getContext(), "La contrasena es muy corta", Toast.LENGTH_LONG).show();
            }

        });

        return view;
    }

    // #### METODO PRINCIPAL DE INGRESO POR EMAIL Y CONTRASENA ####
    public void login(String email, String password){

        // ## Utilizamos el metodo signInWithEmailAndPassword de FirebaseAuth, y le agregamos un listener para ver si el registro fue exitoso
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(requireActivity(), task->{

        // ## Si el ingreso fue exitoso haremos lo siguiente:
            if (task.isSuccessful()){
                // ## Indicamos a traves de un toast que el usuario ingreso exitosamente
                Toast.makeText(getContext(), "Login exitoso, bienvenido", Toast.LENGTH_LONG).show();

                // ## Navegamos a la pagina de inicio
                Intent intent_ = new Intent(getContext(), DashboardUserActivity.class);
                startActivity(intent_);
            }
            // ## Si tenemos errores mostramos un Toast
            else{
                String errorMessage = Objects.requireNonNull(task.getException()).getLocalizedMessage();
                Toast.makeText(getContext(), "Hubo un error"+errorMessage, Toast.LENGTH_LONG).show();
            }

        });

    }
}