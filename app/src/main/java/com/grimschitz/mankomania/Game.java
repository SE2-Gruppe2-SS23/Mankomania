package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;
import com.grimschitz.mankomania.PlayerLogic.Player;

public class Game extends AppCompatActivity {
    private static Game instance;
    //private Board board;

    public Boolean lobbyReady = false;

//    public Player[] players = new Player[4];

    public Game(){}
    public static Game getInstance(){
        if(instance == null){instance = new Game();}
        return instance;
    }




}
