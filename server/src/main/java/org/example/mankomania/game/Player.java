package org.example.mankomania.game;

import java.net.Socket;
import java.util.Objects;

public final class Player {
    private static int index = 0;
    private final String name;
    private final Socket socket;
    private int money;
    private int position;
    private int lastRoll;

    public int[] raceRoll = new int[8];

    Player(String name, Socket socket, int money, int position) {
        this.name = name;
        this.socket = socket;
        this.money = money;
        this.position = position;
    }

    public String name() {
        return name;
    }

    public Socket socket() {
        return socket;
    }

    public int money() {
        return money;
    }

    public int position() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int lastRoll() {
        return lastRoll;
    }

    public void setLastRoll(int lastRoll) {
        this.lastRoll = lastRoll;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Player) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.socket, that.socket) && //TODO: consider reconnecting players
                this.money == that.money &&
                this.position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, socket, money, position);
    }

    @Override
    public String toString() {
        return "Player[" +
                "name=" + name + ", " +
                "socket=" + socket + ", " +
                "money=" + money + ", " +
                "position=" + position + ']';
    }

    public Player(String name, Socket socket) {
        this(name, socket, 1000000, determineStartingPosition());
    }

    private static int determineStartingPosition() {
//        TODO: figure out proper starting positions
        switch (index++) {
            case 0:
                return 0;
            case 1:
                return 10;
            case 2:
                return 20;
            case 3:
                return 30;
        }
        return 0;
    }
}
