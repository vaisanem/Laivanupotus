package laivanupotus.domain;

public class Particle {
    
    private int x;
    private int y;
    private boolean damaged;

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
    
    public void getShot() {
        damaged = true;
    }

    public boolean isDamaged() {
        return damaged;
    }
    
}
