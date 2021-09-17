package com.example.turnero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.turnero.databinding.ActivityLoginBinding
import com.example.turnero.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    // view binding: para reemplazar el metodo find view by id vamos a usar la funcion binding view
    // de esta manera mejoramos la fluidez en la navegacion
    // documentacion: https://developer.android.com/topic/libraries/view-binding?hl=es-419

//    // definimos variables para la creacion de usuario
//    var userName = findViewById<EditText>(R.id.nameEt)
//    var userEmail = findViewById<EditText>(R.id.emailEt)
//    var userPassword = findViewById<EditText>(R.id.passwordEt)
//    var repeatUserPassword = findViewById<EditText>(R.id.repeatPasswordEt)
//
//    // creamos la variable auth para manjar las instancias de firebase auth
//    private lateinit var auth: FirebaseAuth

    // creamos la variable binding diciendo que es una instancia de la clase ActivityMainBinding
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //

        super.onCreate(savedInstanceState)

        // llamamos instanciamos la variable con el metodo inflate de la clase ActivityMainBinding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener{
            startActivity(Intent(this, DashboardUserActivity::class.java))
        }
        binding.backBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}