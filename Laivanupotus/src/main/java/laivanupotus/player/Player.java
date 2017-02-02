package laivanupotus.player;

import java.util.ArrayList;
import java.util.List;
import laivanupotus.domain.*;

public class Player {
    
    private List<Ship> ships;
    private List<Shot> shotsFired;

    public Player() {
        this.ships = new ArrayList<>();
        this.shotsFired = new ArrayList<>();
    }
    
    public void shoot(int x, int y) {
        
    }
    
    public boolean addShip(Ship ship) {
        while (ships.size() < 5) {
            for (Particle p : ship.getPieces()) {
                for (Ship s : getShips()) {
                    for (Particle pa : s.getPieces()) {
                        if (p.getX() == pa.getX() && p.getY() == pa.getY()) {
                            return false;
                        }
                    }
                }
            }
            ships.add(ship);
            return true;
        }
        return false;
    }
    
    public void addShot(Shot shot) {
        shotsFired.add(shot);
    }
    
    public boolean hasLost() {
        if (ships.size() == 5) {
            for (Ship s : ships) {
                if (s.isAfloat()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Shot> getShotsFired() {
        return shotsFired;
    }
    
    
    
}
