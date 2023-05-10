package org.example.mankomania.game;

public enum GameState {
    //    KEEP SYNCHRONIZED WITH CLIENT!!!
    HELLO, //simple handshake check
    LOBBY_WAITING, //only for client
    LOBBY_READY, //only for client
    GAME_MOVE, //indicate the client has to make a move and to communicate the move to the server
//    #position#money
    GAME_WAIT, //indicate the client has to wait for the other players to make their move
    GAME_END, //one player reached 0$ and the game is over
    MINIGAME_CASINO,
    MINIGAME_RACE,
    MINIGAME_EXCHANGE,
    MINIGAME_AUCTION
}

//split game states up if necessary. Message protocol is 'GameState#anyDataAsString'