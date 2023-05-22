package com.grimschitz.mankomania.BoardScreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.R;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BoardScreenActivity extends AppCompatActivity {

    private SquareGridView gridView;
    private TextView text;

    int playerfield;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_screen);
       text = (TextView) findViewById(R.id.textView3);
        playerfield=0;

        gridView = findViewById(R.id.gridView);
        gridView.post(new Runnable() {
              @Override
              public void run() {
                  for (int i = 0; i < 30; i++) {
                      int[] coordinates = gridView.getCellCoordinates(i);
                      Log.d("Cell " + i + " coordinates:", "x=" + coordinates[0] + ", y=" + coordinates[1]);
                  }
              }
        });

        //Set all Players to Player Start Fields Fields
       int xy[] = gridView.getCellCoordinates(0);
       ImageView image = findViewById(R.id.player1);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        image.requestLayout();

       xy = gridView.getCellCoordinates(9);
       image = findViewById(R.id.player2);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        image.requestLayout();
        xy = gridView.getCellCoordinates(150);
        image = findViewById(R.id.player3);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        image.requestLayout();

        xy = gridView.getCellCoordinates(140);
        image = findViewById(R.id.player4);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        image.requestLayout();

        // Get Each Player from Server assign ImageView

    }

    public void wurfeln(View view) {
        int validField[] = {11,13,14,15,17,18,38,48,68,78,88,108,118,138,137,135,134,133,131,111,101,81,71,61,41,31};// Valide Felder des Grids in der richtigen Reihenfolge
        int wurfel = (int)(Math.random() * 6 + 1);
        ImageView image = findViewById(R.id.player1);

        //TODO: IF Field 11, 18, 138 , 131 --> Minigame

        //TODO: get Playerfield from active
        playerfield = playerfield+wurfel;
        if(playerfield>40) playerfield=playerfield-41;
        int xy[] = gridView.getCellCoordinates(validField[playerfield]);

        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0]; //+ playerindex* e.g. 3 so players are not completely overlaping
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1]; //+ playerindex* e.g. 3 so players are not completely overlaping
        image.requestLayout();

        Log.d("Move to x: " + xy[0], " and y" + xy[1] + ", Auf Feld " + playerfield);
        }
    public void updatePlayers(View view) {
        //Get Players from Server
        //get Player Position
        //set player position
    }
    //Todo: Update Other Player Position
        //Get Other "Players"
            //move other avatars to position


}

