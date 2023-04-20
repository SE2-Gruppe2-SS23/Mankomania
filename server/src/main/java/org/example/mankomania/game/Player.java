package org.example.mankomania.game;

import java.net.Socket;

public record Player(String name, Socket socket, int money, int position) {
    public Player(String name, Socket socket) {
        this(name, socket, 1000000, 0);
    }
}
