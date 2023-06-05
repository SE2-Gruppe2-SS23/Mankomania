package com.grimschitz.mankomania.Boerse;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

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
                rotatePointer(random());
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

    public void rotatePointer(int rand) {
        Log.d("RandomNumber",": " + rand);

        float deg = rand * 113 + 3600;
        if (rotateAnimator != null && rotateAnimator.isRunning()) {
            rotateAnimator.cancel();
        }

        rotateAnimator = ObjectAnimator.ofFloat(pointerImageView, View.ROTATION, 0f, deg);
        rotateAnimator.setDuration(5000);
        rotateAnimator.setInterpolator(new LinearInterpolator());
        rotateAnimator.start();
    }
}
