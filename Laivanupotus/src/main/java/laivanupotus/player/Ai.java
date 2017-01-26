package laivanupotus.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import laivanupotus.domain.Shot;

public class Ai extends Player {
    
    private int x;
    private int y;
    private Random random;

    public Ai() {
        this.random = new Random();
    }

    @Override
    public void shoot(int x, int y) {
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void newCoordinates() {
        x = random.nextInt(16);
        y = random.nextInt(16);
    }
    
    
    
}
