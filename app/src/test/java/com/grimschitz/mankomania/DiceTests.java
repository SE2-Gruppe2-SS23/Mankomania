package com.grimschitz.mankomania;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.grimschitz.mankomania.ToolsLogic.DiceRoller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiceTests {
    private DiceRoller diceRoller;

    @BeforeEach
    public void setUp() throws Exception {
        diceRoller = new DiceRoller();
    }

    @Test
    public void rollDiceBetween1And12() {
        for (int i = 0; i < 10000; i++) {
            int[] result = diceRoller.rollDice();
            int dicesResult = result[0]+result[1];
            assertTrue(dicesResult<=12 && dicesResult>0);
        }
    }

    @Test
    public void rollSix_returns12() {
        for (int i = 0; i < 10000; i++) {
            int[] result = diceRoller.rollSix();
            int dicesResult = result[0]+result[1];
            assertEquals( 12, dicesResult);
        }
    }
}
