package laivanupotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParticleTest {
    
    Particle p;
    
    public ParticleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Particle(1,1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void notDamaged() {
        assertFalse(p.isDamaged());
    }
    
    @Test
    public void damaging() {
        p.getShot();
        assertTrue(p.isDamaged());
    }
    
    @Test
    public void notEqual() {
        Particle p = new Particle(0, 0);
        Particle pa = new Particle(1, 0);
        Particle par = new Particle(0, 1);
        Shot s = new Shot(0, 0);
        assertFalse(p.equals(s));
        assertFalse(p.equals(pa));
        assertFalse(p.equals(par));
        assertFalse(p.equals(null));
    }
    
    @Test
    public void equals() {
        Particle p = new Particle(0, 0);
        Particle s = new Particle(0, 0);
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
