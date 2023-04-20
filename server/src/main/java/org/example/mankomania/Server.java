package org.example.mankomania;

import org.example.mankomania.game.Game;
import org.example.mankomania.game.GameState;
import org.example.mankomania.game.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (var serverSocket = new ServerSocket(8080)) {
            while (true) {
                new Connection(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Connection extends Thread {
        private final Socket socket;
        private Player player;

        public Connection(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    var reader = new DataInputStream(socket.getInputStream());
                    var writer = new DataOutputStream(socket.getOutputStream())
            ) {
                Game.INSTANCE.addPlayer(socket).ifPresentOrElse(
                        player -> this.player = player,
                        () -> {
                            try {
                                writer.writeUTF("Game is full");
                                socket.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
                writer.writeUTF(GameState.HELLO + "#" + player.name());
                while (true) {
                    var input = reader.readUTF();
                    writer.writeUTF(String.valueOf(Game.INSTANCE.move()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
