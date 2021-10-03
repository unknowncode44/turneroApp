package com.example.turnero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.turnero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // view binding: para reemplazar el metodo find view by id vamos a usar la funcion binding view
    // de esta manera mejoramos la fluidez en la navegacion
    // documentacion: https://developer.android.com/topic/libraries/view-binding?hl=es-419

    // creamos la variable binding diciendo que es una instancia de la clase ActivityMainBinding
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        

        // llamamos instanciamos la variable con el metodo inflate de la clase ActivityMainBinding ......
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //manejar cuando tocan el boton de registro
        binding.loginBtn.setOnClickListener{
            startActivity(Intent(this, SignInActivity::class.java))
        }

        //manejar cuando tocan el boton de registro
        binding.registerBtn.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}