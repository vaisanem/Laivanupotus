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
    public void shipsAreInitialized() {
        addShips();
        assertTrue(playa.shipsAreInitialized());
    }
    
    @Test
    public void stillInTheGame() {
        assertFalse(playa.hasLost());
        addShips();
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
    public void noShots() {
        assertEquals(0, playa.getShotsFired().size());
    }
    
    @Test
    public void invalidShotNotAdded() {
        Shot shot = new Shot(-1, -1);
        assertFalse(playa.shoot(shot));
        shot = new Shot(-1, 15);
        assertFalse(playa.shoot(shot));
        shot = new Shot(15, -1);
        assertFalse(playa.shoot(shot));
        shot = new Shot(15, 15);
        assertFalse(playa.shoot(shot));
        shot = new Shot(0, 15);
        assertFalse(playa.shoot(shot));
        assertEquals(0, playa.getShotsFired().size());
    }
    
    @Test
    public void shotsGetAdded() {
        Shot shot = new Shot(0, 0);
        Shot s = new Shot(0, 14);
        Shot sh = new Shot(14, 0);
        Shot sho = new Shot(14, 14);
        playa.shoot(shot);
        playa.shoot(sho);
        playa.shoot(s);
        playa.shoot(sh);
        assertEquals(4, playa.getShotsFired().size());
    }
    
    @Test
    public void wontAddIfShipWithWrongLength() {
        Ship ship = new Ship(1, 2, 2, 2);
        Ship ship2 = new Ship(6, 2, 2, 2);
        playa.addShip(ship);
        playa.addShip(ship2);
        assertEquals(0, playa.getShips().size());
    }
    
    @Test
    public void wontAddShipWithSameParticle() {
        Ship s = new Ship(4, 1, 1, 3);
        Ship sa = new Ship(3, 1, 1, 2);
        playa.addShip(s);
        assertFalse(playa.addShip(sa));
        assertEquals(1, playa.getShips().size());
    }
    
    @Test
    public void wontAddShipRightNextTo() {
        Ship s = new Ship(4, 1, 1, 3);
        Ship sh = new Ship(3, 2, 1, 3);
        Ship shi = new Ship(2, 1, 5, 3);
        Ship ship = new Ship(5, 0, 0, 2);
        Ship ships = new Ship(5, 0, 0, 3);
        playa.addShip(s);
        assertFalse(playa.addShip(sh));
        assertFalse(playa.addShip(shi));
        assertFalse(playa.addShip(ship));
        assertFalse(playa.addShip(ships));
        assertEquals(1, playa.getShips().size());
    }
    
    @Test
    public void wontAddMoreThanFiveShips() {
        addShips();
        Ship sh = new Ship(2, 10, 0, 2);
        playa.addShip(sh);
        assertEquals(5, playa.getShips().size());
    }
    
    @Test
    public void quantityLimitsWork() {
        Ship s = new Ship(5, 0, 0, 2);
        Ship ss = new Ship(5, 10, 10, 4);
        playa.addShip(s);
        playa.addShip(ss);
        assertEquals(1, playa.getShips().size());
        Ship a = new Ship(4, 14, 14, 4);
        Ship aa = new Ship(4, 10, 10, 4);
        playa.addShip(a);
        playa.addShip(aa);
        assertEquals(2, playa.getShips().size());
        Ship k = new Ship(3, 10, 10, 3);
        Ship v = new Ship(3, 4, 5, 3);
        Ship kv = new Ship(3, 14, 0, 1);
        playa.addShip(k);
        playa.addShip(v);
        playa.addShip(kv);
        assertEquals(4, playa.getShips().size());
    }
    
    @Test
    public void addShips() {
        Ship s = new Ship(5, 0, 0, 2);
        Ship sa = new Ship(4, 14, 14, 4);
        Ship ss = new Ship(3, 10, 10, 3);
        Ship se = new Ship(3, 4, 5, 3);
        Ship sg = new Ship(2, 0, 10, 2);
        playa.addShip(s);
        playa.addShip(sa);
        playa.addShip(ss);
        playa.addShip(se);
        playa.addShip(sg);
        assertEquals(5, playa.getShips().size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
