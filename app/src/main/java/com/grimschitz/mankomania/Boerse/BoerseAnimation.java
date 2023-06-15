package com.grimschitz.mankomania.Boerse;

import static com.grimschitz.mankomania.Game.getInstance;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.BoardLogic.Board;
import com.grimschitz.mankomania.BoardScreen.BoardScreenActivity;
import com.grimschitz.mankomania.Game;
import com.grimschitz.mankomania.R;

import java.util.Random;

public class BoerseAnimation extends AppCompatActivity {

    public ImageView pointerImageView;
    private Button rotateButton;
    public ObjectAnimator rotateAnimator;
    Random gen;
    private int randomnumber;

    public BoerseAnimation() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_boerse);

        pointerImageView = findViewById(R.id.pointer_imageview);
        rotateButton = findViewById(R.id.rotate_button);
        gen = new Random();

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotatePointer(random(),random()-1);
            }
        });
    }


    private int random(long seed) {
        gen.setSeed(seed);
        return gen.nextInt(3);
    }

    private int random() {
        // randomnumber = new Game().players[0].getRandomInt();
        return gen.nextInt(3);
    }

    public void rotatePointer(int rand, int raisFall) {
        Log.d("RandomNumber",": " + rand);

        float deg = rand * 113 + 3600;
        if (rotateAnimator != null && rotateAnimator.isRunning()) {
            rotateAnimator.cancel();
        }

        rotateAnimator = ObjectAnimator.ofFloat(pointerImageView, View.ROTATION, 0f, deg);
        rotateAnimator.setDuration(5000);
        rotateAnimator.setInterpolator(new LinearInterpolator());
        rotateAnimator.start();

        TextView text = (TextView) findViewById(R.id.textView4);
        StringBuilder str = new StringBuilder();

        switch(rand){
            case 1:
                str.append("Die Aktie Stahl ");
                break;
            case 2:
                str.append("Die Aktie Strom ");
                break;
            case 3:
                str.append("Die Aktie Öl ");
                break;
        }
        switch(raisFall){
            case 1:
                str.append("steigt!");
                break;
            case 0:
                str.append("fällt!");
                break;
            default:
                str.append("fällt!");
                break;
        }

        text.setText(str.toString());


        // Handler verwenden, um eine Verzögerung einzufügen
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Wechsle zurück zu Activity 1
                Intent intent = new Intent(BoerseAnimation.this, BoardScreenActivity.class);
                startActivity(intent);
                finish(); // Beende Activity 2
            }
        }, 10000); //10 Sekunden

    }






}
