package laivanupotus.player;

/**
 * Class provides the actions that player needs in the game.
 */

import java.util.ArrayList;
import java.util.List;
import laivanupotus.domain.*;

public class Player {
    
    private List<Ship> ships;
    private List<Shot> shotsFired;
    
    /**
     * Very nice.
     */

    public Player() {
        this.ships = new ArrayList<>();
        this.shotsFired = new ArrayList<>();
    }
    
    /**
     * Method checks that the shot is within the borders
     * and if so, adds it.
     * @param shot Shot chosen by the player.
     * @return Whether the shot was added.
     */
    
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
    
    /**
     * Method adds the new ship if it's valid.
     * @param ship Ship of the players choosing
     * @return Valid or not
     */
    
    public boolean addShip(Ship ship) {
        if (!shipsAreInitialized()) {
            if (!withinBoundaries(ship)) {
                return false;
            }
            for (Particle p : ship.getPieces()) {
                if (sameParticle(p)) {
                    return false;
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
    
    private boolean withinBoundaries(Ship ship) {
        for (Particle p : ship.getPieces()) {
            if (p.getX() < 0 || p.getX() > 14) {
                return false;
            }
            if (p.getY() < 0 || p.getY() > 14) {
                return false;
            }
        }
        return true;
    }
    
    private boolean sameParticle(Particle p) {
        for (Ship s : getShips()) {
            for (Particle pa : s.getPieces()) {
                if (p.equals(pa)) {
                    return false;
                }       
            }
        }
        return false;
    }
    
    /**
     * Checks whether all the required 5 ships are in place.
     * @return True or false
     */
    
    public boolean shipsAreInitialized() {
        return ships.size() == 5;   
    }
    
    /**
     * Checks if the player has lost the game.
     * @return true or false
     */
    
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
