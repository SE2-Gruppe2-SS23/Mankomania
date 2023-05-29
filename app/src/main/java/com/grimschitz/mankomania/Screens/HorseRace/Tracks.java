package com.grimschitz.mankomania.Screens.HorseRace;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.R;

import java.util.ArrayList;
import java.util.HashMap;


public class Tracks extends Fragment {

    public static HashMap<Player, ImageView> playerIcons;
    public static ImageView p1;
    public ImageView p2;
    public ImageView p3;
    public ImageView p4;
    public static TextView goalView;
    public static ArrayList<TextView> movementFields = new ArrayList<>();
    public static ImageView currentPlayer;
    public Tracks() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_tracks, container, false);
        playerIcons = new HashMap<>();
        p1 = view.findViewById(R.id.icon_P1);
        p2 = view.findViewById(R.id.icon_P2);
        p3 = view.findViewById(R.id.icon_P3);
        p4 = view.findViewById(R.id.icon_P4);
        goalView = view.findViewById(R.id.goalField);
        setMovementFields(view);
        return view;
    }

    public void setMovementFields(View v){
        movementFields.add(v.findViewById(R.id.field1));
        movementFields.add(v.findViewById(R.id.field2));
        movementFields.add(v.findViewById(R.id.field3));
        movementFields.add(v.findViewById(R.id.field4));
        movementFields.add(v.findViewById(R.id.field5));
        movementFields.add(v.findViewById(R.id.field6));
        movementFields.add(v.findViewById(R.id.field7));
        movementFields.add(v.findViewById(R.id.field8));
        movementFields.add(v.findViewById(R.id.goalField));
    }



}