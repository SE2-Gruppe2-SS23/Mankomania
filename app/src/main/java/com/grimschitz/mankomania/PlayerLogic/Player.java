package com.grimschitz.mankomania.PlayerLogic;

import com.grimschitz.mankomania.FieldLogic.Field;
import com.grimschitz.mankomania.ShareLogic.Share;

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
    public int getDices(){return dices;}
    public int getPlayerIndex(){return playerIndex;}
    public String getPlayerSocket(){return playerSocket;}
    public int getMoney(){return money;}
    public int getShareAmount(Share name){return shares.get(name);}
    public Field getCurrentPosition(){return currentPosition;}
    //-------------------------------------
    //------------SETTERS------------------
    public void setDices(int dices){this.dices = dices;}
    public void setCurrentPosition(Field field){this.currentPosition = field;}
    public void setPlayerSocket(String playerSocket){this.playerSocket = playerSocket;}
    public void setPlayerIndex(int playerIndex){this.playerIndex = playerIndex;}
    public void setMoney(int money){this.money = money;}
    public void setShares(int hardSteel, int shortCircuit, int dryOil){
        shares.clear();
        shares.put(Share.HARD_STEEL_PLC, hardSteel);
        shares.put(Share.SHORT_CIRCUIT_PLC, shortCircuit);
        shares.put(Share.DRY_OIL_PLC, dryOil);

    }
    //-------------------------------------
    //--------MONEY MANAGEMENT-------------
    public void addMoney(int amount){ money += amount;}
    public void loseMoney(int amount){ money -= amount;}

    public void payToPlayer(Player player, int amount){
        money -= amount;
        player.addMoney(amount);
    }

    //-------------------------------------

    public void moveForward(boolean moveToOptional) {
        Field nextField;
        if (moveToOptional && currentPosition.getOptionalNextField() != null) {
            nextField = currentPosition.getOptionalNextField();
        } else {
            nextField = currentPosition.getNextField();
        }

        currentPosition = nextField;

    }
}
