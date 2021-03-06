package laivanupotus.player;

import laivanupotus.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AiTest {
    
    Ai ay;
    
    public AiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ay = new Ai();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void shipCount() {
        assertEquals(5, ay.getPlayer().getShips().size());
    }
    
    @Test
    public void oneShipLengthFive() {
        Ship s = new Ship(0, 0, 0, 1);
        int amount = 0;
        for (Ship sh : ay.getPlayer().getShips()) {
            if (sh.getLength() == 5) {
                s = sh;
                amount++;
            }
        }
        assertEquals(5, s.getLength());
        assertEquals(1, amount);
    }
    @Test
    public void oneShipLengthFour() {
        Ship s = new Ship(0, 0, 0, 1);
        int amount = 0;
        for (Ship sh : ay.getPlayer().getShips()) {
            if (sh.getLength() == 4) {
                s = sh;
                amount++;
            }
        }
        assertEquals(4, s.getLength());
        assertEquals(1, amount);
    }
    @Test
    public void twoShipsLengthThree() {
        Ship s = new Ship(0, 0, 0, 1);
        int amount = 0;
        for (Ship sh : ay.getPlayer().getShips()) {
            if (sh.getLength() == 3) {
                s = sh;
                amount++;
            }
        }
        assertEquals(2, amount);
        assertEquals(3, s.getLength());
    }
    @Test
    public void oneShipLengthTwo() {
        Ship s = new Ship(0, 0, 0, 1);
        int amount = 0;
        for (Ship sh : ay.getPlayer().getShips()) {
            if (sh.getLength() == 2) {
                s = sh;
                amount++;
            }
        }
        assertEquals(2, s.getLength());
        assertEquals(1, amount);
    }
    
    @Test
    public void shootingWorks() {
        ay.shoot();
        assertEquals(1, ay.getPlayer().getShotsFired().size());
    }
    
    @Test
    public void shootsToSurroundings() {
        Shot shot = new Shot(1, 0);
        Shot s = new Shot(0, 0);
        shot.setHit(true);
        ay.getPlayer().shoot(shot);
        ay.shoot();
        assertEquals(2, ay.getPlayer().getShotsFired().size());
        assertEquals(s, ay.getPlayer().getShotsFired().get(1));
    }
    
    @Test
    public void shootsToSurroundingsAgain() {
        Shot shot = new Shot(0, 0);
        Shot s = new Shot(1, 0);
        shot.setHit(true);
        ay.getPlayer().shoot(shot);
        ay.shoot();
        assertEquals(2, ay.getPlayer().getShotsFired().size());
        assertEquals(s, ay.getPlayer().getShotsFired().get(1));
    }
    
    @Test
    public void shootsInTheSameLine() {
        ay.shoot();
        Shot first = ay.getPlayer().getShotsFired().get(0);
        first.setHit(true);
        ay.shoot();
        Shot second = ay.getPlayer().getShotsFired().get(1);
        second.setHit(true);
        ay.shoot();
        Shot third = ay.getPlayer().getShotsFired().get(2);
        assertEquals(first.getY(), second.getY(), third.getY());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
