package com.grimschitz.mankomania.Boerse;


import com.grimschitz.mankomania.PlayerLogic.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class BoerseTest {

    private Player p;
    private Boerse boerse;

    @BeforeAll
    public static void init() {
        Player p = new Player();
        Boerse boerse = p.getPlayerBoerse();

    }
    @Test
    public void testGetShareSteel() {
        Assertions.assertEquals(2,  boerse.getShareSteel());
    }
    @Test
    public void testGetShareOil() {
        Assertions.assertEquals(2,  boerse.getShareSteel());
    }
    @Test
    public void testGetSharePower() {
        Assertions.assertEquals(2,  boerse.getSharePower());
    }
    @Test
    public void testaddShare() {
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
    public void testdelShare() {
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