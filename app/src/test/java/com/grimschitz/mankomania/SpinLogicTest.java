package com.grimschitz.mankomania;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.ToolsLogic.SpinLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpinLogicTest {
    private SpinLogic spinLogic;
    private Player player;
    private int[] reelImages = new int[]{0, 1, 2};

    @BeforeEach
    void setUp() {
        player = new Player();
        player.setMoney(100);
        spinLogic = new SpinLogic(reelImages, player);
    }

    @Test
    void spinReelswithInsufficientFunds() {
        player.setMoney(10);
        assertThrows(Exception.class, () -> spinLogic.spinReels(20));
    }

    @Test
    void spinReelswithNegativeBet() {
        assertThrows(Exception.class, () -> spinLogic.spinReels(-20));
    }

    @Test
    void spinReelswithZeroBet() {
        assertThrows(Exception.class, () -> spinLogic.spinReels(0));
    }

    @Test
    void checkWinwithWinningReels() {
        int[] results = new int[]{0, 0, 0};
        assertTrue(spinLogic.checkWin(results));
    }

    @Test
    void checkWinwithLosingReels() {
        int[] results = new int[]{0, 1, 2};
        assertFalse(spinLogic.checkWin(results));
    }
}
