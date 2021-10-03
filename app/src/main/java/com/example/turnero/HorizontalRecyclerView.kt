package com.example.turnero
import android.view.LayoutInflater //importamos esta libreria ya que usaremos el metodo inflate para mostrar nuestras cards
import android.view.View // Necesitamos importar view para la clase MyViewHolder - con esto manipularemos las vistas que deseamos mostrar
import android.view.ViewGroup // se nos importa al crear los getters de la clase Horizontal_RecyclerView
import androidx.recyclerview.widget.RecyclerView // importamos la libreria que nos proporciona el recycler view


// creamos clase que extiende RecyclerView.Adapter, adicionalmente creamos la sub-clase MyViewHolder para manejar las vistas
class HorizontalRecyclerView: RecyclerView.Adapter<HorizontalRecyclerView.MyViewHolder>() {


    //on create view holder nos traer el diseno de la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_doctor_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }


    // este metodo cuenta la cantidad de tarjetas que se mostraran
    override fun getItemCount(): Int {
        // ##   AQUI IMPLEMENTAMOS LA CANTIDAD DE TARJETAS, ESTO LO PODEMOS DEFINIR DESDE LA BASE DE DATOS
        return 5
    }


    // subclase MyViewHolder se encargara de manejara los datos que mostraremos en la tarjeta.
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}