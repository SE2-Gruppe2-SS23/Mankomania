package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.BoardLogic.Board;
import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.client.GameState;

public class Game {
    public static Board board;
    private static Game instance;

    public GameState currentState = GameState.LOBBY_WAITING;

    public Player[] players = new Player[4];

    public Game(){
        board = new Board();

//            TODO: can we do this at a later point?

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
