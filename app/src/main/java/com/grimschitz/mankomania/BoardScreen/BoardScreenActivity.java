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

       int xy[] = gridView.getCellCoordinates(0);
    }

    public void wurfeln(View view) {
        int validField[] = {1,2,3,4,5,6,7,8,18,28,38,48,58,68,78,88,98,108,118,128,138,137,136,135,134,133,132,131,130,120,110,100,90,80,70,60,50,40,30,20,10};// Valide Felder des Grids in der richtigen Reihenfolge
        int wurfel = (int)(Math.random() * 6 + 1);
        ImageView image = findViewById(R.id.imageView4);

        //TODO: get Playerfield from active
        playerfield = playerfield+wurfel;
        if(playerfield>40) playerfield=playerfield-41;
        int xy[] = gridView.getCellCoordinates(validField[playerfield]);

        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        image.requestLayout();

        Log.d("Move to x: " + xy[0], " and y" + xy[1] + ", Auf Feld " + playerfield);
        }



}

