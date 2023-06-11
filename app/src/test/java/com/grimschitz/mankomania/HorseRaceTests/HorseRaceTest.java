package com.grimschitz.mankomania.HorseRaceTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.grimschitz.mankomania.BoardLogic.Board;
import com.grimschitz.mankomania.HorseRaceLogic.HorseRace;
import com.grimschitz.mankomania.HorseRaceLogic.Track;
import com.grimschitz.mankomania.PlayerLogic.Player;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class HorseRaceTest {
    private static HorseRace race;
    private static Player player;
    @BeforeAll
    public static void init(){
        race = new HorseRace();
        player = new Player();
        race.setTrackForPlayer(player, Track.FIRST);
        race.placeBetForPlayer(player,500);
    }

    @Test
    public void testNewRace(){assertNotNull(race);}
    @Test
    public void testGetTracks(){assertNotNull(race.getTracks());}
    @Test
    public void testGetBets(){assertNotNull(race.getBets());}
    @Test
    public void testTracks(){assertTrue(race.getTracks().containsKey(player));}
    @Test
    public void testBets(){assertTrue(race.getBets().containsKey(player));}
}
