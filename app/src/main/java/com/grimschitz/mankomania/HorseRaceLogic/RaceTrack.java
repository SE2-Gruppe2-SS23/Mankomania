package com.grimschitz.mankomania.HorseRaceLogic;

public class RaceTrack {
    private Track current;

   private double prizeMultiplier;
   private double winChanceMultiplier;



   public RaceTrack(Track track,double prizeMultiplier, double winChanceMultiplier){
       this.current = track;
       this.prizeMultiplier = prizeMultiplier;
       this.winChanceMultiplier = winChanceMultiplier;
   }
   //-------------GETTER---------------------------------


    public Track getCurrent() {return current;}
    public double getPrizeMultiplier(){return prizeMultiplier;}
    public double getWinChanceMultiplier(){return winChanceMultiplier;}


   //----------------------------------------------------


    //-------------SETTER---------------------------------
    //----------------------------------------------------
}

