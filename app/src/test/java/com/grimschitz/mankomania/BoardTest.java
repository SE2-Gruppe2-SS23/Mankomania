package com.grimschitz.mankomania;

import com.grimschitz.mankomania.BoardLogic.Board;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.grimschitz.mankomania.PlayerLogic.Player;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class BoardTest {
    private static Player player;
    private static Board board;
    private static final String fieldDescription = "Dein Buch \"Geld verjubeln leicht gemacht\" ist ein Bestseller! Kassiere 5000 Euro";
    private static final int fieldsAmount = 69;
    private static final int playersAmount = 1;
    @BeforeAll
    public static void init(){
        player = new Player();
        player.setPlayerIndex(0);
        board = new Board();
        board.addPlayer(player);
        board.setCurrentPlayer(player);
    }

    @Test
    public void testNewBoard(){assertNotNull(board);}
    @Test
    public void testGetPlayers(){assertEquals(playersAmount,board.getPlayers().size());}
    @Test
    public void testGetPlayer(){
        board.addPlayer(player);
        assertEquals(player,board.getPlayer(player.getPlayerIndex()));}
    @Test
    public void testGetCurrentPlayer(){assertEquals(player,board.getCurrentPlayer());}
//    @Test
//    public void testDeletePlayer(){
//        board.deletePlayer(player);
//        assertNull(board.getPlayers().contains(player));}
    @Test
    public void testNoPlayers(){
        board.deleteAllPlayers();
        assertTrue(board.getPlayers().isEmpty());}
    @Test
    public void testGetFields(){assertEquals(fieldsAmount,board.getFields().length);}
    @Test
    public void testGetField(){assertEquals(fieldDescription,board.getField(0).getFieldDescription());}

}
