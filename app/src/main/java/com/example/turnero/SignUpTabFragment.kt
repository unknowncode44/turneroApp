package com.example.turnero

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.turnero.R
import kotlinx.android.synthetic.main.login_tab_fragment.view.*

class SignUpTabFragment : Fragment() {
    private lateinit var viewOfLayout: View // esto nos va a ayudar a instanciar variables
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewOfLayout = inflater.inflate(R.layout.signup_tab_fragment, container, false) as ViewGroup;

        return viewOfLayout
    }
}