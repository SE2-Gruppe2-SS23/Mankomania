package com.grimschitz.mankomania;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.grimschitz.mankomania.ToolsLogic.RouletteLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RouletteTests {

    private RouletteLogic rouletteLogic;

    @BeforeEach
    public void setUp() {
        rouletteLogic = new RouletteLogic();
    }

    @Test
    public void spinResultNumberInRange() {
        rouletteLogic.spin();
        int result = rouletteLogic.getResultNumber();

        assertTrue(result >= 0 && result <= 36);
    }

    @Test
    public void spinColorResultValid() {
        rouletteLogic.spin();
        String color = rouletteLogic.getColorResult();

        assertTrue(color.equals("red") || color.equals("black") || color.equals("green"));
    }


}
