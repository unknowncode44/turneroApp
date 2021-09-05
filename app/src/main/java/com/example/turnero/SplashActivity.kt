package com.example.turnero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // creamos una funcion para que la pantalla splash dure 3 segundos. Usamos la funcion handler.
        // pasamos la funcion startActivity y le pasamos el intent del main activity, para que cuando haya transcurrido los 3 segundos
        // navegue a esa pagina

        Handler(Looper.getMainLooper()).postDelayed(Runnable { startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000) // 3000 milisegundos = 3 segundos


    }
}