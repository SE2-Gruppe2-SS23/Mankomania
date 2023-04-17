package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.grimschitz.mankomania.R;

public class LoadScreen extends AppCompatActivity {


    public LoadScreen(AppCompatActivity nextScreen){
        //super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        setContentView(R.layout.activity_load_screen);
        handler.postDelayed(() -> createActivity(nextScreen), 5000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
    }

    public void createActivity(AppCompatActivity nextActivity){
        Intent nextScreen = new Intent(this,nextActivity.getClass());
        this.startActivity(nextScreen);
    }
}