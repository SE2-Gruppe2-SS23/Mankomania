package com.grimschitz.mankomania.HorseRaceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.grimschitz.mankomania.HorseRaceLogic.RaceTrack;
import com.grimschitz.mankomania.HorseRaceLogic.Track;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class RaceTrackTest {
    private static RaceTrack raceTrack;
    private static Track track;
    @BeforeAll
    public static void init(){
        track = Track.FIRST;
        raceTrack = new RaceTrack(track,track.prizeMultiplier, track.winMultiplier);
    }

    @Test
    public void testNewRaceTrack(){assertNotNull(raceTrack);}
    @Test
    public void testGetCurrent(){assertEquals(track,raceTrack.getCurrent());}
    @Test
    public void testGetPrizeMultiplier(){assertEquals(track.prizeMultiplier,raceTrack.getPrizeMultiplier());}
    @Test
    public void testGetWinMultiplier(){assertEquals(track.winMultiplier,raceTrack.getWinChanceMultiplier());}
}
