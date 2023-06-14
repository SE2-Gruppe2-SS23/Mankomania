package com.grimschitz.mankomania;

import androidx.appcompat.app.AppCompatActivity;

import com.grimschitz.mankomania.BoardLogic.Board;
import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.client.GameState;
import com.grimschitz.mankomania.client.PropertyName;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Game {
    public static Board board;
    private static Game instance;

    private GameState currentState = GameState.LOBBY_WAITING;

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        GameState oldState = this.currentState;
        this.currentState = currentState;
        support.firePropertyChange(PropertyName.GAME_STATE.name(), oldState, currentState);
    }

    private Player[] players = new Player[4];

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        Player[] oldPlayers = this.players;
        this.players = players;
        support.firePropertyChange(PropertyName.PLAYERS.name(), oldPlayers, players);
    }

    private int randomNumber;

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        int oldRandomNumber = this.randomNumber;
        this.randomNumber = randomNumber;
        support.firePropertyChange(PropertyName.RANDOM_NUMBER.name(), oldRandomNumber, randomNumber);
    }

    public Game() {
        board = new Board();

//            TODO: can we do this at a later point?

        for (Player p : players) {
            board.addPlayer(p);
        }
    }

    public static Board getBoard() {
        return board;

    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }


}
