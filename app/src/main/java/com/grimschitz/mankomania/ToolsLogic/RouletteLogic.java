package com.grimschitz.mankomania.ToolsLogic;

import java.util.Random;

public class RouletteLogic {

    private Random random;
    private String colorResult;
    private int resultNumber;

    public RouletteLogic() {
        random = new Random();
    }

    public void spin() {
        resultNumber = random.nextInt(37);
        colorResult = (resultNumber == 0) ? "green" : (resultNumber % 2 == 0) ? "red" : "black";
    }

    public boolean checkBet(String bet) {
        return colorResult.equals(bet);
    }

    public int getResultNumber() {
        return resultNumber;
    }

    public String getColorResult() {
        return colorResult;
    }
}
