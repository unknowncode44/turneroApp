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


class LoginTabFragment : Fragment() {

    // -------------- DECLARAMOS VARIABLES ANTES DEL METODO ON CREATE PARA USARLAS LUEGO ----------- //
    lateinit var emailInp: EditText;
    lateinit var passwordInput: EditText;
    lateinit var loginBtn: Button;
    lateinit var fgtPass: TextView;
    var v:Float = 0F;
    private lateinit var viewOfLayout: View // esto nos va a ayudar a instanciar variables

    // --------------1ER EVENTO: METODO ON CREATE----------- /
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // -------------- INSTANCIAMOS LAS VARIABLES QUE CREAMOS ----------- /
        viewOfLayout = inflater.inflate(R.layout.login_tab_fragment, container, false) as ViewGroup; // primero el view, luego lo instanciamos.
        emailInp = viewOfLayout.findViewById(R.id.login_email);
        passwordInput = viewOfLayout.findViewById(R.id.login_password);
        fgtPass = viewOfLayout.findViewById(R.id.fgtPass);
        loginBtn = viewOfLayout.findViewById(R.id.login_Btn);


        //------------- VAMOS CON LAS ANIMACIONES -------------/

//        emailInp.translationX = 20F;
//        passwordInput.translationX = 800F;
//        fgtPass.translationX = 800F;
//        loginBtn.translationX = 800F;
//
//        emailInp.alpha = v;
//        passwordInput.alpha = v;
//        fgtPass.alpha = v;
//        loginBtn.alpha = v;

        emailInp.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(300).start();
        passwordInput.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(500).start();
        fgtPass.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(500).start();
        loginBtn.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(700).start();


        return viewOfLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        emailInp = view.findViewById(R.id.login_email)
        passwordInput = view.findViewById(R.id.login_password)
        fgtPass = view.findViewById(R.id.fgtPass)
        loginBtn = view.findViewById(R.id.login_Btn)

        //------------- VAMOS CON LAS ANIMACIONES -------------/

//        emailInp.translationX = 200F;
//        passwordInput.translationX = 800F;
//        fgtPass.translationX = 800F;
//        loginBtn.translationX = 800F;
//
//        emailInp.alpha = v;
//        passwordInput.alpha = v;
//        fgtPass.alpha = v;
//        loginBtn.alpha = v;
//
//        emailInp.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(300).start();
//        passwordInput.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(500).start();
//        fgtPass.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(500).start();
//        loginBtn.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(700).start();

    }
}