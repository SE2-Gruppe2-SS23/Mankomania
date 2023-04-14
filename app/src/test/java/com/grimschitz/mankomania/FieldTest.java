package com.grimschitz.mankomania;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.grimschitz.mankomania.FieldLogic.Field;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {
    private Field first;
    private Field second;
    private Field third;
    private Field fourth;

    @Before
    public void init(){
        first = new Field(1,"First");
        second = new Field(2,"Second");
        third = new Field(3,"Third");
        fourth = new Field(4,"Fourth");

        first.setNextField(second);
        first.setOptionalNextField(third);
        first.setPreviousField(fourth);
    }

    @Test
    public void testIsIntersection(){assertTrue(first.isIntersection());}

    @Test
    public void testFieldIndex(){assertEquals(1,first.getFieldIndex());}

    @Test
    public void testDescription(){assertEquals("First",first.getFieldDescription());}

    @Test
    public void testNextField(){assertEquals(second,first.getNextField());}
    @Test
    public void testOptionalNextField(){assertEquals(third,first.getOptionalNextField());}
    @Test
    public void testPreviousField(){assertEquals(fourth,first.getPreviousField());}

}
