package com.example.turnero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {
    private List<Model> model;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_items, container, false);
        ImageView imageView;
        TextView cardTitle;
        Button button;

        imageView = view.findViewById(R.id.imagenClinica);
        cardTitle = view.findViewById(R.id.title);
        button = view.findViewById(R.id.speciality_btn);

        imageView.setImageResource(model.get(position).getImage());
        cardTitle.setText(model.get(position).getTitle());

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
