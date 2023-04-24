package com.grimschitz.mankomania.FieldLogic;

import com.grimschitz.mankomania.PlayerLogic.Player;

import java.util.ArrayList;

public class Field {
    private Field nextField;
    private Field optionalNextField;
    private Field previousField;

    private final int fieldIndex;
    private final String fieldDescription;

    public Field(int fieldIndex, String fieldDescription){
        this.fieldIndex = fieldIndex;
        this.fieldDescription = fieldDescription;
    }

    public boolean isIntersection(){return nextField != null && optionalNextField != null;}

    public boolean hasPlayer(ArrayList<Player> players){
        for (Player player: players) {
            if(player.getCurrentPosition().fieldIndex == this.fieldIndex){return true;}
        }
        return false;
    }

    //--------------GETTERS--------------
    public int getFieldIndex(){return fieldIndex;}
    public String getFieldDescription(){return fieldDescription;}
    public Field getNextField(){return nextField;}
    public Field getPreviousField(){return previousField;}
    public Field getOptionalNextField(){return optionalNextField;}

    //-----------------------------------
    //--------------SETTERS--------------
    public void setNextField(Field nextField){this.nextField = nextField;}
    public void setOptionalNextField(Field optionalNextField){this.optionalNextField = optionalNextField;}
    public void setPreviousField(Field previousField) {this.previousField = previousField;}
    //-----------------------------------

}
