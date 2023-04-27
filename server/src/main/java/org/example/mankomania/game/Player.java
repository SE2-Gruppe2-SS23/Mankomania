package org.example.mankomania.game;

import java.net.Socket;
import java.util.Objects;

public final class Player {
    private final String name;
    private final Socket socket;
    private final int money;
    private final int position;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Player) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.socket, that.socket) &&
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
        this(name, socket, 1000000, 0);
    }
}
