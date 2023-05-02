package com.grimschitz.mankomania.HorseRaceLogic;

import com.grimschitz.mankomania.PlayerLogic.Player;

import java.util.HashMap;

public class HorseRace {
    private HashMap<Player,Integer> bets;
    private HashMap<Player,RaceTrack> tracks;

     public HorseRace(){
           bets = new HashMap<>();
           tracks = new HashMap<>();

     }

     public void setTrackForPlayer(Player p, Track track){
<<<<<<< HEAD
         tracks.put(p,new RaceTrack(track,track.prizeMultiplier,track.winMultiplier));
=======
         tracks.put(p,new RaceTrack(track.prizeMultiplier,track.winMultiplier));
>>>>>>> fa8925d (create branch HorseRace logic, and basic implementation of horse race, race tracks and track types)
     }

     public void placeBetForPlayer(Player p, int amount){
         bets.put(p,amount);
     }


<<<<<<< HEAD
=======

>>>>>>> fa8925d (create branch HorseRace logic, and basic implementation of horse race, race tracks and track types)
}
