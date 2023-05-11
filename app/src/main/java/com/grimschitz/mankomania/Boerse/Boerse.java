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
        if(shareType==2) shareOil--;
        if(shareType==3) sharePower--;
    }

    public int getShareSteel() {
        return shareSteel;
    }

    public int getShareOil() {
        return shareOil;
    }

    public int getSharePower() {
        return sharePower;
    }

    private void boerseEvent(){
        int shareType = (int)(Math.random() * 3 + 1);
        int raiseFall = (int)(Math.random() * 2 + 1);
        //TODO:Animation
        switch (shareType){
            case 1:
                if(raiseFall==1) player.addMoney(shareSteel*10000);
                else player.loseMoney(shareOil*10000);
                break;
            case 2:
                if(raiseFall==1) player.addMoney(shareOil*10000);
            else player.loseMoney(shareOil*10000);
                break;
            case 3:
                if(raiseFall==1) player.addMoney(sharePower*10000);
                else player.loseMoney(shareOil*10000);
                break;
        }

    }

}
