package com.example.turnero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.turnero.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    // view binding: para reemplazar el metodo find view by id vamos a usar la funcion binding view
    // de esta manera mejoramos la fluidez en la navegacion
    // documentacion: https://developer.android.com/topic/libraries/view-binding?hl=es-419
    private lateinit var binding: ActivityRegisterBinding

    // creamos la variable auth para manejar las instancias de firebase auth
    private lateinit var auth: FirebaseAuth
    // creamos la variable para manejar la base de datos
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {

        // creamos variables para trabajar
        var userName: EditText
        var userEmail: EditText
        var userPassword: EditText
        var repeatUserPassword: EditText

        super.onCreate(savedInstanceState)
        //creamos una nueva instancia de la base de datos
        database = Firebase.database.reference

        //creamos una nueva instancia de firebaseAuth para gestionar el registro de usuarios
        auth = FirebaseAuth.getInstance()

        // instanciamos la variable con el metodo inflate de la clase ActivityMainBinding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // definimos las acciones que realizaremos al tocar el boton de registro
        binding.registerBtn.setOnClickListener{
            // asignamos los valores de los campos a las variables creadas

            userName = findViewById<EditText>(R.id.nameEt) as EditText // no debemos olvidar pasarlo a string cuando lo utilicemos
            userEmail = findViewById<EditText>(R.id.loginEmailEt) as EditText // no debemos olvidar pasarlo a string  cuando lo utilicemos
            userPassword = findViewById<EditText>(R.id.loginPasswordEt) as EditText // no debemos olvidar pasarlo a string  cuando lo utilicemos
            repeatUserPassword = findViewById<EditText>(R.id.repeatPasswordEt) as EditText // no debemos olvidar pasarlo a string  cuando lo utilicemos

            // creamos una condicion para revisar si la contrasena es mayor o igual a 6 caracteres
            if (userPassword.text.length >= 6){
                // anidamos otra condicion solo para corroborar que las contrasenas coinciden
                if (userPassword.text.toString() == repeatUserPassword.text.toString()){
                    // si es true, usamos la funcion para la creacion de usuario
                    createAccount(userEmail.text.toString(), userPassword.text.toString(), userName.text.toString())
                }else{
                    // si las contrasenas no coinciden mostramos un toast
                    Toast.makeText(baseContext, repeatUserPassword.text.toString(), Toast.LENGTH_SHORT).show()
                }
            }else{
                // si la contrasena es menor a 6 caracteres mostramos un toast
                Toast.makeText(baseContext, "La contrasena debe ser mayor a 6 caracteres!",  Toast.LENGTH_SHORT).show()
            }
        }
        // si queremos navegar hacia la pantalla anterior solo debemos asignar el boton
        binding.backBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    // esta funcion es la que creara la nueva cuenta, le pasaremos los parametros capturados desde los EditText
    private fun createAccount (email: String, password: String, name: String) {
        // utilizamos el metodo createUser FirebaseAuth, y le agregamos un listener para ver si el registro fue exitoso
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){ task ->

            // si fue exitoso haremos lo siguiente:
            if (task.isSuccessful) {
                // una vez generado el usuario capturamos su token (llamado UID - que es un identificador unico del usuario)
                val uid = auth.currentUser!!.uid
                // creamos un objeto con el nombre y el email capturados a fin de guardarlos en la base de datos
                val user = User(name, email)
                // procedemos a guardar los datos en nuestra base de datos, en el nodo "users", creando un nuevo nodo con el UID, y almacenamos dentro el objeto user
                database.child("users").child(uid).setValue(user)
                // indicamos a traves de un toast que el usuario fue creado exitosamente
                Toast.makeText(baseContext, "Se creo el usuario exitosamente.", Toast.LENGTH_SHORT).show()
                // navegamos a la pagina de inicio
                startActivity(Intent(this, DashboardUserActivity::class.java))


            // si hubieron errores los mostramos por el toast
            } else {
                var errorMessage: String? = task.exception?.localizedMessage
                Toast.makeText(baseContext, "error: $errorMessage, email: $email", Toast.LENGTH_LONG).show()
            }

        }
    }

}
// esta clase la usamos para generar un objeto con los datos principales del usuario: Nombre y Email.
@IgnoreExtraProperties
data class User(val username: String? = null, val email: String? = null) {

}