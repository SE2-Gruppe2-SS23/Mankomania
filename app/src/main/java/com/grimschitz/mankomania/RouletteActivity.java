package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RouletteActivity extends AppCompatActivity {

    private Button redButton, blackButton;
    private TextView resultTextView;
    private Random random;
    private Handler handler;
    private RouletteWheelView rouletteWheelView;

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
        int result = random.nextInt(37); // 0 to 36, with 0 as a special case
        String color = (result == 0) ? "green" : (result % 2 == 0) ? "red" : "black";

        resultTextView.setText("Spinning...");
        rouletteWheelView.spin(result);



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rouletteWheelView.stopSpin();

                if (color.equals(bet)) {
                    resultTextView.setText("You won! The result is " + result + " (" + color + ")");
                } else {
                    resultTextView.setText("You lost! The result is " + result + " (" + color + ")");
                }
            }
        }, spinDuration);
    }
}