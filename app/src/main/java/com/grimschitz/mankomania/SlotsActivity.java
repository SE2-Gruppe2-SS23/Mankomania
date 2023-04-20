package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SlotsActivity extends AppCompatActivity {

    private ImageView reelOne,reelTwo,reelThree;
    private Button spinButton;

    private TextView resultView;

    private Random random;

    private int[] reelImages = new int[]{R.drawable.bar,R.drawable.cherry,R.drawable.lemon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);

        reelOne = findViewById(R.id.reelOne);
        reelTwo = findViewById(R.id.reelTwo);
        reelThree = findViewById(R.id.reelThree);

        spinButton = findViewById(R.id.spinButton);
        resultView = findViewById(R.id.resultTextView);

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin();
            }
        });

    }

    private void spin() {
         random = new Random();
         int reelOneResult = random.nextInt(reelImages.length);
         int reelTwoResult = random.nextInt(reelImages.length);
         int reelThreeResult = random.nextInt(reelImages.length);

         if (reelOneResult==reelTwoResult && reelTwoResult==reelThreeResult){
             resultView.setText("YOU WON!");
         }
         else {
             resultView.setText("SPIN AGAIN!");
         }

        reelOne.setImageResource(reelImages[reelOneResult]);
        reelTwo.setImageResource(reelImages[reelTwoResult]);
        reelThree.setImageResource(reelImages[reelThreeResult]);

    }
}