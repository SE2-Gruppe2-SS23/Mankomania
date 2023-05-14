package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.BoardLogic.Board;
import com.grimschitz.mankomania.PlayerLogic.Player;

public class Game extends AppCompatActivity {
    private static Game instance;

    public Boolean lobbyReady = false;

    public Player[] players = new Player[4];

    public Game(){
        Board board = new Board();
    }
    public static Game getInstance(){
        if(instance == null){instance = new Game();}
        return instance;
    }




}
