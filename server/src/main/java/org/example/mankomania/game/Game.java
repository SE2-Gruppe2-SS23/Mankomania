package org.example.mankomania.game;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public enum Game {
    INSTANCE;

    private final Player[] players = new Player[4];
    private Boolean ready = false;

    Game() {
//        init
    }

    public static Game getInstance() {
        return INSTANCE;
    }

    public Optional<Player> addPlayer(Socket socket) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = new Player("Player " + i, socket);
                return Optional.of(players[i]);
            }
        }
        return Optional.empty();
    }

    public void checkLobby() {
        for (Player player : players) {
            if (player == null) {
                return;
            }
        }
        ready = true;
        for (Player player : players) {
            try {
                new DataOutputStream(player.socket().getOutputStream()).writeUTF(String.valueOf(GameState.LOBBY_READY));
            } catch (IOException e) {
                throw new RuntimeException(e);
//                stop game?
            }
        }
    }

    public void disconnect() {
    }

    public void reconnect() {
    }

    public GameState move() {
        if (!ready) return GameState.LOBBY_WAITING;
        else return null;
    }
}
