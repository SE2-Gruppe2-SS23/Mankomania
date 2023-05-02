package com.grimschitz.mankomania.HorseRaceLogic;

public enum Track {
    //TODO modify multipliers accordingly
<<<<<<< HEAD
    FIRST(0.25,2.5),
    SECOND(0.5,2.0),
    THIRD(0.75,1.5),
    FOURTH(1,1.0);
=======
    FIRST(5.2,2.5),
    SECOND(5.2,2.5),
    THIRD(5.2,2.5),
    FOURTH(5.2,2.5);
>>>>>>> fa8925d (create branch HorseRace logic, and basic implementation of horse race, race tracks and track types)

public final double winMultiplier;
public final double prizeMultiplier;

private Track(double winMult, double prizeMult){
    this.prizeMultiplier = prizeMult;
    this.winMultiplier = winMult;
}



}
