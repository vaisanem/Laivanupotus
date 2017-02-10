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
    
}
