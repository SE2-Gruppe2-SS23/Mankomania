package com.grimschitz.mankomania.Launchers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.grimschitz.mankomania.Game;
import com.grimschitz.mankomania.GlobalAssets;
import com.grimschitz.mankomania.R;
import com.grimschitz.mankomania.Screens.LoadScreen;
import com.grimschitz.mankomania.Screens.StartScreen;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        GlobalAssets.nextScreen = StartScreen.class;
        Game mankomania = new Game();

        Intent nextScreen = new Intent(Launcher.this, LoadScreen.class);
        this.startActivity(nextScreen);
    }
}