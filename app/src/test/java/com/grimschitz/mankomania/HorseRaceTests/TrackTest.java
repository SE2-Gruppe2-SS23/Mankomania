package com.grimschitz.mankomania.HorseRaceTests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.grimschitz.mankomania.HorseRaceLogic.Track;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class TrackTest {
private static final double winMultiplierTest = 0.25;
    private static final double prizeMultiplierTest = 2.5;
    private static Track track;

    @BeforeAll
    public static void init(){track = Track.FIRST;}

    @Test
    public void testPrizeMultiplier(){assertEquals(prizeMultiplierTest,track.prizeMultiplier);}
    @Test
    public void testWinMultiplier(){assertEquals(winMultiplierTest,track.winMultiplier);}

    @Test
    public void testTracksCount(){assertEquals(4,Track.values().length);}
}
