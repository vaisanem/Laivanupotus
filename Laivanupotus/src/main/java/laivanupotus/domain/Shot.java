package laivanupotus.domain;

/**
 * Class creates a single shot.
 */

public class Shot {
    
    private int x;
    private int y;
    private boolean hit;
    
    /**
     * Creates a shot, has not damaged a ship by default.
     * @param x coordinate
     * @param y coordinate
     */

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
        this.hit = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    /**
     * Checks whether shot has damaged a ship.
     * @return yes or no
     */

    public boolean getHit() {
        return hit;
    }
    
    /**
     * Shot gets marked whether it has damaged a ship.
     * @param hit True of false
     */

    public void setHit(boolean hit) {
        this.hit = hit;
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
        final Shot other = (Shot) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    
}
