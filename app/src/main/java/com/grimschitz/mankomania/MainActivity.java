package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button rollButton,slotsButton,rouletteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.rollButton);
        slotsButton = findViewById(R.id.slotsButton);
        rouletteButton = findViewById(R.id.rouletteButton);

        slotsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SlotsActivity.class);
                startActivity(intent);
            }
        });
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RollDiceActivity.class);
                startActivity(intent);
            }
        });

        rouletteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RouletteActivity.class);
                startActivity(intent);
            }
        });
    }
}