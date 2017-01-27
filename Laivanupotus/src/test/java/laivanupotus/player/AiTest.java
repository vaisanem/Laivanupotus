package laivanupotus.player;

import laivanupotus.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AiTest {
    
    Ai ai;
    
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
        ai = new Ai();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void shipCount() {
        assertEquals(5, ai.getPlayer().getShips().size());
    }
    
    @Test
    public void shipLengthFive() {
        Ship s = new Ship(0, 0, 0, 1);
        for (Ship sh : ai.getPlayer().getShips()) {
            if (sh.getLength() == 5) {
                s = sh;
            }
        }
        assertEquals(5, s.getLength());
    }
    @Test
    public void shipLengthFour() {
        Ship s = new Ship(0, 0, 0, 1);
        for (Ship sh : ai.getPlayer().getShips()) {
            if (sh.getLength() == 4) {
                s = sh;
            }
        }
        assertEquals(4, s.getLength());
    }
    @Test
    public void twoShipsLengthThree() {
        Ship s = new Ship(0, 0, 0, 1);
        int amount = 0;
        for (Ship sh : ai.getPlayer().getShips()) {
            if (sh.getLength() == 3) {
                s = sh;
                amount++;
            }
        }
        assertEquals(2, amount);
        assertEquals(3, s.getLength());
    }
    @Test
    public void shipLengthTwo() {
        Ship s = new Ship(0, 0, 0, 1);
        for (Ship sh : ai.getPlayer().getShips()) {
            if (sh.getLength() == 2) {
                s = sh;
            }
        }
        assertEquals(2, s.getLength());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
