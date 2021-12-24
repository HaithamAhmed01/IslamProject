package com.example.islamproject.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.islamproject.R;
import com.example.islamproject.fragments.Hadethfragment;
import com.example.islamproject.fragments.Sphafragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Homepage extends AppCompatActivity {
    BottomNavigationView.OnNavigationItemSelectedListener
            onNavigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int id =menuItem.getItemId();
            Fragment fragment=null;
            switch (id){
                case R.id.navigation_quran:{
                    fragment=new SurasActivity();
                    break;
                }
                case R.id.navigation_spha:{
                    fragment=new Sphafragment();
                    break;
                }
                case R.id.navigation_Hadeth:{
                    fragment=new Hadethfragment();
                    break;
                }
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_quran);

    }

}
