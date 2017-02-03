package laivanupotus.domain;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    
    private List<Particle> pieces;
    private int length;

    public Ship(int length, int x, int y, int direction) {
        this.length = length;
        pieces = new ArrayList<>();
        Particle p = new Particle(x, y);
        pieces.add(p);
        addOtherParticles(x, y, direction);
        
    }
    
    public boolean isAfloat() {
        for (Particle p : pieces) {
            if (!p.isDamaged()) {
                return true;
            }
        }
        return false;
    }
    
    private void addOtherParticles(int x, int y, int direction) {

        for (int i = 0; i < length - 1; i++) {
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
