package com.example.turnero;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Utilities {

    public static void setupUI(View view, Activity activity) {
        // si estamos no estamos en una instancia de EditText y tocamos la pantalla, el teclado se escondera.
        if(! (view instanceof EditText)) {
            // colocamos una escucha para detectar los toques en la pantalla
            view.setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint("ClickableViewAccessibility")
                @Override
                // si hay toques, llamamos al metodo hideSoftKeyboard
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    hideSoftKeyboard(activity);
                    return false;
                }
            });
        }
        // lo mismo si estamos en una instancia de viewgroup
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                //setupUI(innerView);
            }
        }
    }

    // metodo para esconder el teclado, usando el InputMethodManager que es la funcionalidad nativa de accesibilidad
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }




}
