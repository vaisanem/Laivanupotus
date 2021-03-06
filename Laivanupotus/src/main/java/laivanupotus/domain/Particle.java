package laivanupotus.domain;

/**
 * Class creates a single particle of a ship.
 */

public class Particle {
    
    private int x;
    private int y;
    private boolean damaged;
    
    /**
     * Creates a particle, not damaged by default.
     * @param x coordinate
     * @param y coordinate
     */

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
        this.damaged = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    /**
     * Particle gets hit.
     */
    
    public void getShot() {
        damaged = true;
    }
    
    /**
     * Checks if the particle has been hit.
     * @return yes or no
     */

    public boolean isDamaged() {
        return damaged;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Particle other = (Particle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    
    
}
