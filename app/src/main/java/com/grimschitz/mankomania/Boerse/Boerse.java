package com.grimschitz.mankomania.Boerse;

import com.grimschitz.mankomania.PlayerLogic.Player;

public class Boerse
{
    private Player player;
    private int shareSteel;
    private int shareOil;
    private int sharePower;

    private Boerse[] otherPlayersBoerse;


    public Boerse(Player p) {
        this.player = p;
        this.shareOil = 2;
        this.sharePower = 2;
        this.shareSteel = 2;

    }


    public void addShare(int amount, int shareType){
        if(shareType==1) shareSteel++;
        if(shareType==2) shareOil++;
        if(shareType==3) sharePower++;

    }
    public void delShare(int amount, int shareType){
        if(shareType==1){
            if (shareSteel!=0) shareSteel--;
        }
        if(shareType==2){
            if (shareOil!=0) shareOil--;
        }
        if(shareType==3){
            if (sharePower!=0) sharePower--;
        }
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

    public void boerseEvent(){
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
    private void updateBoerse(){
        //TODO: Sync with Server
        //getOtherPlayersShars
        //forEachPlayer update Shares

    }

}
