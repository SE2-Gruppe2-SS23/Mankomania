package com.grimschitz.mankomania;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.Screens.StartScreen;

public class Game extends AppCompatActivity {
    private static Game instance;
    //private Board board;

    public Game(){}
    public static Game getInstance(){
        if(instance == null){instance = new Game();}
        return instance;
    }




}
