package laivanupotus.domain;

/**
 * Class creates a ship.
 */

import java.util.ArrayList;
import java.util.List;

public class Ship {
    
    private List<Particle> pieces;
    private int length;

    public Ship(int length, int x, int y, int direction) {
        this.length = length;
        pieces = new ArrayList<>();
        addParticles(x, y, direction);
        
    }
    
    public boolean isAfloat() {
        for (Particle p : pieces) {
            if (!p.isDamaged()) {
                return true;
            }
        }
        return false;
    }
    
    private void addParticles(int x, int y, int direction) {
        
        Particle p = new Particle(x, y);
        pieces.add(p);

        for (int i = 1; i < length; i++) {
            if (direction == 1) {
                p = new Particle(x, y + i);
                pieces.add(p);
            } else if (direction == 2) {
                p = new Particle(x + i, y);
                pieces.add(p);
            }
            if (direction == 3) {
                p = new Particle(x, y - i);
                pieces.add(p);
            } else if (direction == 4) {
                p = new Particle(x - i, y);
                pieces.add(p);
            }
        }
        
    }

    public List<Particle> getPieces() {
        return pieces;
    }

    public int getLength() {
        return length;
    }
    
    
}
