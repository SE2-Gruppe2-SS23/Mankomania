package com.grimschitz.mankomania.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.grimschitz.mankomania.BoardScreen.BoardScreenActivity;
import com.grimschitz.mankomania.client.Client;
import com.grimschitz.mankomania.R;
import com.grimschitz.mankomania.client.PropertyName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class LobbyScreen extends AppCompatActivity implements PropertyChangeListener {
    private TextView p1,p2,p3,p4;
    private Button btn_Back;
    private Button btn_Ready;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby_screen);
        p1 = findViewById(R.id.txt_Player1);
        p2 = findViewById(R.id.txt_Player2);
        p3 = findViewById(R.id.txt_Player3);
        p4 = findViewById(R.id.txt_Player4);
        btn_Back = findViewById(R.id.btn_Back);
        btn_Ready = findViewById(R.id.btn_Ready);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {finish();}
        });

        initConnection();

        btn_Ready.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO set ready in lobby
                //createActivity(BoardScreenActivity.class);
            }
        });
    }

    public void initConnection(){
        //TODO: add connection to server logic
        Client.getInstance().start();
        Client.getInstance().addPropertyChangeListener(this);
    }

    public void update(String[] players){

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(PropertyName.PLAYER_NAMES.name())) {
            update((String[]) evt.getNewValue());
        }
    }
}