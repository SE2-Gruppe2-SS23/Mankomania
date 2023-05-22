package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.BoardLogic.Board;
import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.client.GameState;

public class Game {
    private static Game instance;
    private static Board board;

    public GameState currentState = GameState.LOBBY_WAITING;

    public Player[] players = new Player[4];

    public Game(){
//            TODO: can we do this at a later point?
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
