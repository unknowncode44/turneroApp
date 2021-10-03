package com.example.turnero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TableLayout
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
        tabLayout = findViewById(R.id.tab_layout)
        viewPager= findViewById(R.id.view_pager)
        fb = findViewById(R.id.imageButton_facebook)
        googleBtn = findViewById(R.id.imageButton_google)
        instBtn = findViewById(R.id.imageButton_instagram)



        // le damos gravity a las tabs usando el atributo GRAVITY_FILL, esto lo hacemos para que la vista de las tabs ocupen casi toda la pantalla.
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        // creamos las tabs que usaremos, una para el Login y otra para el Register
        tabLayout.addTab(tabLayout.newTab().setText("Ingresa"))
        tabLayout.addTab(tabLayout.newTab().setText("Registrate"))

        // instanciamos el adaptador que creamos
        val adapter: SignInAdapter = SignInAdapter(supportFragmentManager, this, tabLayout.tabCount);
        viewPager.adapter = adapter;

        // agregamos la escucha para cuando haya cambios de tab
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))


        fb.translationY = -100F;
        googleBtn.translationY = -100F;
        instBtn.translationY = -100F;
        tabLayout.translationY = 200F;

        fb.alpha = 0F;
        googleBtn.alpha = 0F;
        instBtn.alpha = 0F;
        tabLayout.alpha = 0F;


        fb.animate().translationY(tY).alpha(alph).setDuration(1000).setStartDelay(400).start();
        googleBtn.animate().translationY(tY).alpha(alph).setDuration(1000).setStartDelay(600).start();
        instBtn.animate().translationY(tY).alpha(alph).setDuration(1000).setStartDelay(800).start();
        tabLayout.animate().translationY(tY).alpha(alph).setDuration(1000).setStartDelay(100).start();





    }
}

