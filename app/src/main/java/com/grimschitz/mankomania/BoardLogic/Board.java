package com.grimschitz.mankomania.BoardLogic;

import com.grimschitz.mankomania.FieldLogic.Field;
import com.grimschitz.mankomania.PlayerLogic.Player;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Field[] fields;
    private List<Player> players;

    private Player currentPlayer;

    public Board(){
        players = new ArrayList<>();
        fields = BoardFields.getFields();
    }


    //---------GETTERS--------------
    public Player getCurrentPlayer(){return currentPlayer;}
    public List<Player> getPlayers(){return players;}
    public Player getPlayer(int playerIndex){
        for (Player p: players) {
            if(p.getPlayerIndex() == playerIndex){return p;}
        }
        return null;
    }

    public Field getField(int fieldIndex){return fields[fieldIndex];}
    public Field[] getFields(){return fields;}

    //------------------------------

    //---------SETTERS--------------
    public void setCurrentPlayer(Player player){this.currentPlayer = player;}

    public void addPlayer(Player player){players.add(player);}

    public void deletePlayer(Player player){
        for (Player p: players){
            int playerToDelete = player.getPlayerIndex();
            if(p.getPlayerIndex() == playerToDelete){players.remove(playerToDelete);}
        }
    }

    public void deleteAllPlayers(){players.clear();}

    //------------------------------
}
