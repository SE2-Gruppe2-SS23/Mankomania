package com.grimschitz.mankomania.Screens;

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
import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HorseRaceScreen extends AppCompatActivity {
    public HashMap<Player, ImageView> playerIcons;
    public ImageView p1,p2,p3,p4;
    public TextView goalView;
    public ArrayList<TextView> movementFields = new ArrayList<>();
    public HorseRace raceInstance;

    public ImageView currentPlayer;
    public Button diceThrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race_screen);
        playerIcons = new HashMap<>();
        p1 = findViewById(R.id.imgPlayer1);
        p2 = findViewById(R.id.imgPlayer3);
        p3 = findViewById(R.id.imgPlayer4);
        p4 = findViewById(R.id.imgPlayer4);
        diceThrow = findViewById(R.id.btn_Throw);
        raceInstance = new HorseRace();
        goalView = findViewById(R.id.goalField);
        setMovementFields();

        diceThrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveIcon(p1,5, v);
//                GlobalAssets.numberOfDices = 1;
//               createActivity(RollDiceActivity.class);
            }
        });

        //moveIcon(currentPlayer,GlobalAssets.diceAmount);

    }

    public void moveIcon(ImageView icon, int field, View v){
        ObjectAnimator animation = ObjectAnimator.ofFloat(icon,"translationX",movementFields.get(field).getRight());
        animation.setDuration(3000);
        animation.start();
//        if(isWinner(icon)){
//            //TODO send info to server
//        }

    }
    public void setCurrentPlayer(ImageView icon){
        currentPlayer = icon;
    }
    public void setPlayerIcon(Player p, ImageView icon){
        playerIcons.put(p,icon);
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
        return playerIcons.get(p);
    }
    public void setMovementFields(){
        movementFields.add(findViewById(R.id.field1));
        movementFields.add(findViewById(R.id.field2));
        movementFields.add(findViewById(R.id.field3));
        movementFields.add(findViewById(R.id.field4));
        movementFields.add(findViewById(R.id.field5));
        movementFields.add(findViewById(R.id.field6));
        movementFields.add(findViewById(R.id.field7));
        movementFields.add(findViewById(R.id.field8));
        movementFields.add(findViewById(R.id.goalField));
    }
    public boolean isWinner(ImageView playerIcon){
        return playerIcon.getRight() > goalView.getLeft();
    }

    public void createActivity(Class nextActivity){
        Intent nextScreen = new Intent(this,nextActivity);
        this.startActivity(nextScreen);
    }

}