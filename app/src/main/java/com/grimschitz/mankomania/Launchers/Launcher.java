package com.grimschitz.mankomania.Launchers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.grimschitz.mankomania.Game;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Game.getInstance().create();
    }
}