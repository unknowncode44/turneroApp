package com.example.turnero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.turnero.databinding.ActivityLoginBinding
import com.example.turnero.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    // view binding: para reemplazar el metodo find view by id vamos a usar la funcion binding view
    // de esta manera mejoramos la fluidez en la navegacion
    // documentacion: https://developer.android.com/topic/libraries/view-binding?hl=es-419

    // creamos la variable binding diciendo que es una instancia de la clase ActivityMainBinding
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // llamamos instanciamos la variable con el metodo inflate de la clase ActivityMainBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener{
            startActivity(Intent(this, DashboardUserActivity::class.java))
        }
        binding.backBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }



    }
}