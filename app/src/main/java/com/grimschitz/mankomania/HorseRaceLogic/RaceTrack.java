package com.grimschitz.mankomania.HorseRaceLogic;

public class RaceTrack {
<<<<<<< HEAD
    private Track current;
=======
>>>>>>> 195b4de... create branch HorseRace logic, and basic implementation of horse race, race tracks and track types
   private double prizeMultiplier;
   private double winChanceMultiplier;


<<<<<<< HEAD
   public RaceTrack(Track track,double prizeMultiplier, double winChanceMultiplier){
       this.current = track;
=======
   public RaceTrack(double prizeMultiplier, double winChanceMultiplier){
>>>>>>> 195b4de... create branch HorseRace logic, and basic implementation of horse race, race tracks and track types
       this.prizeMultiplier = prizeMultiplier;
       this.winChanceMultiplier = winChanceMultiplier;
   }
   //-------------GETTER---------------------------------
<<<<<<< HEAD

    public Track getCurrent() {return current;}
    public double getPrizeMultiplier(){return prizeMultiplier;}
    public double getWinChanceMultiplier(){return winChanceMultiplier;}
=======
   public double getPrizeMultiplier(){return this.prizeMultiplier;}
    public double getWinChanceMultiplier(){return this.winChanceMultiplier;}
>>>>>>> 195b4de... create branch HorseRace logic, and basic implementation of horse race, race tracks and track types
   //----------------------------------------------------


    //-------------SETTER---------------------------------
    //----------------------------------------------------
}

