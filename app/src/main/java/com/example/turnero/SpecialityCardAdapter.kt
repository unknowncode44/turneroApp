package com.example.turnero


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SpecialityCardAdapter(private val specialityList: List<Speciality>): RecyclerView.Adapter<SpecialityCardAdapter.SpecialityCardViewHolder>()  {

    //on create view holder nos traer el diseno de la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityCardAdapter.SpecialityCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.speciality_icon_card, parent, false)
        return SpecialityCardViewHolder(view)
    }
    override fun onBindViewHolder(holder: SpecialityCardAdapter.SpecialityCardViewHolder, position: Int) {

        val currentItem = specialityList[position]
        holder.specialityName.text = currentItem.name
    }

    // este metodo cuenta la cantidad de tarjetas que se mostraran
    override fun getItemCount(): Int {
        // ##   AQUI IMPLEMENTAMOS LA CANTIDAD DE TARJETAS, ESTO LO PODEMOS DEFINIR DESDE LA BASE DE DATOS
        return specialityList.size
    }

    class SpecialityCardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val specialityName: TextView = itemView.findViewById(R.id.speciality_name)

    }
}