package com.grimschitz.mankomania.Screens.HorseRace;

import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.movementFields;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.p1;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.p2;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.p3;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.p4;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.goalView;
import static com.grimschitz.mankomania.Screens.HorseRace.Tracks.playerIcons;


import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.grimschitz.mankomania.Game;
import com.grimschitz.mankomania.GlobalAssets;
import com.grimschitz.mankomania.HorseRaceLogic.HorseRace;
import com.grimschitz.mankomania.HorseRaceLogic.Track;
import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.R;
import com.grimschitz.mankomania.ToolsLogic.RollDiceActivity;
import com.grimschitz.mankomania.client.Client;
import com.grimschitz.mankomania.client.GameState;
import com.grimschitz.mankomania.client.PropertyName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class HorseRaceScreen extends AppCompatActivity implements PropertyChangeListener {

    public HorseRace raceInstance;
    public int diceResult;
    public Button diceThrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race_screen);
        diceThrow = findViewById(R.id.btn_Throw);
        raceInstance = new HorseRace();
        setPlayerIcon(Game.getInstance().getPlayers()[0], p1);
        setPlayerIcon(Game.getInstance().getPlayers()[1], p2);
        setPlayerIcon(Game.getInstance().getPlayers()[2], p3);
        setPlayerIcon(Game.getInstance().getPlayers()[3], p4);

        diceThrow.setOnClickListener(view ->{
//            Intent getDiceResult = new Intent(this, RollOneDiceActivity.class);
//            startActivityForResult(getDiceResult,1);
            //createActivity(RollDiceActivity.class);
            Random rand = new Random();
            // TODO send roll to server
               try {
                Client.getInstance().send(GameState.MINIGAME_RACE, String.valueOf(rand.nextInt(6)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                diceResult = data.getIntExtra("result", 0);

            }
        }
    }
    public void toastAndSendToOthers(Player p) {
        try {
            Toast.makeText(this, "Player " + p.getName() + "wins" , Toast.LENGTH_LONG).show();
            for (Player player : Game.getInstance().getPlayers()) {
                player.setRaceRoll(new int[8]);
            }
            if(p.getName() == Game.getInstance().clientName) {
                p.setMoney(p.getMoney() - GlobalAssets.bet);
                Client.getInstance().send(GameState.INFO, String.valueOf(p.getMoney()));
            }

            finish();
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveIcon(ImageView icon, int field){
        if(field > 0) {
            ObjectAnimator animation = ObjectAnimator.ofFloat(icon, "translationX", movementFields.get(field - 1).getLeft());
            animation.setDuration(3000);
            animation.start();
        }

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
    public Player getIconPlayer(ImageView playerIcon){

        for (Map.Entry<Player, ImageView> entry: playerIcons.entrySet()) {
            if(Objects.equals(playerIcon,entry.getValue())){
                return entry.getKey();
            }
        }
        return null;
    }
    public boolean isWinner(ImageView playerIcon){
        return playerIcon.getRight() >= goalView.getLeft();
    }

    public void createActivity(Class nextActivity){
        Intent nextScreen = new Intent(this,nextActivity);
        this.startActivity(nextScreen);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(PropertyName.GAME_STATE.name())){
            if(evt.getNewValue().equals(GameState.GAME_MOVE)){
                for (int rollInstance = 0; rollInstance < 8; rollInstance++) {
                    moveIcon(p1,Game.getInstance().getPlayers()[0].getRaceRoll()[rollInstance]);
                    if(isWinner(p1)){toastAndSendToOthers(getIconPlayer(p1));}
                    moveIcon(p2,Game.getInstance().getPlayers()[1].getRaceRoll()[rollInstance]);
                    if(isWinner(p2)){toastAndSendToOthers(getIconPlayer(p2));}
                    moveIcon(p3,Game.getInstance().getPlayers()[2].getRaceRoll()[rollInstance]);
                    if(isWinner(p3)){toastAndSendToOthers(getIconPlayer(p3));}
                    moveIcon(p4,Game.getInstance().getPlayers()[3].getRaceRoll()[rollInstance]);
                    if(isWinner(p4)){toastAndSendToOthers(getIconPlayer(p4));}

                }
                Game.getInstance().setCurrentState(GameState.MINIGAME_RACE);
            }
        }
    }


}