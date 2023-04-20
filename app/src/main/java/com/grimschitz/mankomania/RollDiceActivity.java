package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class RollDiceActivity extends AppCompatActivity implements SensorEventListener {

    private Button rollTestButton;
    private ImageView diceOne,diceTwo;
    private Random random;

    private SensorManager sensorManager;

    private Sensor accelometer;


    private final int[] diceImages = new int[]{R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    private MediaPlayer mediaPlayer;

    private float accelerationValue,lastAccelerationValue,shake;

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

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener((SensorEventListener) this, accelometer, SensorManager.SENSOR_DELAY_NORMAL);
            accelerationValue=SensorManager.GRAVITY_EARTH;
            lastAccelerationValue=SensorManager.GRAVITY_EARTH;
            shake=0.00f;
         }
    }

    private int rollSix() {
        mediaPlayer = MediaPlayer.create(this,R.raw.rollsix);
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


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                diceOne.setImageResource(diceImages[5]);
                diceTwo.setImageResource(diceImages[5]);

            }
        },5000);

        return 12;
    }



    private int rollDice() {
        random = new Random();
        int rollDiceOne = random.nextInt(5)+1;
        int rollDiceTwo = random.nextInt(5)+1;

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


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                diceOne.setImageResource(diceImages[rollDiceOne-1]);
                diceTwo.setImageResource(diceImages[rollDiceTwo-1]);

            }
        },300);

        return rollDiceOne+rollDiceTwo;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            lastAccelerationValue = accelerationValue;

            accelerationValue = (float) Math.sqrt((x*x)+(y*y)+(z*z));
            float differenz = accelerationValue - lastAccelerationValue;
            shake = shake * 0.9f + differenz;

            if (shake > 5 && shake < 7){
                rollSix();
                Log.d("ShakeSix", "onSensorChanged: " +shake);
                sensorManager.unregisterListener(this);
            } else if (shake >= 7) {
                rollDice();
                Log.d("Shake", "onSensorChanged: " +shake);
                sensorManager.unregisterListener(this);
            }
        }
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}