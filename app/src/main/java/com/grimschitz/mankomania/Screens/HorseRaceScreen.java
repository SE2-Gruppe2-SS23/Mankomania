package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    public ArrayList<TextView> movementFields;
    public HorseRace raceInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race_screen);
        playerIcons = new HashMap<>();
        p1 = findViewById(R.id.imgPlayer1);
        p2 = findViewById(R.id.imgPlayer2);
        p3 = findViewById(R.id.imgPlayer3);
        p4 = findViewById(R.id.imgPlayer4);
        raceInstance = new HorseRace();
        goalView = findViewById(R.id.goalField);
        setMovementFields();
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
    }
    public boolean isWinner(ImageView playerIcon){
        return playerIcon.getRight() > goalView.getLeft();
    }
}