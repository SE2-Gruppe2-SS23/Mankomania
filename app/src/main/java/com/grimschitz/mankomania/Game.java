package com.grimschitz.mankomania;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.Screens.LoadScreen;
import com.grimschitz.mankomania.Screens.StartScreen;

public class Game extends AppCompatActivity {
    private static Game instance;
    //private Board board;

    public static Game getInstance(){
        if(instance == null){instance = new Game();}
        return instance;
    }


    public void create(){
       // board = new Board();
        createActivity(new LoadScreen(new StartScreen()));
    }


    public void createActivity(AppCompatActivity nextActivity){
        Intent nextScreen = new Intent(this,nextActivity.getClass());
        this.startActivity(nextScreen);
    }
}
