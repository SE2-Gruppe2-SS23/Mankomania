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
//                TODO: check on clients?
                return;
            }
        }
    }

    private final Random random = new Random();

    private void endTurn() {
        currentPlayer = players[(Arrays.asList(players).indexOf(currentPlayer) + 1) % players.length];
        sendToAll(GameState.INFO, String.valueOf(random.nextInt()));
        sendToAll(GameState.UPDATE_PLAYERS, Arrays.stream(players).map(player ->
                player.name() + ":" + player.position() + ":" + player.money()
        ).collect(Collectors.joining(",")));
        send(currentPlayer, GameState.GAME_MOVE);
    }

    public void disconnect() {
//        TODO: https://github.com/SE2-Gruppe2-SS23/Mankomania/issues/38
        throw new UnsupportedOperationException();
    }

    public void reconnect() {
//        TODO: https://github.com/SE2-Gruppe2-SS23/Mankomania/issues/38
        throw new UnsupportedOperationException();
    }

    private boolean horseRaceStarted = false;
    private int horseRaceRound = 0;

    public Response move(Player player, String input) {
        var data = input.split("#");
        var state = GameState.valueOf(data[0]);

        if (currentState == GameState.LOBBY_WAITING) return new Response(GameState.LOBBY_WAITING);
        if (currentState == GameState.LOBBY_READY) {
            player.setLastRoll(Integer.parseInt(data[1]));
            determineTurns();
            return new Response(GameState.GAME_WAIT);
        }
//        TODO: check this. add only to GAME_MOVE ?
//        if (!player.equals(currentPlayer)) return new Response(GameState.GAME_WAIT);


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
                if (!horseRaceStarted) {
                    horseRaceStarted = true;
                    sendToAll(GameState.MINIGAME_RACE);
                    return null;
                }
                player.raceRoll[horseRaceRound++] = Integer.parseInt(data[1]);
                for (Player p : players) {
                    if (p.raceRoll[horseRaceRound] == 0) return new Response(GameState.GAME_WAIT);
                    sendToAll(GameState.MINIGAME_RACE, Arrays.stream(players).map(player1 -> String.valueOf(player1.raceRoll[horseRaceRound])).collect(Collectors.joining(",")));
                }
                break;
            case MINIGAME_EXCHANGE:
                break;
            case MINIGAME_AUCTION:
                player.setMoney(Integer.parseInt(data[1]));
                endTurn();
                break;
            case INFO:
                if (horseRaceStarted) {
                    player.setMoney(Integer.parseInt(data[1]));
                    horseRaceStarted = false;
                    horseRaceRound = 0;
                    for (Player p : players) {
                        p.raceRoll = new int[8];
                    }
                    endTurn();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }

        return null;
    }

    private void sendToAll(GameState gameState, String... data) {
        Arrays.stream(players).filter(Objects::nonNull).forEach(player -> {
            try {
                new DataOutputStream(player.socket().getOutputStream()).writeUTF(gameState + "#" + String.join("#", data));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void send(Player player, GameState gameState, String... data) {
        try {
            new DataOutputStream(player.socket().getOutputStream()).writeUTF(gameState + "#" + String.join("#", data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
