package com.grimschitz.mankomania;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.grimschitz.mankomania.BoardScreen.SquareGridView;
import com.grimschitz.mankomania.PlayerLogic.Player;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
/*        View view = this.findViewById(android.R.id.content).getRootView();
       RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)  view
                .getLayoutParams();
        layoutParams.leftMargin = xy[0];
        layoutParams.topMargin = xy[1];
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = 0;
        view.setLayoutParams(layoutParams);
        view.invalidate();*/
    }
    public void wurfeln(View view) {
        int validField[] = {1,2,3,4,5,6,7,8,18,28,38,48,58,68,78,88,98,108,118,128,138,137,136,135,134,133,132,131,130,120,110,100,90,80,70,60,50,40,30,20,10};
        int wurfel = (int)(Math.random() * 6 + 1);
        //view = (View) findViewById(R.id.fragment_Second_Layout).getLayoutParams();
        ImageView image = findViewById(R.id.imageView4);

        playerfield = playerfield+wurfel;
        if(playerfield>40) playerfield=playerfield-41;
        int xy[] = gridView.getCellCoordinates(validField[playerfield]);

        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).leftMargin = xy[0];
        ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin = xy[1];
    //   text.setText(wurfel);
        image.requestLayout();

        //mPhotoView.
        Log.d("Move to x: " + xy[0], " and y" + xy[1] + ", Auf Feld " + playerfield);

    }





}












    /*        GridView gridView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_first);

            gridView = findViewById(R.id.gridView);
            gridView.setAdapter(new GridAdapter(this));
        }

        private class GridAdapter extends BaseAdapter {

            private Context context;

            public GridAdapter(Context context) {
                this.context = context;
            }

            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if (convertView == null) {
                    imageView = new ImageView(context);
                    imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView = (ImageView) convertView;
                }
                imageView.setImageResource(R.drawable.field); // You can use your own drawable for the field
                return imageView;
            }
        }
    }






    /*
    private AppBarConfiguration appBarConfiguration;
    private ActivityBoardScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBoardScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_board_screen);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_board_screen);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}


     */