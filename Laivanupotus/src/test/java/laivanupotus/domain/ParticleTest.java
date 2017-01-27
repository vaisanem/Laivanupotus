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
    public void damage() {
        p.getShot();
        assertTrue(p.isDamaged());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
