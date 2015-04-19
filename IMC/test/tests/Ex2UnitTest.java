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
    public void SetLocationTest() {
        Ex2 ex = new Ex2();
        ex.setLocation(200, 300);
        assertEquals(new Point(200, 300), ex.getLocation());
    }
    @Test
    public void VisibleTest()
    {
        Ex2 ex = new Ex2();
        ex.setVisible(true);
        assertTrue(ex.isVisible());
    }
    @Test
    public void SetSizeTest() {
        Ex2 ex = new Ex2();
        assertEquals(new Dimension(370,160), ex.getSize());
    }
    @Test
    public void CalculaTest() {
        double altura = 1.70; 
        int tipo = 0; //mulher
        double peso = 80;
        assertEquals(27.68, Ex2.Calcula(tipo, peso, altura), 0.01);
    }
    @Test
    public void MensagemTest() {
        Ex2 ex = new Ex2();
        String esperado = "PARABENS!!Voce estar com o peso ideal! IMC 21.25";
        assertEquals(esperado, ex.mensagem(1, 21.25));
    }
    @Test
    public void SetIconPeloGeneroTest () {
        Ex2 ex = new Ex2();
        ex.foto = 0;
        int esperado = 0;
        ex.setIconPeloGenero(1);//homem
        assertEquals(esperado, ex.foto);
        
    }
}
