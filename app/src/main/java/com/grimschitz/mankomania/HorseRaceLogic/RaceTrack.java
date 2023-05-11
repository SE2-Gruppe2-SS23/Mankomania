package com.grimschitz.mankomania.HorseRaceLogic;

public class RaceTrack {
    private Track currentTrack;
   private double prizeMultiplier;
   private double winChanceMultiplier;


   public RaceTrack(Track track , double prizeMultiplier, double winChanceMultiplier){
       this.currentTrack = track;
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

