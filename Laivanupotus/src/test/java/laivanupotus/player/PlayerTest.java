package laivanupotus.player;

import laivanupotus.domain.*;
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
    public void stillInTheGame() {
        assertFalse(playa.hasLost());
    }
    
    @Test
    public void hasLost() {
        addShips();
        for (Ship s : playa.getShips()) {
            for(Particle p : s.getPieces()) {
                p.getShot();
            }
        }
        assertTrue(playa.hasLost());
    }
    
    @Test
    public void shipGetsAdded() {
        Ship s = new Ship(4, 1, 1, 3);
        assertTrue(playa.addShip(s));
        assertEquals(1, playa.getShips().size());
        assertEquals(s, playa.getShips().get(0));
    }
    
    @Test
    public void shotGetsAdded() {
        Shot shot = new Shot(0, 0);
        playa.shoot(0, 0);
        assertEquals(1, playa.getShotsFired().size());
    }
    
    @Test
    public void wontAddShipWithSameParticle() {
        Ship s = new Ship(4, 1, 1, 3);
        playa.addShip(s);
        assertFalse(playa.addShip(s));
    }
    
    @Test
    public void wontAddMoreThanFiveShips() {
        addShips();
        Ship sh = new Ship(2, 10, 0, 2);
        playa.addShip(sh);
        assertEquals(5, playa.getShips().size());
    }
    
    public void addShips() {
        Ship s = new Ship(5, 0, 0, 2);
        Ship sa = new Ship(4, 15, 15, 4);
        Ship ss = new Ship(3, 10, 10, 3);
        Ship se = new Ship(3, 4, 5, 3);
        Ship sg = new Ship(2, 0, 10, 4);
        playa.addShip(s);
        playa.addShip(sa);
        playa.addShip(ss);
        playa.addShip(se);
        playa.addShip(sg);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
