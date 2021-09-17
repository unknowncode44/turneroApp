package com.example.turnero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import java.util.ArrayList

class DashboardUserActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager;
    lateinit var adapter: Adapter;
    lateinit var model: List<Model>;





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_user)

        model = ArrayList();
        (model as ArrayList<Model>).add(Model(R.drawable.h_cipo, "Hospital",));
        (model as ArrayList<Model>).add(Model(R.drawable.schedule, "Hospital",));
        (model as ArrayList<Model>).add(Model(R.drawable.logo, "Hospital",));

        adapter = Adapter(model, this);


        viewPager.adapter = adapter;
        viewPager.setPadding(130, 0, 130, 0);
    }
}