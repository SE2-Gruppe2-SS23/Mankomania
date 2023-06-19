package com.grimschitz.mankomania.ToolsLogic;

import android.hardware.SensorManager;

import java.util.Random;

public class DiceRoller {
    private Random random;
    private float lastAccelerationValue;

    public DiceRoller() {
        this.random = new Random();
        this.lastAccelerationValue = SensorManager.GRAVITY_EARTH;
    }

    public int[] rollDice() {
        int rollOne = random.nextInt(6) + 1;
        int rollTwo = random.nextInt(6) + 1;
        return new int[]{rollOne, rollTwo};
    }

    public int[] rollSix() {
        return new int[]{6, 6};
    }

    public float processSensorData(float x, float y, float z) {
        float currentAcceleration = (float) Math.sqrt(x * x + y * y + z * z);
        float delta = currentAcceleration - lastAccelerationValue;
        float shake = delta / SensorManager.GRAVITY_EARTH * 10000;
        lastAccelerationValue = currentAcceleration;
        return shake;
    }
}