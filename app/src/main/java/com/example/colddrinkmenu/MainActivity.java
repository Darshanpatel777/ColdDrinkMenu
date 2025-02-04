package com.example.colddrinkmenu;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //         Load initial fragment
//         cusine fragment ma java mate
        if (savedInstanceState == null) {
            loadFragment(new Cusinelistfragment());
        }
    }


    public void loadFragment(Fragment fragment) {

        Log.d("-----------", "loadFragment: pressed");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


    @Override
    public void onBackPressed() {
//        recent fragment check karava mate
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main);

//        cusine fragment ma hoy tyare back avva mate
        if (currentFragment instanceof Cusinelistfragment) {
            finish();
        }
//        recipe fragment ma hoy tyare back cusine fragment ma aavva mate
        else if (currentFragment instanceof Recipelistfragment) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}