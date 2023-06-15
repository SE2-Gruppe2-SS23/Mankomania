package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.grimschitz.mankomania.GlobalAssets;
import com.grimschitz.mankomania.R;
import com.grimschitz.mankomania.Screens.HorseRace.HorseRaceScreen;

import java.beans.PropertyChangeListener;

public class PlaceBetScreen extends AppCompatActivity {
    private Button place;
    private EditText bet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_bet_screen);
        bet = findViewById(R.id.editTxt_Bet);
        place = findViewById(R.id.btn_Placebet);
        place.setOnClickListener(view -> {

            if(Integer.parseInt(bet.getText().toString()) <= 0 || Integer.parseInt(bet.getText().toString()) > 50000 ){
                Toast.makeText(PlaceBetScreen.this, "Bet must be more than 0 and less than 50000", Toast.LENGTH_LONG).show();
            }else if(bet.getText().toString().isEmpty()){
                Toast.makeText(PlaceBetScreen.this, "Bet must not be null", Toast.LENGTH_LONG).show();
            }else{
                setBet(Integer.parseInt(bet.getText().toString()));
                createActivity(HorseRaceScreen.class);
            }
        });
    }

    public static void setBet(int bet){
        GlobalAssets.bet = bet;
    }

    public void createActivity(Class nextActivity){
        Intent nextScreen = new Intent(this,nextActivity);
        this.startActivity(nextScreen);
    }
}