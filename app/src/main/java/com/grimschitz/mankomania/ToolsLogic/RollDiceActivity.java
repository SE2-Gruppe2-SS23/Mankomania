package com.grimschitz.mankomania.ToolsLogic;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.R;

public class RollDiceActivity extends AppCompatActivity implements SensorEventListener {

    private Button rollTestButton;
    private ImageView diceOne,diceTwo;

    private TextView resultText;

    private SensorManager sensorManager;
    private Sensor accelometer;

    private final int[] diceImages = new int[]{R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    private MediaPlayer mediaPlayer;

    private DiceRoller diceRoller;

    Intent returnIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);

        diceOne = findViewById(R.id.diceOneImage);
        diceTwo = findViewById(R.id.diceTwoImage);
        resultText = findViewById(R.id.resultTextView);

        rollTestButton = findViewById(R.id.rollTestButton);
        rollTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shakeDice();
                int[] result = diceRoller.rollDice();
                returnIntent.putExtra("result", result[0] + result[1]);
                setResult(RollDiceActivity.RESULT_OK, returnIntent);
                rollDice(result[0], result[1]);
            }
        });

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener((SensorEventListener) this, accelometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

        diceRoller = new DiceRoller();
    }

    private void shakeDice() {
        mediaPlayer = MediaPlayer.create(this,R.raw.roll);
        mediaPlayer.start();

        diceOne.setImageResource(R.drawable.shake);
        diceTwo.setImageResource(R.drawable.shake);

        AnimationDrawable diceOneRollAnimation = (AnimationDrawable) diceOne.getDrawable();
        AnimationDrawable diceTwoRollAnimation = (AnimationDrawable) diceTwo.getDrawable();
        Animation rattleAnimation = AnimationUtils.loadAnimation(this,R.anim.rattle);

        diceOne.startAnimation(rattleAnimation);
        diceTwo.startAnimation(rattleAnimation);

        diceOneRollAnimation.start();
        diceTwoRollAnimation.start();
    }

    private void rollDice(int rollOne, int rollTwo) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int result = rollOne + rollTwo;
                diceOne.setImageResource(diceImages[rollOne-1]);
                diceTwo.setImageResource(diceImages[rollTwo-1]);
                resultText.setText("You rolled "+result+" !");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 2000);
            }
        },1000);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float shake = diceRoller.processSensorData(x, y, z);

            if (shake > 5 && shake < 7){
                shakeDice();
                int[] result = diceRoller.rollSix();
                returnIntent.putExtra("result", result[0] + result[1]);
                setResult(RollDiceActivity.RESULT_OK, returnIntent);
                rollDice(result[0], result[1]);
                sensorManager.unregisterListener(this);
            } else if (shake >= 7) {
                shakeDice();
                int[] result = diceRoller.rollDice();
                returnIntent.putExtra("result", result[0] + result[1]);
                setResult(RollDiceActivity.RESULT_OK, returnIntent);
                rollDice(result[0], result[1]);
                sensorManager.unregisterListener(this);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}

