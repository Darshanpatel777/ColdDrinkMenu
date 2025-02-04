package com.example.colddrinkmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CuisineAdapter extends BaseAdapter {


    private final Context context;

    private final int[] colddrinkImages = {R.drawable.friut,R.drawable.smoothies,R.drawable.mocktails,R.drawable.milkshakes,
            R.drawable.ice,R.drawable.herbal,R.drawable.energyprotein,R.drawable.exoticunique};

    private final String[] colddrinkNames = {"FruitJuices", "Smoothies", "Mocktails", "Milkshakes", "Iced & Flavored Drinks",
            "Herbal & Detox Drinks", "Energy & Protein Drinks", "Exotic & Unique Drinks"};

    public CuisineAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return colddrinkNames.length;
    }

    @Override
    public Object getItem(int position) {
        return colddrinkNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_colddrink, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.colddrink_image);
        TextView textView = convertView.findViewById(R.id.colddrink_name);

        imageView.setImageResource(colddrinkImages[position]);
        textView.setText(colddrinkNames[position]);

        return convertView;
    }

}
