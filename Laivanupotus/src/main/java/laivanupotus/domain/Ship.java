package laivanupotus.domain;

import java.util.List;

public class Ship {
    
    private List<Particle> pieces;
    private int length;
    private boolean afloat;

    public Ship(int length, int x, int y, int direction) {
        this.length = length;
        this.afloat = true;
        Particle p = new Particle(x, y);
        pieces.add(p);
        if (direction < 3) {
            for (int i = 1; i < length; i++) {
                if (direction == 1) {
                    Particle pa = new Particle(x, y + 1);
                    pieces.add(p);
                } else if (direction == 2) {
                    Particle pa = new Particle(x + 1, y);
                    pieces.add(p);
                }
            }
        }
        if (direction > 2) {
            for (int i = 1; i < length; i--) {
                if (direction == 3) {
                    Particle pa = new Particle(x, y - 1);
                    pieces.add(p);
                } else if (direction == 4) {
                    Particle pa = new Particle(x - 1, y);
                    pieces.add(p);
                }
            }
        }
        
        
    }
    
    public boolean isAfloat() {
        for (Particle p : pieces) {
            if (!p.isDamaged()) {
                return true;
            }
        }
        return false;
    }

    public List<Particle> getPieces() {
        return pieces;
    }

    public int getLength() {
        return length;
    }
    
    
}
