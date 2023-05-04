package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.grimschitz.mankomania.HorseRaceLogic.HorseRace;
import com.grimschitz.mankomania.HorseRaceLogic.Track;
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
=======
import android.os.Bundle;

import com.grimschitz.mankomania.R;

public class HorseRaceScreen extends AppCompatActivity {

>>>>>>> 5170a1b (set background for horse race screen and starting position of player horses)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race_screen);
<<<<<<< HEAD
        playerIcons = new HashMap<>();
        p1 = findViewById(R.id.imgPlayer1);
        p2 = findViewById(R.id.imgPlayer2);
        p3 = findViewById(R.id.imgPlayer3);
        p4 = findViewById(R.id.imgPlayer4);
        raceInstance = new HorseRace();
        goalView = findViewById(R.id.goalField);
        setMovementFields();
    }

    public int getDestinationField(Track track){
        return 0;
    }
    public void moveIcon(ImageView icon, int field){
        icon.setRight(movementFields.get(field).getRight());
    }
    public void setPlayerIcon(Player p, ImageView icon){
        playerIcons.put(p,icon);
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
    }
    public boolean isWinner(ImageView playerIcon){
        return playerIcon.getRight() > goalView.getLeft();
=======
>>>>>>> 5170a1b (set background for horse race screen and starting position of player horses)
    }
}