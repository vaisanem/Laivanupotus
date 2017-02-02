package laivanupotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShipTest {
    
    Ship ship;
    
    public ShipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ship = new Ship(3, 2, 2, 3);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void isAfloat() {
        assertTrue(ship.isAfloat());
    }
    
    @Test
    public void damagedButAfloat() {
        ship.getPieces().get(0).getShot();
        assertTrue(ship.isAfloat());
    }
    
    @Test
    public void sinks() {
        for (Particle p : ship.getPieces()) {
            p.getShot();
        }
        assertFalse(ship.isAfloat());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
