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
import android.widget.Toast;

// DATABINDING
import com.example.turnero.databinding.FragmentTabRegisterBinding;

// FIREBASE
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// JAVA
import java.util.Objects;



public class TabRegisterFragment extends Fragment {

    // VARIABLES MAIN
    private FirebaseAuth auth;
    private DatabaseReference database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        com.example.turnero.databinding.FragmentTabRegisterBinding binding = FragmentTabRegisterBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // ## Obtenemos las instancias de Auth y de Firebase RTDB
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

        // ## Creamos e instanciamos las variables donde obtendremos los datos de registro
        final View fragmentBody = view.findViewById(R.id.register_fragmentBody);
        final Button btnRegister = view.findViewById(R.id.btnRegister2);
        final EditText register_email = view.findViewById(R.id.register_email);
        final EditText register_name = view.findViewById(R.id.register_name);
        final EditText register_password = view.findViewById(R.id.register_password);
        final EditText register_confirm_password = view.findViewById(R.id.register_confirm_password);

        // ## Utilidad para esconder el teclado cuando tocamos otra parte de la pantalla
        Utilities.setupUI(fragmentBody, getActivity());

        // #### CUANDO PULSAMOS EL BOTON DE REGISTRO ####
        btnRegister.setOnClickListener(view1 -> {

            //!!! IMPORTANTE: LOS DATOS DE LOS EDITTEXT SE CAPTURAN DENTRO DEL METODO ONCLICKLISTENER!!, EVITA ERRORES COMO LOS MIOS :'( !!!

            // ## Obtenemos los datos desde editText instanciado mas arriba
            String registerEmail = register_email.getText().toString();
            String registerName = register_name.getText().toString();
            String registerPassword = register_password.getText().toString();
            String register_C_Password = register_confirm_password.getText().toString();

            // #### Condiciones: ####
            // ## 1- si la contrasena es menor a 6, enviar toast ##
             if(registerPassword.length() >= 6) {

                 // ## 2- si la contrasena no coincide con la confirmacion de la contrasena, enviar toast ##
                 if (registerPassword.equals(register_C_Password)) {

                     // ## Si pasamos las dos condiciones, ejecutamos el metodo createAccount y navegamos a la siguiente pagina ##
                     createAccount(registerEmail, registerPassword, registerName);
                 } else {
                     Toast.makeText(getContext(), "Las contrasenas no coinciden", Toast.LENGTH_LONG).show();
                 }
             }
             else {
                 Toast.makeText(getContext(), "La contrasena es muy corta", Toast.LENGTH_LONG).show();
             }

        });



        return view;
    }

    // #### METODO PRINCIPAL DE REGISTRO Y ALMACENAMIENTO DE DATOS EN FIREBASE RTDB ####
    public void createAccount(String email, String password, String name){

        // ## Utilizamos el metodo createUser FirebaseAuth, y le agregamos un listener para ver si el registro fue exitoso
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(requireActivity(), task -> {

            // ## Si fue exitoso haremos lo siguiente:
            if (task.isSuccessful()) {

                // ## Una vez generado el usuario capturamos su token (llamado UID - que es un identificador unico del usuario)
                String uid = Objects.requireNonNull(auth.getCurrentUser()).getUid();

                // ## Creamos un objeto con el nombre y el email capturados a fin de guardarlos en la base de datos
                Object user = new User2(name, email, "x-user");

                // ## Una vez obtenemos el uid lo usamos para guardar el usuario en la base de datos
                database.child("users/users").child(uid).setValue(user);

                // ## Indicamos a traves de un toast que el usuario fue creado exitosamente
                Toast.makeText(getContext(), "Registro correcto, bienvenido", Toast.LENGTH_LONG).show();

                // ## Navegamos a la pagina de inicio
                Intent intent_ = new Intent(getContext(), DashboardUserActivity.class);
                startActivity(intent_);


            }
            // ## Si tenemos errores mostramos un Toast
            else {
                String errorMessage = Objects.requireNonNull(task.getException()).getLocalizedMessage();
                Toast.makeText(getContext(), "Hubo un error"+errorMessage, Toast.LENGTH_LONG).show();
            }
        });

    }



}