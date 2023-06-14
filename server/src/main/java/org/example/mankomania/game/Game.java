package org.example.mankomania.game;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public enum Game {
    INSTANCE;

    private final Player[] players = new Player[4];
    private Player currentPlayer = null;

    private GameState currentState = GameState.LOBBY_WAITING;

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
                sendToAll(GameState.LOBBY_WAITING, Arrays.stream(players).filter(Objects::nonNull).map(Player::name).collect(Collectors.joining(",")));
                return;
            }
        }
        currentState = GameState.LOBBY_READY;
        sendToAll(GameState.LOBBY_READY, Arrays.stream(players).map(Player::name).collect(Collectors.joining(",")));
    }

    private void determineTurns() {
        for (Player player : players) if (player.lastRoll() == 0) return;
        Arrays.sort(players, (o1, o2) -> o2.lastRoll() - o1.lastRoll());
        currentPlayer = players[0];
        currentState = GameState.GAME_START;
        sendToAll(GameState.GAME_START, Arrays.stream(players).map(player -> player.name() + ":" + player.position()).collect(Collectors.joining(",")));
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
        var rnd = new Random();
        sendToAll(GameState.INFO, String.valueOf(rnd.nextInt()));
    }

    public void disconnect() {
    }

    public void reconnect() {
    }

    public Response move(Player player, String input) {
        var data = input.split("#");
        var state = GameState.valueOf(data[0]);

        if (currentState == GameState.LOBBY_WAITING) return new Response(GameState.LOBBY_WAITING);
        if (currentState == GameState.LOBBY_READY) {
            player.setLastRoll(Integer.parseInt(data[1]));
            determineTurns();
            return new Response(GameState.GAME_WAIT);
        }
        if (!player.equals(currentPlayer)) return new Response(GameState.GAME_WAIT);


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
        Arrays.stream(players).filter(Objects::nonNull).forEach(player -> {
            try {
                new DataOutputStream(player.socket().getOutputStream()).writeUTF(gameState + "#" + String.join("#", data));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
