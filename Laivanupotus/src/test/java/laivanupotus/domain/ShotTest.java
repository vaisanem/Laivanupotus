/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ShotTest {
    
    Shot shot;
    
    public ShotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        shot = new Shot(0, 0);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void notHitUntilProvenOtherwise() {
        assertFalse(shot.getHit());
    }
    
    @Test
    public void setHitWorks() {
        shot.setHit(true);
        assertTrue(shot.getHit());
    }
    
    @Test
    public void notEqual() {
        Particle p = new Particle(0, 0);
        Shot s = new Shot(0, 0);
        Shot sh = new Shot(1, 0);
        Shot sho = new Shot(0, 1);
        assertFalse(s.equals(p));
        assertFalse(s.equals(sh));
        assertFalse(s.equals(sho));
        assertFalse(s.equals(null));
    }
    
    @Test
    public void equals() {
        Shot p = new Shot(0, 0);
        Shot s = new Shot(0, 0);
        assertTrue(p.equals(s));
        s = p;
        assertTrue(p.equals(s));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
