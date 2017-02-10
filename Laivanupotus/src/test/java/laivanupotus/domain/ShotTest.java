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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
