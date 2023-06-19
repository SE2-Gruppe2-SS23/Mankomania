package com.grimschitz.mankomania.BoardScreen;

import static com.grimschitz.mankomania.Game.getInstance;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.Game;
import com.grimschitz.mankomania.R;
import com.grimschitz.mankomania.ToolsLogic.CasinoActivity;
import com.grimschitz.mankomania.ToolsLogic.RollDiceActivity;

public class BoardScreenActivity extends AppCompatActivity {

    private SquareGridView gridView;
    private TextView text;
    private int validField[] = {21,22,24,26,27,38,48,68,78,88,98,108,118,138,148,147,145,144,143,141,131,111,101,91,71,61,41};// 27 Valide Felder des Grids in der richtigen Reihenfolge

    private int diceResult;
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

                  startingPos();
              }
        });

    }
    public void startingPos(){
        Log.d("Starting:", "Starting pos");
        int xy[] = gridView.getCellCoordinates(10);
        ImageView image = findViewById(R.id.player1);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        Log.d("Set Players:", "x=" + xy[0] + ", y=" + xy[1]);
        image.requestLayout();

        xy = gridView.getCellCoordinates(19);
        image = findViewById(R.id.player2);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        image.requestLayout();
        xy = gridView.getCellCoordinates(159);
        image = findViewById(R.id.player3);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        image.requestLayout();

        xy = gridView.getCellCoordinates(150);
        image = findViewById(R.id.player4);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0]-5;
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
        image.requestLayout();

        // Get Each Player from Server assign ImageView
    }

    public void startCasino(){
        Intent intent = new Intent(BoardScreenActivity.this, CasinoActivity.class);
        BoardScreenActivity.this.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
              diceResult = data.getIntExtra("result", 0);

            }
        }
    }

    public void wurfeln(View view) {
        Intent myIntent = new Intent(BoardScreenActivity.this, RollDiceActivity.class);
        startActivityForResult(myIntent, 1);
        int wurfel = diceResult;
        ImageView image = findViewById(R.id.player1);

        //TODO: IF Field 11, 18, 138 , 131 --> Minigame
        if (playerfield==0 || playerfield==6 || playerfield==15)startCasino();

        //TODO: get Playerfield from active
        playerfield = playerfield+wurfel;
        if(playerfield>26) playerfield=playerfield-27;
        int xy[] = gridView.getCellCoordinates(validField[playerfield]);

        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0]; //+ playerindex* e.g. 3 so players are not completely overlaping
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1]; //+ playerindex* e.g. 3 so players are not completely overlaping
        image.requestLayout();

        Log.d("Move to Field:" + validField[playerfield],"Würfel"+ wurfel + "x" + xy[0] + " and y" + xy[1] + ", Auf Feld " + playerfield);
        }
    public void updatePlayers(View view) {

        Game game = getInstance();

// Valide Felder des Grids in der richtigen Reihenfolge

        int xy[] = gridView.getCellCoordinates(validField[game.players[0].getCurPosition()]);

        ImageView image = findViewById(R.id.player1);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0]; //+ playerindex* e.g. 3 so players are not completely overlaping
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1]; //+ playerindex* e.g. 3 so players are not completely overlaping
        image.requestLayout();

        xy = gridView.getCellCoordinates(validField[game.players[1].getCurPosition()]);
        image = findViewById(R.id.player2);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0]; //+ playerindex* e.g. 3 so players are not completely overlaping
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1]; //+ playerindex* e.g. 3 so players are not completely overlaping
        image.requestLayout();

        xy = gridView.getCellCoordinates(validField[game.players[3].getCurPosition()]);
        image = findViewById(R.id.player3);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0]; //+ playerindex* e.g. 3 so players are not completely overlaping
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1]; //+ playerindex* e.g. 3 so players are not completely overlaping
        image.requestLayout();

        xy = gridView.getCellCoordinates(validField[game.players[3].getCurPosition()]);
        image = findViewById(R.id.player4);
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0]; //+ playerindex* e.g. 3 so players are not completely overlaping
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1]; //+ playerindex* e.g. 3 so players are not completely overlaping
        image.requestLayout();


    }
    //Todo: Update Other Player Position
        //Get Other "Players"
            //move other avatars to position


}

