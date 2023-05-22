package com.grimschitz.mankomania;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.grimschitz.mankomania.ShareLogic.Share;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ShareTest {

    private static Share share;

    @BeforeAll
    public static void init(){share = Share.DRY_OIL_PLC;}

    @Test
    public void testName(){assertEquals(Share.DRY_OIL_PLC.getName(),share.getName());}

    @Test
    public void testShareCount(){assertEquals(3,Share.values().length);}

}
