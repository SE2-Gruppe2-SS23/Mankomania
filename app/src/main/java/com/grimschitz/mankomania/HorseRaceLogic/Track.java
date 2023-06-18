package com.grimschitz.mankomania.HorseRaceLogic;

public enum Track {
    FIRST(0.25,2.5),
    SECOND(0.5,2.0),
    THIRD(0.75,1.5),
    FOURTH(1,1.0);


public final double winMultiplier;
public final double prizeMultiplier;

Track(double winMult, double prizeMult){
    this.prizeMultiplier = prizeMult;
    this.winMultiplier = winMult;
}



}
