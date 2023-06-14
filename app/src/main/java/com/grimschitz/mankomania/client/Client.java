package com.grimschitz.mankomania.client;

import android.util.Log;

import com.grimschitz.mankomania.FieldLogic.Field;
import com.grimschitz.mankomania.Game;
import com.grimschitz.mankomania.PlayerLogic.Player;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client extends Thread {

    private static Client instance;

    private final String host = "10.0.2.2"; //localhost is the emulator itself
    private final int port = 8080;

    private DataInputStream reader;
    private DataOutputStream writer;
    private Socket socket;

    private String[] playerNames = new String[4];

    private GameData gameData;

    public GameData getGameData() {
        return gameData;
    }

    private final List<GameData> history = new ArrayList<>();

    public List<GameData> getHistory() {
        return history;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setPlayerNames(String[] playerNames) {
        String[] oldPlayerNames = this.playerNames;
        this.playerNames = playerNames;
        support.firePropertyChange(PropertyName.PLAYER_NAMES.name(), oldPlayerNames, playerNames);
    }

    public void setGameData(GameData gameData) {
        GameData oldGameData = this.gameData;
        this.gameData = gameData;
        history.add(gameData);
        support.firePropertyChange(PropertyName.GAME_DATA.name(), oldGameData, gameData);
    }

    public Client() {
    }

    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
        }
        return instance;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(host, port);
            reader = new DataInputStream(socket.getInputStream());
            writer = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String input = reader.readUTF();
                Log.d("client", input);
                GameState gameState = GameState.valueOf(input.substring(0, input.indexOf("#")));
                switch (gameState) {
                    case HELLO:
                        Game.getInstance().clientName = parseGameData(input).data()[0];
                        break;
                    case LOBBY_WAITING:
                        Game.getInstance().setCurrentState(GameState.LOBBY_WAITING);
                        setPlayerNames(parsePlayerNames(input));
                        break;
                    case LOBBY_READY:
                        setPlayerNames(parsePlayerNames(input));
                        Game.getInstance().setCurrentState(GameState.LOBBY_READY);
//                        TODO: move to dice screen and determine player order
                        break;
                    case GAME_START:
                        Player[] players = new Player[4];
                        String[] data = parseGameData(input).data();
                        for (int i = 0; i < data.length; i++) {
                            String s = data[i];
                            String[] playerData = s.split(":");
                            players[i] = new Player(new Field(Integer.parseInt(playerData[1]), ""), i, playerData[0]);
                        }
                        Game.getInstance().setPlayers(players);
                        Game.getInstance().setCurrentState(GameState.GAME_START);
                        break;
                    case GAME_MOVE:
                        setGameData(parseGameData(input));
                        break;
                    case GAME_WAIT:
                        break;
                    case GAME_END:
                        break;
                    case MINIGAME_CASINO:
                        break;
                    case MINIGAME_RACE:
                        break;
                    case MINIGAME_EXCHANGE:
                        break;
                    case MINIGAME_AUCTION:
                        break;
                    case INFO:
                        Game.getInstance().setRandomNumber(Integer.parseInt(parseGameData(input).data()[0]));
                        break;
                    default:
                        setGameData(parseGameData(input));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(GameState gameState, String... data) throws IOException {
        writer.writeUTF(gameState.name() + "#" + String.join("#", data));
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    private String[] parsePlayerNames(String input) {
        return input.substring(input.indexOf("#") + 1).split(",");
    }

    private GameData parseGameData(String input) {
        return new GameData(GameState.valueOf(input.substring(0, input.indexOf("#"))), input.substring(input.indexOf("#") + 1).split("#"));
    }
}
