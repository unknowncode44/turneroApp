package com.example.turnero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turnero.adapters.DoctorCardAdapter
import com.example.turnero.adapters.OnlineDoctorsAdapter
import com.example.turnero.adapters.SpecialityCardAdapter
import com.example.turnero.dataclass.OnlineDoctor
import com.example.turnero.dataclass.Profesional
import com.example.turnero.dataclass.Speciality
import com.example.turnero.databinding.DashboardUserBarBinding
import com.google.firebase.database.*


class DashboardUserActivity : AppCompatActivity(){
    lateinit var dbRef : DatabaseReference
    lateinit var doctorCardsRecyclerView: RecyclerView
    lateinit var specialitiesRecyclerView: RecyclerView
    lateinit var availableRecyclerView: RecyclerView
    lateinit var professionalArrayList: ArrayList<Profesional>
    lateinit var specialitiesArrayList: ArrayList<Speciality>
    lateinit var onlineArrayList: ArrayList<OnlineDoctor>
    lateinit var adapter: DoctorCardAdapter
    private lateinit var binding: DashboardUserBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DashboardUserBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding)

        val ab: ActionBar? = supportActionBar
        if(ab != null){
            ab.setHomeAsUpIndicator(R.drawable.nav_icon)
            ab.setDisplayHomeAsUpEnabled(true)
            ab.title = "Nombre de Usuario"
        }

        //doctorCardsRecyclerView = findViewById(R.id.recycler_dr_cards)
        //doctorCardsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //doctorCardsRecyclerView.setHasFixedSize(true)

        //specialitiesRecyclerView = findViewById(R.id.specialitiesRecyclerView)
        //specialitiesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //specialitiesRecyclerView.setHasFixedSize(true)

        //availableRecyclerView = findViewById(R.id.available_doctor_recycler)
        //availableRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //specialitiesRecyclerView.setHasFixedSize(true)


        //specialitiesArrayList = arrayListOf<Speciality>()
        //professionalArrayList = arrayListOf<Profesional>()
       // onlineArrayList = arrayListOf<OnlineDoctor>()

        //getProfesionalData()
        //getSpecialityData()
        //getAvailableDoctor()


    }

    private fun toolbarFun(toolbar: Toolbar){

    }

    private fun getProfesionalData() {
        dbRef = FirebaseDatabase.getInstance().getReference("users/professionals")
        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (professionalSnapshot in snapshot.children){
                        val professionals = professionalSnapshot.getValue(Profesional::class.java)
                        professionalArrayList.add(professionals!!)
                    }
                    doctorCardsRecyclerView.adapter = DoctorCardAdapter(professionalArrayList)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    private fun getSpecialityData() {
        dbRef = FirebaseDatabase.getInstance().getReference("specialities")
        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (specialitySnapshot in snapshot.children){
                        val specialities = specialitySnapshot.getValue(Speciality::class.java)
                        specialitiesArrayList.add(specialities!!)
                    }
                    specialitiesRecyclerView.adapter = SpecialityCardAdapter(specialitiesArrayList)
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
    private fun getAvailableDoctor() {
        dbRef = FirebaseDatabase.getInstance().getReference("online")
        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (onlineSnapshot in snapshot.children){
                        val online = onlineSnapshot.getValue(OnlineDoctor::class.java)
                        if (online != null) {
                            onlineArrayList.add(online)
                        }
                    }
                    availableRecyclerView.adapter = OnlineDoctorsAdapter(onlineArrayList)
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}