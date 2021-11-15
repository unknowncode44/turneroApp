package com.example.turnero;

import static com.example.turnero.R.id.signIn_ViewPager2;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class SignInActivity2 extends AppCompatActivity {

    // creamos las variables nuestro xml que asignaremos mas abajo
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    SignInFragmentAdapter adapter;

    // variables para los hermosos botones de red social que me dieron dolores de cabeza pero quedaron geniales
    ImageButton fb;
    ImageButton google_icon;
    ImageButton inst;
    float v = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Asignamos las variables
        fb = findViewById(R.id.imageButton_facebook);
        google_icon = findViewById(R.id.imageButton_google);
        inst = findViewById(R.id.imageButton_instagram);
        tabLayout = findViewById(R.id.signInTabLayout);

        // ## Animamos los botones y el tabLayout
        fb.setTranslationX(-800);
        google_icon.setTranslationY(-200);
        inst.setTranslationX(800);
        tabLayout.setTranslationY(100);

        fb.setAlpha(v);
        google_icon.setAlpha(v);
        inst.setAlpha(v);
        tabLayout.setAlpha(v);

        fb.animate().translationX(0).alpha(1).setDuration(1200).setStartDelay(600).start();
        google_icon.animate().translationY(0).alpha(1).setDuration(1200).setStartDelay(600).start();
        inst.animate().translationX(0).alpha(1).setDuration(1200).setStartDelay(600).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1200).setStartDelay(600).start();






        tabLayout = findViewById(R.id.signInTabLayout);
        viewPager2 = findViewById(signIn_ViewPager2);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new SignInFragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("INGRESA"));
        tabLayout.addTab(tabLayout.newTab().setText("REGISTRATE"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}
