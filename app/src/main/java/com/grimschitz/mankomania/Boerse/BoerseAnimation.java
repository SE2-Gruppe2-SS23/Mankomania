package com.grimschitz.mankomania.Boerse;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.grimschitz.mankomania.R;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

    public class BoerseAnimation extends AppCompatActivity {

        private ImageView pointerImageView;
        private Button rotateButton;
        private ObjectAnimator rotateAnimator;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.popup_boerse);

            pointerImageView = findViewById(R.id.pointer_imageview);
            rotateButton = findViewById(R.id.rotate_button);

            rotateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rotatePointer(3600f);
                }
            });
        }

        private void rotatePointer(float deg) {
            if (rotateAnimator != null && rotateAnimator.isRunning()) {
                rotateAnimator.cancel();
            }

            rotateAnimator = ObjectAnimator.ofFloat(pointerImageView, View.ROTATION, 0f, deg);
            rotateAnimator.setDuration(2000);
            rotateAnimator.setInterpolator(new LinearInterpolator());
            rotateAnimator.start();
        }
    }