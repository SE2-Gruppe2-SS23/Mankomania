package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class RollDiceActivity extends AppCompatActivity {

    private Button rollTestButton;
    private ImageView diceOne,diceTwo;
    private Random random;

    private final int[] diceImages = new int[]{R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);

        diceOne = findViewById(R.id.diceOneImage);
        diceTwo = findViewById(R.id.diceTwoImage);

        rollTestButton = findViewById(R.id.rollTestButton);
        rollTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
    }

    private int rollDice() {
        random = new Random();
        int rollDiceOne = random.nextInt(5)+1;
        int rollDiceTwo = random.nextInt(5)+1;

        diceOne.setImageResource(diceImages[rollDiceOne-1]);
        diceTwo.setImageResource(diceImages[rollDiceTwo-1]);

        return rollDiceOne+rollDiceTwo;
    }
}