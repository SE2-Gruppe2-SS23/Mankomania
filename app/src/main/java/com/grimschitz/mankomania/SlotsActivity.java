package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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



        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wheel_spin);
        mediaPlayer.start();

        reelOne.setImageResource(R.drawable.spin);
        reelTwo.setImageResource(R.drawable.spin);
        reelThree.setImageResource(R.drawable.spin);

        AnimationDrawable reelOneSpinAnimation = (AnimationDrawable) reelOne.getDrawable();
        AnimationDrawable reelTwoSpinAnimation = (AnimationDrawable) reelTwo.getDrawable();
        AnimationDrawable reelThreeSpinAnimation = (AnimationDrawable) reelThree.getDrawable();


        reelOneSpinAnimation.start();
        reelTwoSpinAnimation.start();
        reelThreeSpinAnimation.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
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
        },300);



    }
}