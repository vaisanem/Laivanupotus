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
    public void noShips() {
        assertEquals(0, playa.getShips().size());
    }
    
    @Test
    public void wontAddShipWithSameParticle() {
        Ship s = new Ship(4, 1, 1, 3);
        playa.addShip(s);
        assertFalse(playa.addShip(s));
    }
    
    @Test
    public void wontAddMoreThanFiveShips() {
        Ship s = new Ship(5, 0, 0, 2);
        Ship sa = new Ship(4, 15, 15, 4);
        Ship ss = new Ship(3, 10, 10, 3);
        Ship se = new Ship(3, 4, 5, 3);
        Ship sg = new Ship(2, 0, 10, 4);
        Ship sh = new Ship(2, 10, 0, 2);
        playa.addShip(s);
        playa.addShip(sa);
        playa.addShip(ss);
        playa.addShip(se);
        playa.addShip(sg);
        playa.addShip(sh);
        assertEquals(5, playa.getShips().size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}