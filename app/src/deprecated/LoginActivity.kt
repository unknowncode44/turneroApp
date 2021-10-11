package com.example.turnero

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.turnero.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    // view binding: para reemplazar el metodo find view by id vamos a usar la funcion binding view
    // de esta manera mejoramos la fluidez en la navegacion
    // documentacion: https://developer.android.com/topic/libraries/view-binding?hl=es-419

    private lateinit var auth: FirebaseAuth


    // creamos la variable binding diciendo que es una instancia de la clase ActivityMainBinding
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var userEmail: EditText
        var userPassword: EditText

        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()


        // llamamos instanciamos la variable con el metodo inflate de la clase ActivityMainBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener{
            userEmail = findViewById<EditText>(R.id.loginEmailEt) as EditText // no debemos olvidar pasarlo a string  cuando lo utilicemos
            userPassword = findViewById<EditText>(R.id.loginPasswordEt) as EditText // no debemos olvidar pasarlo a string  cuando lo utilicemos
            signIn(userEmail.text.toString(), userPassword.text.toString())
//            startActivity(Intent(this, DashboardUserActivity::class.java))
        }
        binding.backBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }



    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){ task ->
            if (task.isSuccessful) {
                Toast.makeText(baseContext, "Ingreso Correcto, Bienvenido!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardUserActivity::class.java))

            } else {
                var errorMessage: String? = task.exception?.localizedMessage
                Log.d(TAG, "$email", task.exception)
                Log.d(TAG, "$password", task.exception)
                Log.w(TAG, "falla", task.exception)
                Toast.makeText(baseContext, "error: $errorMessage", Toast.LENGTH_LONG).show()
            }

        }
    }


}