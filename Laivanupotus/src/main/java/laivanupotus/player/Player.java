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
    
    public boolean shoot(Shot shot) {
        if (shot.getX() > 14 || shot.getX() < 0) {
            return false;
        }
        if (shot.getY() > 14 || shot.getY() < 0) {
            return false;
        }
        shotsFired.add(shot);
        return true;
    }
    
    public boolean addShip(Ship ship) {
        if (!shipsAreInitialized()) {
            for (Particle p : ship.getPieces()) {
                if (p.getX() > 14 || p.getY() > 14) {
                    return false;
                }
                if (p.getX() < 0 || p.getY() < 0) {
                    return false;
                }
                for (Ship s : getShips()) {
                    for (Particle pa : s.getPieces()) {
                        if (p.getX() == pa.getX() && p.getY() == pa.getY()) {
                            return false;
                        }
                        
                    }
                }
            }
            if (shipNextToAnother(ship)) {
                return false;
            }
            ships.add(ship);
            return true;
        }
        return false;
    }
    
    private boolean shipNextToAnother(Ship s) {
        for (Particle p : s.getPieces()) {
            for (Ship sh : ships) {
                for (Particle pa : sh.getPieces()) {
                    int erotus = 0;
                    int ero = 0;
                    ero += p.getX() - pa.getX();
                    if (ero < 0) {
                        ero *= -1;
                    }
                    erotus += ero;
                    ero = 0;
                    ero += p.getY() - pa.getY();
                    if (ero < 0) {
                        ero *= -1;
                    }
                    erotus += ero;
                    if (erotus > -2 && erotus < 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean shipsAreInitialized() {
        return ships.size() == 5;   
    }
    
    public boolean hasLost() {
        if (shipsAreInitialized()) {
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
