package com.example.turnero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class SignInActivity : AppCompatActivity() {

    // creamos las variables nuestro xml que asignaremos mas abajo
   private lateinit var tabLayout: TabLayout // ponemos pestanas, tabs. documentacion: https://developer.android.com/reference/com/google/android/material/tabs/TabLayout
   lateinit var viewPager: ViewPager // con esto hacemos que los fragments sean deslizables entre pestanas. documentacion: https://developer.android.com/jetpack/androidx/releases/viewpager?hl=en

   // variables para los hermosos botones de red social que me dieron dolores de cabeza pero quedaron geniales
   lateinit var fb: ImageButton // terminamos usando ImageButton, que no es nada mas que un boton con imagen como lo dice su nombre. Documentacion: https://developer.android.com/reference/android/widget/ImageButton
   lateinit var googleBtn: ImageButton
   lateinit var instBtn: ImageButton

   var tY: Float = 0f
    var alph: Float = 1f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Asignamos las variables
        fb = findViewById(R.id.imageButton_facebook)
        googleBtn = findViewById(R.id.imageButton_google)
        instBtn = findViewById(R.id.imageButton_instagram)






        fb.translationY = -100F
        googleBtn.translationY = -100F
        instBtn.translationY = -100F


        fb.alpha = 0F
        googleBtn.alpha = 0F
        instBtn.alpha = 0F



        fb.animate().translationY(tY).alpha(alph).setDuration(1000).setStartDelay(400).start()
        googleBtn.animate().translationY(tY).alpha(alph).setDuration(1000).setStartDelay(600).start()
        instBtn.animate().translationY(tY).alpha(alph).setDuration(1000).setStartDelay(800).start()






    }
}

