package com.grimschitz.mankomania.Boerse;

import com.grimschitz.mankomania.PlayerLogic.Player;

public class Boerse
{
    private Player player;
    private int shareSteel;
    private int shareOil;
    private int sharePower;


    public Boerse(Player p) {
        this.player = p;
        this.shareOil = 2;
        this.sharePower = 2;
        this.shareSteel = 2;

    }


    private void addShare(int amount, int shareType){
        if(shareType==1) shareSteel++;
        if(shareType==2) shareOil++;
        if(shareType==3) sharePower++;

    }
    private void delShare(int amount, int shareType){
        if(shareType==1) shareSteel--;
        if(shareType==1) shareOil--;
        if(shareType==1) sharePower--;
    }

    private void boerseEvent(){
        int shareType = (int)(Math.random() * 3 + 1);
        int raiseFall = (int)(Math.random() * 2 + 1);
        //TODO: For each connected Player, Check how many Shares of selected Type Player has/Check if Rais or Fall/Edit Money of Player Element
    }

}
