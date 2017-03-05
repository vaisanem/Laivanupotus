package laivanupotus.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class creates a ship.
 */

public class Ship {
    
    private List<Particle> pieces;
    private int length;
    
    /**
     * Creates a ship.
     * @param length Amount of particles in a ship
     * @param x Coordinate of the first particle
     * @param y Coordinate of the first particle
     * @param direction Integer value of the direction of the other particles
     */

    public Ship(int length, int x, int y, int direction) {
        pieces = new ArrayList<>();
        addParticles(length, x, y, direction);
        this.length = pieces.size();
    }
    
    /**
     * Checks if the ship  has sunken.
     * @return yes or no
     */
    
    public boolean isAfloat() {
        for (Particle p : pieces) {
            if (!p.isDamaged()) {
                return true;
            }
        }
        return false;
    }
    
    private void addParticles(int length, int x, int y, int direction) {
        
        Particle p = new Particle(x, y);
        pieces.add(p);

        for (int i = 1; i < length; i++) {
            if (direction == 1) {
                p = new Particle(x, y - i);
                pieces.add(p);
            } else if (direction == 2) {
                p = new Particle(x + i, y);
                pieces.add(p);
            }
            if (direction == 3) {
                p = new Particle(x, y + i);
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
