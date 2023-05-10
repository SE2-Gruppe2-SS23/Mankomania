package com.grimschitz.mankomania.client;

import com.grimschitz.mankomania.Game;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {

    private static Client instance;

    private final String host = "localhost";
    private final int port = 8080;

    private DataInputStream reader;
    private DataOutputStream writer;
    private Socket socket;

    private String[] playerNames = new String[4];

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setPlayerNames(String[] playerNames) {
        String[] oldPlayerNames = this.playerNames;
        this.playerNames = playerNames;
        support.firePropertyChange("playerNames", oldPlayerNames, playerNames);
    }

    public Client() {}
    public static Client getInstance(){
        if(instance == null){instance = new Client();}
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
                GameState gameState = GameState.valueOf(input.substring(0, input.indexOf("#")));
                switch (gameState) {
                    case HELLO:
                        break;
                    case LOBBY_WAITING:
                        Game.getInstance().lobbyReady = false;
                        setPlayerNames(parsePlayerNames(input));
                        break;
                    case LOBBY_READY:
                        Game.getInstance().lobbyReady = true;
                        setPlayerNames(parsePlayerNames(input));
                        break;
                    case GAME_MOVE:
                        break;
                    case GAME_WAIT:
                        break;
                    case GAME_END:
                        break;
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
}
