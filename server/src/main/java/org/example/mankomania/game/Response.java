package org.example.mankomania.game;

import java.util.Arrays;
import java.util.Objects;

public final class Response {
    private final GameState gameState;
    private final String[] data;

    Response(GameState gameState, String[] data) {
        this.gameState = gameState;
        this.data = data;
    }

    Response(GameState gameState, String data) {
        this.gameState = gameState;
        this.data = new String[]{data};
    }

    Response(GameState gameState) {
        this.gameState = gameState;
        this.data = new String[]{};
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
        var that = (Response) obj;
        return Objects.equals(this.gameState, that.gameState) &&
                Arrays.equals(this.data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameState, Arrays.hashCode(data));
    }

    @Override
    public String toString() {
        return "Response[" +
                "gameState=" + gameState + ", " +
                "data=" + Arrays.toString(data) + ']';
    }
}
