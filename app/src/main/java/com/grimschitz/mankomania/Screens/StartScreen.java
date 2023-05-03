package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.grimschitz.mankomania.GlobalAssets;
import com.grimschitz.mankomania.R;

public class StartScreen extends AppCompatActivity {
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        start = findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createActivity(LobbyScreen.class);
            }
        });

    }


    public void createActivity(Class nextActivity){
        Intent nextScreen = new Intent(this,nextActivity);
        this.startActivity(nextScreen);
    }
}