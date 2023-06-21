package com.grimschitz.mankomania.ToolsLogic;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.R;

import java.util.Random;

public class RouletteActivity extends AppCompatActivity {

    private Button redButton, blackButton;
    private TextView resultTextView;
    private Random random;
    private Handler handler;
    private RouletteWheelView rouletteWheelView;

    private Player player;
    private RouletteLogic rouletteLogic;
    int betAmount = getIntent().getIntExtra("bet",0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        redButton = findViewById(R.id.redButton);
        blackButton = findViewById(R.id.blackButton);
        resultTextView = findViewById(R.id.resultTextView);
        rouletteWheelView = findViewById(R.id.rouletteWheelView);

        random = new Random();
        handler = new Handler();
        rouletteLogic = new RouletteLogic();



        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin("red");
            }
        });

        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin("black");
            }
        });

    }


    private void spin(String bet) {
        int spinDuration = 3000;

        resultTextView.setText("Spinning...");
        rouletteLogic.spin();
        int result = rouletteLogic.getResultNumber();
        rouletteWheelView.spin(result);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rouletteWheelView.stopSpin();

                if (rouletteLogic.checkBet(bet)) {
                    resultTextView.setText("You won! The result is " + result + " (" + rouletteLogic.getColorResult() + ")");
                    player.addMoney(betAmount*100);
                } else {
                    resultTextView.setText("You lost! The result is " + result + " (" + rouletteLogic.getColorResult() + ")");
                    player.loseMoney(betAmount);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 2000);
            }
        }, spinDuration);
    }
}