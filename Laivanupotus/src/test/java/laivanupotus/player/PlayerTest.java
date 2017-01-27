package laivanupotus.player;

import laivanupotus.domain.Ship;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    Player playa;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        playa = new Player();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void wontAddShipWithSameParticle() {
        Ship s = new Ship(4, 1, 1, 3);
        playa.addShip(s);
        assertFalse(playa.addShip(s));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
