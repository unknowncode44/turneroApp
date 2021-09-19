package com.example.turnero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    // creamos la variable auth que gestionara los metodos de inicio de sesion usando el modulo de Auth de Firebase.
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // obtenemos instancia de FirebaseAuth
        auth = FirebaseAuth.getInstance()
        // decimos que si current user esta vacio, el usuario no ha iniciado sesion, con lo cual lo mandamos la pagina de registro o login, usando la funcion debounce.
        if (auth.currentUser != null){
            debounce()
        }
        // si no es nulo, es decir que ya inicio sesion, por lo cual sus datos estan guardados, si ese es el caso lo mandamos a la pagina inicial.
        else {
            startActivity(Intent(this, DashboardUserActivity::class.java))
            finish()
        }




    }
    // creamos una funcion privada para que la pantalla splash dure 3 segundos. Usamos la funcion handler.
    // pasamos la funcion startActivity y le pasamos el intent del main activity, para que cuando haya transcurrido los 3 segundos
    // navegue a esa pagina
    private fun debounce(){
        Handler(Looper.getMainLooper()).postDelayed(Runnable { startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000) // 3000 milisegundos = 3 segundos
    }
}