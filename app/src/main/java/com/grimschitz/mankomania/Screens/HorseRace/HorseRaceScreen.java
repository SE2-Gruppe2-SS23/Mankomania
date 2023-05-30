package com.grimschitz.mankomania.Screens.HorseRace;

import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.movementFields;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.p1;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.p2;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.p3;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.p4;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.goalView;


import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.grimschitz.mankomania.HorseRaceLogic.HorseRace;
import com.grimschitz.mankomania.HorseRaceLogic.Track;
import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HorseRaceScreen extends AppCompatActivity {

    public HorseRace raceInstance;

    public Button diceThrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race_screen);
        diceThrow = findViewById(R.id.btn_Throw);
        raceInstance = new HorseRace();
        diceThrow.setOnClickListener(v -> {
            //TODO set logic with server
            // moveIcon(Tracks.p1,9);
            // GlobalAssets.numberOfDices = 1;
            // createActivity(RollDiceActivity.class);
        });


    }

    public void moveIcon(ImageView icon, int field){
        ObjectAnimator animation = ObjectAnimator.ofFloat(icon,"translationX", movementFields.get(field - 1).getLeft());
        animation.setDuration(3000);
        animation.start();
//        if(isWinner(icon)){
//            //TODO send info to server
//        }

    }
    public static void setCurrentPlayer(ImageView icon){
        Tracks.currentPlayer = icon;
    }
    public void setPlayerIcon(Player p, ImageView icon){
        Tracks.playerIcons.put(p,icon);
    }

    public void setIconPos(ImageView icon, int field){
        icon.setRight(movementFields.get(field).getRight());
    }
    public int getIconPos(ImageView icon){
        for (TextView field: movementFields) {
            if(icon.getRight() == field.getRight()){
                return movementFields.indexOf(field);
            }
        }
        return 0;
    }
    public ImageView getPlayerIcon(Player p){
        return Tracks.playerIcons.get(p);
    }
    public boolean isWinner(ImageView playerIcon){
        return playerIcon.getRight() > goalView.getLeft();
    }

    public void createActivity(Class nextActivity){
        Intent nextScreen = new Intent(this,nextActivity);
        this.startActivity(nextScreen);
    }

}