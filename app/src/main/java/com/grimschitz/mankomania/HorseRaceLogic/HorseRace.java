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

         tracks.put(p,new RaceTrack(track,track.prizeMultiplier,track.winMultiplier));

     }

     public void placeBetForPlayer(Player p, int amount){
         bets.put(p,amount);
     }

     public HashMap<Player,Integer> getBets(){return bets;}
    public HashMap<Player,RaceTrack> getTracks(){return tracks;}

}
