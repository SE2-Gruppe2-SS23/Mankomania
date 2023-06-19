package com.grimschitz.mankomania.ToolsLogic;

import com.grimschitz.mankomania.PlayerLogic.Player;

import java.util.Random;

public class SpinLogic {

    private Random random;
    private int[] reelImages;

    private Player player;

    public SpinLogic(int[] reelImages, Player player) {
        this.reelImages = reelImages;
        this.player = player;
        random = new Random();
    }

    public int[] spinReels(int betAmount) throws Exception {
        if (player.getMoney() < betAmount || betAmount <= 0) {
            throw new Exception("Invalid bet!");
        }
        player.loseMoney(betAmount);

        int reelOneResult = random.nextInt(reelImages.length);
        int reelTwoResult = random.nextInt(reelImages.length);
        int reelThreeResult = random.nextInt(reelImages.length);

        return new int[]{reelOneResult, reelTwoResult, reelThreeResult};
    }

    public boolean checkWin(int[] results) {
        return (results[0] == results[1] && results[1] == results[2]);
    }
}
