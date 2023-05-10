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

    private Player currentPlayer;

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
        currentPlayer = players[0];
        sendToAll(GameState.LOBBY_READY, Arrays.stream(players).map(Player::name).collect(Collectors.joining(",")));
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

    private void endTurn() {
        currentPlayer = players[(Arrays.asList(players).indexOf(currentPlayer) + 1) % players.length];
    }

    public void disconnect() {
    }

    public void reconnect() {
    }

    public Response move(Player player, String input) {
        if (!ready) return new Response(GameState.LOBBY_WAITING);
        if (!player.equals(currentPlayer)) return new Response(GameState.GAME_WAIT);


        var data = input.split("#");
        var state = GameState.valueOf(data[0]);

        switch (state) {

            case GAME_MOVE:
                player.setPosition(Integer.parseInt(data[1]));
//                TODO: make board checks serverside or on each client and just communicate new pos + money?
//                TODO: lock player turns serverside?
                break;

//                player initiates a mini-game i.e. ended his turn on a mini-game field
            case MINIGAME_CASINO:
                break;
            case MINIGAME_RACE:
                break;
            case MINIGAME_EXCHANGE:
                break;
            case MINIGAME_AUCTION:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }

        endTurn();
        return null;
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
