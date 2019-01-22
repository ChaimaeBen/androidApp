package com.example.chai1.androidapp;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    //android documentatie:https://developer.android.com/training/basics/fragments/fragment-ui
    //create fragment dynamisch om de fragments van main te kunnen vervangen
    // via xml object is niet mglijk https://stackoverflow.com/questions/45002974/replacing-fragments-in-android-studio
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager =getSupportFragmentManager();

        if(findViewById(R.id.frame_main)!=null){
            if(savedInstanceState!=null){
                return;
            }
            //add Homefragment to mainActivity
            fragmentManager.beginTransaction().add(R.id.frame_main,new HomeFragment()).commit();

        }
    }
}
