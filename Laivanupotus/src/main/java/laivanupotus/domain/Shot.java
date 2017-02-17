package laivanupotus.domain;

/**
 * Class creates a single shot.
 */

public class Shot {
    
    private int x;
    private int y;
    private boolean hit;

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

    public boolean getHit() {
        return hit;
    }

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
