package com.example.colddrinkmenu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class Recipelistfragment extends Fragment {


    private static final String ARG_CUISINE_INDEX = "cold-drink_index";

    public static Recipelistfragment newInstance(int cuisineIndex) {
        Recipelistfragment fragment = new Recipelistfragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CUISINE_INDEX, cuisineIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TabLayout tabLayout = view.findViewById(R.id.tb);
        ViewPager viewPager = view.findViewById(R.id.cloddrink_view_pager);

        if(getArguments() != null) {
            int cuisineIndex = getArguments().getInt(ARG_CUISINE_INDEX);

            RecipePagerAdapter adapter = new RecipePagerAdapter(getContext(), cuisineIndex);
            viewPager.setAdapter(adapter);

            for (String recipeName : adapter.getColdDrinkNames(cuisineIndex)) {
                tabLayout.addTab(tabLayout.newTab().setText(recipeName));
            }
        }
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
//            je tab open 6e te tab nu name recipe name page na center aave mate
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                return keyCode == KeyEvent.KEYCODE_BACK;
            }
        } );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recipelistfragment, container, false);

        return view;
    }
}