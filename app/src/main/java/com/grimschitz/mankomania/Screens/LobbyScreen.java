package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.grimschitz.mankomania.R;



public class LobbyScreen extends AppCompatActivity {
    private TextView p1,p2,p3,p4;
    private Button btn_Back;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby_screen);
        p1 = findViewById(R.id.txt_Player1);
        p2 = findViewById(R.id.txt_Player2);
        p3 = findViewById(R.id.txt_Player3);
        p4 = findViewById(R.id.txt_Player4);
        btn_Back = findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {finish();}
        });
        //initConnection();
    }

    public void initConnection(){
        //TODO: add connection to server logic
    }

    public void update(){
        String[] players = null; //TODO: getPlayers from connection

        p1.setText(players[0]);

        switch (players.length){
            case 2 :
                p2.setText(players[1]);
                break;
            case 3 :
                p2.setText(players[1]);
                p3.setText(players[2]);
                break;
            case 4 :
                p2.setText(players[1]);
                p3.setText(players[2]);
                p4.setText(players[3]);
                break;

        }
    }

    public void createActivity(Class nextActivity){
        Intent nextScreen = new Intent(this,nextActivity);
        this.startActivity(nextScreen);
    }
}