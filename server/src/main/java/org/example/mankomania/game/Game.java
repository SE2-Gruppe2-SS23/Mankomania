package org.example.mankomania.game;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

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
                sendToAll(GameState.LOBBY_WAITING, Arrays.stream(players).map(Player::name).collect(Collectors.joining(",")));
                return;
            }
        }
        ready = true;
        sendToAll(GameState.LOBBY_READY + "#" + Arrays.stream(players).map(Player::name).collect(Collectors.joining(",")));
    }

    private void checkWin() {
        for (Player player : players) {
            if (player.money() == 0) {
                sendToAll(GameState.GAME_END, player.name());
//                TODO: can multiple players win?
                return;
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

    private void sendToAll(GameState gameState, String... data) {
        for (Player player : players) {
            try {
                new DataOutputStream(player.socket().getOutputStream()).writeUTF(gameState + "#" + String.join("#", data));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
