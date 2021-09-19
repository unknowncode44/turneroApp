package com.example.turnero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DashboardUserActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HorizontalRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_user)

        recyclerView = findViewById(R.id.recycler_dr_cards)
        adapter = HorizontalRecyclerView()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter


    }
}