package com.grimschitz.mankomania.ToolsLogic;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.R;

public class SlotsActivity extends AppCompatActivity {

    private ImageView reelOne, reelTwo, reelThree;
    private Button spinButton;
    private TextView resultView, moneyTextView;
    private EditText betAmountEditText;

    private int[] reelImages = new int[]{R.drawable.bar, R.drawable.cherry, R.drawable.lemon};
    private SpinLogic spinLogic;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);

        reelOne = findViewById(R.id.reelOne);
        reelTwo = findViewById(R.id.reelTwo);
        reelThree = findViewById(R.id.reelThree);

        spinButton = findViewById(R.id.slotsButton);
        resultView = findViewById(R.id.resultTextView);

        moneyTextView = findViewById(R.id.moneyTextView);

        spinLogic = new SpinLogic(reelImages, player);

        int betAmount = getIntent().getIntExtra("bet",0);
        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin(betAmount);
            }
        });
    }

    private void spin(int betAmount){
        try {
            int[] spinResults = spinLogic.spinReels(betAmount);
            if (spinResults == null) {
                Toast.makeText(this, "Invalid bet!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean win = spinLogic.checkWin(spinResults);

            if (win)player.addMoney(betAmount*100);

            // Update player's money on screen
            moneyTextView.setText("Money: " + player.getMoney());

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
                    if (win) {
                        resultView.setText("YOU WON!");
                    } else {
                        resultView.setText("SPIN AGAIN!");
                    }

                    reelOne.setImageResource(reelImages[spinResults[0]]);
                    reelTwo.setImageResource(reelImages[spinResults[1]]);
                    reelThree.setImageResource(reelImages[spinResults[2]]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 2000);
                }
            }, 300);
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}