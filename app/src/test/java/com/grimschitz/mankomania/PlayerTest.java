package com.grimschitz.mankomania;


import com.grimschitz.mankomania.FieldLogic.Field;
import com.grimschitz.mankomania.PlayerLogic.Player;
import com.grimschitz.mankomania.ShareLogic.Share;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private static Player emptyPlayer;
    private static Player normalPlayer;
    private static Field testField = new Field(1, "Test Field");
    @BeforeAll
    public static void init(){

        emptyPlayer = new Player();
        normalPlayer = new Player(testField,1,"Test Player");
    }

    @Test
    public void testPlayerDices(){
        emptyPlayer.setDices(1);
        assertEquals(1,emptyPlayer.getDices());
    }
    @Test
    public void testPlayerIndex(){
        emptyPlayer.setPlayerIndex(1);
        assertEquals(1,emptyPlayer.getDices());
    }

    @Test
    public void testPlayerName(){
        emptyPlayer.setName("Test Name");
        assertEquals("Test Name",emptyPlayer.getName());
    }
    @Test
    public void testPlayerMoney(){
        emptyPlayer.setMoney(50000);
        assertEquals(50000,emptyPlayer.getMoney());
    }
    @Test
    public void testPlayerPosition(){
        emptyPlayer.setCurrentPosition(testField);
        assertEquals(testField.getFieldDescription(),emptyPlayer.getCurrentPosition().getFieldDescription());
    }

    @Test
    public void testPlayerShares(){
        emptyPlayer.setShares(1,1,1);
        assertEquals(1,emptyPlayer.getShareAmount(Share.HARD_STEEL_PLC));
    }

    @Test
    public void testPlayerPayment(){
        emptyPlayer.setMoney(50000);
        normalPlayer.setMoney(50000);
        emptyPlayer.payToPlayer(normalPlayer,5000);
        assertEquals(55000,normalPlayer.getMoney());
        assertEquals(45000,emptyPlayer.getMoney());
    }


}
