package com.grimschitz.mankomania.AuctionHouse;

import com.grimschitz.mankomania.Game;
import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.client.Client;
import com.grimschitz.mankomania.client.GameState;

import java.io.IOException;
import java.util.Random;

public class AuctionHouse {
    public AuctionObject[] auctionObjects;

    private final Random random = new Random();

    private final double[] multipliers = new double[]{1, 0.5, 1.5, 0.2, 2};

    public double[] getMultipliers() {
        return multipliers;
    }

    private final Player player = Game.getInstance().getClientPlayer();

    private AuctionObject selectedObject;

    public AuctionHouse() {
        this.auctionObjects = new AuctionObject[]{
                new AuctionObject("Car", 1000),
                new AuctionObject("House", 2000),
                new AuctionObject("Boat", 3000)
        };
        try {
            Client.getInstance().send(GameState.MINIGAME_AUCTION);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int buyObject(AuctionObject auctionObject) {
        selectedObject = auctionObject;
        player.setMoney(player.getMoney() - auctionObject.price);
        return player.getMoney();
    }

    public double getRandomMultiplier() {
        return multipliers[random.nextInt(multipliers.length)];
    }

    public int auction(double multiplier) {
        int price = (int) (selectedObject.price * multiplier);
        player.setMoney(player.getMoney() + price);
        try {
            Client.getInstance().send(GameState.MINIGAME_AUCTION, String.valueOf(player.getMoney()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }
}
