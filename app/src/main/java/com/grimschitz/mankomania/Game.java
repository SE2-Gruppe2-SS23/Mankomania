package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.BoardLogic.Board;
import com.grimschitz.mankomania.PlayerLogic.Player;

public class Game extends AppCompatActivity {
    private static Game instance;
    private static Board board;

    public Boolean lobbyReady = false;

    public Player[] players = new Player[4];

    public Game(){
        board = new Board();

        for (Player p: players) {
            board.addPlayer(p);
        }
    }

    public static Board getBoard(){
        return board;
    }
    public static Game getInstance(){
        if(instance == null){instance = new Game();}
        return instance;
    }




}
