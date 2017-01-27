package laivanupotus.domain;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    
    private List<Particle> pieces;
    private int length;
    private boolean afloat;
    private int x;
    private int y;
    private int direction;

    public Ship(int length, int x, int y, int direction) {
        this.length = length;
        this.afloat = true;
        this.x = x;
        this.y = y;
        this.direction = direction;
        pieces = new ArrayList<>();
        Particle p = new Particle(x, y);
        pieces.add(p);
        addOtherParticles();
        
    }
    
    public boolean isAfloat() {
        for (Particle p : pieces) {
            if (!p.isDamaged()) {
                return true;
            }
        }
        return false;
    }
    
    private void addOtherParticles() {

        for (int i = 0; i < length; i++) {
            if (direction == 1) {
                Particle pa = new Particle(x, y + i);
                pieces.add(pa);
            } else if (direction == 2) {
                Particle pa = new Particle(x + i, y);
                pieces.add(pa);
            }
            if (direction == 3) {
                Particle pa = new Particle(x, y - i);
                pieces.add(pa);
            } else if (direction == 4) {
                Particle pa = new Particle(x - i, y);
                pieces.add(pa);
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
