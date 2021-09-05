package com.example.turnero

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter as Adapter

////class MyAdapter (private val mDataSet: Array)
////    : Adapter() {
//
//    // En este ejemplo cada elemento consta solo de un nombre
//    class ViewHolder(var textView: TextView) : RecyclerView.ViewHolder(textView)
//
//    // El layout manager invoca este método para renderizar cada elemento
//    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val v = LayoutInflater.from(parent.context)
//            .inflate(R.layout.activity_dashboard_user, parent, false) as TextView
//
//        // Aquí podemos definir tamaños, márgenes, paddings, etc
//        return ViewHolder(v)
//    }
//
//    // Este método asigna valores para cada elemento de la lista
//    fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.textView.text = mDataSet[position]
//    }
//
//    // Cantidad de elementos del RecyclerView
//    // Puede ser más complejo (por ejm, si implementamos filtros o búsquedas)
//    fun getItemCount() = mDataSet.size
//}
