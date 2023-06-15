package com.grimschitz.mankomania.PlayerLogic;

import com.grimschitz.mankomania.Boerse.Boerse;
import com.grimschitz.mankomania.FieldLogic.Field;
import com.grimschitz.mankomania.ShareLogic.Share;

import java.security.SecureRandom;
import java.util.HashMap;

public class Player {

    private int playerIndex;
    private String name;
    private int money;
    private Field currentPosition;


    private int curPosition;

    private HashMap<Share,Integer> shares;
    private int dices = 0;

    private Boerse boerse;
    private int[] raceRoll = new int[8];

    public Player(){
        money = 1000000;
        shares = new HashMap<Share,Integer>();
        boerse = new Boerse(this);
    }

    public Player(Field initialField, int playerIndex, String name){
        money = 1000000;
        shares = new HashMap<Share,Integer>();
        SecureRandom secRand = new SecureRandom();
        setInitialRandomShares(secRand.nextInt(3 - 1) + 1);
        this.playerIndex = playerIndex;
        currentPosition = initialField;
        this.name = name;
    }

    //------------GETTERS------------------
    public int getDices(){return dices;}
    public int getPlayerIndex(){return playerIndex;}
    public String getName(){return name;}
    public int getMoney(){return money;}
    public int getShareAmount(Share name){return shares.get(name);}
    public Field getCurrentPosition(){return currentPosition;}
    public int getCurPosition(){return curPosition;}
    public Boerse getPlayerBoerse(){return boerse;}
    public int[] getRaceRoll(){return raceRoll;}
    //-------------------------------------
    //------------SETTERS------------------
    public void setDices(int dices){this.dices = dices;}
    public void setCurrentPosition(Field field){this.currentPosition = field;}
    public void setName(String name){this.name = name;}
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

    public void setInitialRandomShares(int shareIndex) {
        switch (shareIndex) {
            case 1:
                shares.put(Share.DRY_OIL_PLC, 0);
                shares.put(Share.SHORT_CIRCUIT_PLC, 0);
                break;

            case 2:
                shares.put(Share.DRY_OIL_PLC, 0);
                shares.put(Share.HARD_STEEL_PLC, 0);
                break;

            case 3:
                shares.put(Share.HARD_STEEL_PLC, 0);
                shares.put(Share.SHORT_CIRCUIT_PLC, 0);
                break;

            default:
                break;

        }
    }
}
