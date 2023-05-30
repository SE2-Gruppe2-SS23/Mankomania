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
        System.out.println("Server started");
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
                send(writer, GameState.HELLO, player.name());
                Game.INSTANCE.checkLobby();
                while (true) {
                    var input = reader.readUTF();
                    var response = Game.INSTANCE.move(player, input);
                    send(writer, response.gameState(), response.data());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void send(DataOutputStream writer, GameState gameState, String... data) throws IOException {
            writer.writeUTF(gameState + "#" + String.join("#", data));
        }
    }
}
