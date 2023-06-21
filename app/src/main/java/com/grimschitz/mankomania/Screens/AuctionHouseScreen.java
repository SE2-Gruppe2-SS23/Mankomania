package com.grimschitz.mankomania.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.AuctionHouse.AuctionHouse;
import com.grimschitz.mankomania.R;
import com.grimschitz.mankomania.client.Client;
import com.grimschitz.mankomania.client.GameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AuctionHouseScreen extends AppCompatActivity {
    private Spinner spinner;
    private Button button;
    private ListView listView;
    private List<Double> numbers;
    private ArrayAdapter<Double> adapter;

    private final AuctionHouse auctionHouse = new AuctionHouse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction_house_screen);

        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        List<String> items = Arrays.stream(auctionHouse.auctionObjects).map(auctionObject -> auctionObject.name + ": $" + auctionObject.price).collect(Collectors.toList());
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        numbers = Arrays.stream(auctionHouse.getMultipliers()).boxed().collect(Collectors.toList());
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbers);
        listView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            Double multiplier = auctionHouse.getRandomMultiplier();
            listView.setItemChecked(numbers.indexOf(multiplier), true);

            int price = auctionHouse.auction(multiplier);

            Toast.makeText(AuctionHouseScreen.this, "Sold for $" + price, Toast.LENGTH_LONG).show();
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                auctionHouse.buyObject(auctionHouse.auctionObjects[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection from spinner
            }
        });
    }
}
