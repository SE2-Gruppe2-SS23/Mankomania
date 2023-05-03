package com.grimschitz.mankomania.HorseRaceLogic;

public class RaceTrack {
   private double prizeMultiplier;
   private double winChanceMultiplier;


   public RaceTrack(double prizeMultiplier, double winChanceMultiplier){
       this.prizeMultiplier = prizeMultiplier;
       this.winChanceMultiplier = winChanceMultiplier;
   }
   //-------------GETTER---------------------------------
   public double getPrizeMultiplier(){return this.prizeMultiplier;}
    public double getWinChanceMultiplier(){return this.winChanceMultiplier;}
   //----------------------------------------------------


    //-------------SETTER---------------------------------
    //----------------------------------------------------
}

