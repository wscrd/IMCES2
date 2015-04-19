/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import imc.Ex2;
import java.awt.Dimension;
import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wesley
 */
public class Ex2UnitTest {
    
    public Ex2UnitTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void Ex2SetLocationTest() {
        Ex2 ex = new Ex2();
        ex.setLocation(200, 300);
        assertEquals(new Point(200, 300), ex.getLocation());
    }
    @Test
    public void EX2VisibleTest()
    {
        Ex2 ex = new Ex2();
        ex.setVisible(true);
        assertTrue(ex.isVisible());
    }
    @Test
    public void EX2SetSizeTest() {
        Ex2 ex = new Ex2();
        assertEquals(new Dimension(370,160), ex.getSize());
    }
}
