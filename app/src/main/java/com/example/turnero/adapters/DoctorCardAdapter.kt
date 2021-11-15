package com.example.turnero.adapters
import android.view.LayoutInflater //importamos esta libreria ya que usaremos el metodo inflate para mostrar nuestras cards
import android.view.View // Necesitamos importar view para la clase MyViewHolder - con esto manipularemos las vistas que deseamos mostrar
import android.view.ViewGroup // se nos importa al crear los getters de la clase Horizontal_RecyclerView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView // importamos la libreria que nos proporciona el recycler view
import com.example.turnero.dataclass.Profesional
import com.example.turnero.R


// creamos clase que extiende RecyclerView.Adapter, adicionalmente creamos la sub-clase MyViewHolder para manejar las vistas
class DoctorCardAdapter(private val profesionalList: ArrayList<Profesional>): RecyclerView.Adapter<DoctorCardAdapter.DoctorCardViewHolder>() {


    //on create view holder nos traer el diseno de la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_doctor_card, parent, false)
        return DoctorCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorCardViewHolder, position: Int) {

        val currentItem = profesionalList[position]

        holder.ateDays.text = currentItem.ateDays
        holder.ateTime.text = currentItem.ateTime
        holder.doctorName.text = currentItem.name
        holder.doctorSpeciality.text = currentItem.speciality
        holder.matProf.text = currentItem.matProf

    }


    // este metodo cuenta la cantidad de tarjetas que se mostraran
    override fun getItemCount(): Int {
        // ##   AQUI IMPLEMENTAMOS LA CANTIDAD DE TARJETAS, ESTO LO PODEMOS DEFINIR DESDE LA BASE DE DATOS
        return profesionalList.size
    }


    // subclase MyViewHolder se encargara de manejar los datos que mostraremos en la tarjeta.
    class DoctorCardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val doctorName: TextView = itemView.findViewById(R.id.doctor_name)
        val doctorSpeciality: TextView = itemView.findViewById(R.id.speciality)
        val ateDays: TextView = itemView.findViewById(R.id.ate_days)
        val ateTime: TextView = itemView.findViewById(R.id.ate_time)
        val matProf: TextView = itemView.findViewById(R.id.mat_prof)

    }
}