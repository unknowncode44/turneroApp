package com.example.turnero

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.turnero.adapters.SignInFragmentAdapter
import android.widget.ImageButton
import android.os.Bundle
import com.example.turnero.R.id
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback

class SignInActivity2 : AppCompatActivity() {
    //Instanciamos el adapter
    var adapter: SignInFragmentAdapter? = null

    var v = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // variables para los hermosos botones de red social que me dieron dolores de cabeza pero quedaron geniales
        val fb: ImageButton = findViewById(id.imageButton_facebook)
        val googleIcon: ImageButton = findViewById(id.imageButton_google)
        val inst: ImageButton = findViewById(id.imageButton_instagram)


        val tabLayout: TabLayout = findViewById(id.signInTabLayout)

        // ## Animamos los botones y el tabLayout
        fb.translationX = -800f
        googleIcon.translationY = -200f
        inst.translationX = 800f
        tabLayout.translationY = 100f
        fb.alpha = v
        googleIcon.alpha = v
        inst.alpha = v
        tabLayout.alpha = v
        fb.animate().translationX(0f).alpha(1f).setDuration(1200).setStartDelay(600).start()
        googleIcon.animate().translationY(0f).alpha(1f).setDuration(1200).setStartDelay(600).start()
        inst.animate().translationX(0f).alpha(1f).setDuration(1200).setStartDelay(600).start()
        tabLayout.animate().translationY(0f).alpha(1f).setDuration(1200).setStartDelay(600).start()

        val viewPager2: ViewPager2 = findViewById(id.signIn_ViewPager2)
        val fm = supportFragmentManager
        adapter = SignInFragmentAdapter(fm, lifecycle)
        viewPager2.adapter = adapter
        tabLayout.addTab(tabLayout.newTab().setText("INGRESA"))
        tabLayout.addTab(tabLayout.newTab().setText("REGISTRATE"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}