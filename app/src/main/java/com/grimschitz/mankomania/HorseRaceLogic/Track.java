package com.grimschitz.mankomania.HorseRaceLogic;

public enum Track {
    //TODO modify multipliers accordingly
    FIRST(5.2,2.5),
    SECOND(5.2,2.5),
    THIRD(5.2,2.5),
    FOURTH(5.2,2.5);

public final double winMultiplier;
public final double prizeMultiplier;

private Track(double winMult, double prizeMult){
    this.prizeMultiplier = prizeMult;
    this.winMultiplier = winMult;
}



}
