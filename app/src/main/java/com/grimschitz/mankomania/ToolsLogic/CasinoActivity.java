package com.grimschitz.mankomania.ToolsLogic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.R;


public class CasinoActivity extends AppCompatActivity {

    private Button slotsButton,rouletteButton;

    private EditText betAmountEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casino);

        slotsButton = findViewById(R.id.slotsButton);
        rouletteButton = findViewById(R.id.rouletteButton);
        betAmountEditText = findViewById(R.id.betAmountEditText);

        slotsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String betAmountStr = betAmountEditText.getText().toString();
                int betAmount = Integer.parseInt(betAmountStr);
                Intent nextScreen = new Intent(CasinoActivity.this, SlotsActivity.class);
                nextScreen.putExtra("bet",betAmount);
                CasinoActivity.this.startActivity(nextScreen);
                finish();
            }
        });

        rouletteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String betAmountStr = betAmountEditText.getText().toString();
                int betAmount = Integer.parseInt(betAmountStr);
                Intent nextScreen = new Intent(CasinoActivity.this, RouletteActivity.class);
                nextScreen.putExtra("bet",betAmount);
                CasinoActivity.this.startActivity(nextScreen);
                finish();
            }
        });

    }

}