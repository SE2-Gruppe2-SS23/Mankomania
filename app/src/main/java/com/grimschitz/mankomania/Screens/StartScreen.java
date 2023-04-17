package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.grimschitz.mankomania.R;

public class StartScreen extends AppCompatActivity {

    public StartScreen(){
        setContentView(R.layout.activity_start_screen);

        Button start = findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createActivity(new LoadScreen(new LobbyScreen()));
            }
        });

        Button exit = findViewById(R.id.btn_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

    }


    public void createActivity(AppCompatActivity nextActivity){
        Intent nextScreen = new Intent(this,nextActivity.getClass());
        this.startActivity(nextScreen);
    }
}