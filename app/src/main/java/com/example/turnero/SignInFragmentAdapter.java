package com.example.turnero;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SignInFragmentAdapter extends FragmentStateAdapter {
    public SignInFragmentAdapter(FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        creamos un switch para pasar entre tabs
        if (position == 1) {
            return new TabRegisterFragment();
        }


        return new TabLoginFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
