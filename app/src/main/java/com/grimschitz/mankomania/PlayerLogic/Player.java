package com.grimschitz.mankomania.PlayerLogic;

import com.grimschitz.mankomania.FieldLogic.Field;

import java.util.HashMap;

public class Player {

    private int playerIndex;
    private String playerSocket;
    private int money;
    private Field currentPosition;
    private HashMap<Share,Integer> shares;
    private int dices = 0;

    public Player(){
        money = 1000000;
        shares = new HashMap<Share,Integer>();
    }

    public Player(Field initialField, int playerIndex, String playerSocket){
        money = 1000000;
        shares = new HashMap<Share,Integer>();
        this.playerIndex = playerIndex;
        currentPosition = initialField;
        this.playerSocket = playerSocket;
    }

    //------------GETTERS------------------
    //public int getDices(){return dices;}

    //-------------------------------------
    //------------SETTERS------------------
    //public void setDices(int dices){this.dices = dices;}
    //-------------------------------------
}
