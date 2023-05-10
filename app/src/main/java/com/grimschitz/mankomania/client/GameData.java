package com.grimschitz.mankomania.client;

import java.util.Objects;

public final class GameData {
    private final GameState gameState;
    private final String[] data;

    GameData(GameState gameState, String[] data) {
        this.gameState = gameState;
        this.data = data;
    }

    public GameState gameState() {
        return gameState;
    }

    public String[] data() {
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        GameData that = (GameData) obj;
        return Objects.equals(this.gameState, that.gameState) &&
                Objects.equals(this.data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameState, data);
    }

    @Override
    public String toString() {
        return "Data[" +
                "gameState=" + gameState + ", " +
                "data=" + data + ']';
    }

}
