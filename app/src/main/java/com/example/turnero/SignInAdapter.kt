package com.example.turnero

import android.content.Context
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.turnero.LoginTabFragment
import com.example.turnero.SignUpTabFragment

//ESTE CODIGO NECESITA REVISION!!!!

// tuvimos que crear un adaptador para manejar las tabs del SignInActivity
class SignInAdapter(
    fm: FragmentManager?,
    private val context: Context,
    var totalTabs: Int
) : FragmentPagerAdapter( //esto esta deprecated, tenemos que ver como lo resolvemos!!
    fm!!
) {
    override fun getCount(): Int {
        return totalTabs
    } // basicamente ese metodo nos cuenta las cantidad de tabs

    override fun getItem(@NonNull position: Int): Fragment { // anote que no sera null, ya que sabemos que no lo sera!
        return when (position) {
            0 -> {
                LoginTabFragment() // caso 1 ver la pagina login
            }
            1 -> {
                SignUpTabFragment() // caso 2 ver la pagina de register
            }
            else -> LoginTabFragment() // me pide un else, asi que le dije que siempre muestre el login
        }
    }
}