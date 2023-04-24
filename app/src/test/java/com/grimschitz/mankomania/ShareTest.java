package com.grimschitz.mankomania;

import static org.junit.Assert.assertEquals;

import com.grimschitz.mankomania.ShareLogic.Share;

import org.junit.Before;
import org.junit.Test;

public class ShareTest {

    private Share share;

    @Before
    public void init(){share = Share.DRY_OIL_PLC;}

    @Test
    public void testName(){assertEquals(Share.DRY_OIL_PLC.getName(),share.getName());}

    @Test
    public void testShareCount(){assertEquals(3,Share.values().length);}

}
