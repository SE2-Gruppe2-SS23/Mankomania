package com.grimschitz.mankomania;


import com.grimschitz.mankomania.FieldLogic.Field;
import com.grimschitz.mankomania.PlayerLogic.Player;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private static Player emptyPlayer;
    private static Player normalPlayer;
    @BeforeAll
    public static void init(){

        emptyPlayer = new Player();
        normalPlayer = new Player(new Field(1,"Test Field"),1,"Test Player");
    }

    @Test
    public void testDices(){
        emptyPlayer.setDices(1);
        assertEquals(emptyPlayer.getDices(),1);
    }
}
