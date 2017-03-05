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
    public void asManyPartcilesAsLength() {
        assertEquals(ship.getLength(), ship.getPieces().size());
    }
    
    @Test
    public void correctParticles() {
        Particle p = new Particle(2, 2);
        Particle pa = new Particle(2, 3);
        Particle par = new Particle(2, 4);
        assertEquals(p, ship.getPieces().get(0));
        assertEquals(pa, ship.getPieces().get(1));
        assertEquals(par, ship.getPieces().get(2));
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
