package com.grimschitz.mankomania.Boerse;


import com.grimschitz.mankomania.PlayerLogic.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class BoerseTest {

    private static Player p;
    private static Boerse boerse;

    @BeforeAll
    public static void init() {
        p = new Player();
        boerse = new Boerse(p);
    }
    @Test
    @Order(1)
    public void testGetShareSteel() {
        Assertions.assertEquals(2,  boerse.getShareSteel());
    }
    @Test
    @Order(2)
    public void testGetShareOil() {
        Assertions.assertEquals(2,  boerse.getShareSteel());
    }
    @Test
    @Order(3)
    public void testGetSharePower() {
        Assertions.assertEquals(2,  boerse.getSharePower());
    }
    @Test
    @Order(4)
    public void testzaddShare() {
        int s = boerse.getShareSteel();
        int o = boerse.getShareOil();
        int p = boerse.getSharePower();

        boerse.addShare(1,1);
        boerse.addShare(1,2);
        boerse.addShare(1,3);

        Assertions.assertEquals(s+1,  boerse.getShareSteel());
        Assertions.assertEquals(o+1,  boerse.getShareSteel());
        Assertions.assertEquals(p+1,  boerse.getShareSteel());
    }
    @Test
    @Order(5)
    public void testzdelShare() {
        int s = boerse.getShareSteel();
        int o = boerse.getShareOil();
        int p = boerse.getSharePower();

        boerse.delShare(1,1);
        boerse.delShare(1,2);
        boerse.delShare(1,3);

        Assertions.assertEquals(s-1,  boerse.getShareSteel());
        Assertions.assertEquals(o-1,  boerse.getShareSteel());
        Assertions.assertEquals(p-1,  boerse.getShareSteel());
    }
}