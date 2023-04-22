package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.grimschitz.mankomania.GlobalAssets;
import com.grimschitz.mankomania.Launchers.Launcher;
import com.grimschitz.mankomania.R;

public class LoadScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        Handler handler = new Handler();
        Intent nextScreen = new Intent(this, GlobalAssets.nextScreen);

        handler.postDelayed(() -> this.startActivity(nextScreen), 5000);

    }
}