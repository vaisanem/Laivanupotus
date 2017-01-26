package laivanupotus.player;

import java.util.ArrayList;
import java.util.List;
import laivanupotus.domain.*;

public abstract class Player {
    
    private List<Ship> ships;
    private List<Shot> shotsFired;

    public Player() {
        this.ships = new ArrayList<>();
        this.shotsFired = new ArrayList<>();
    }
    
    public abstract void shoot(int x, int y);
    
    public void addShip(Ship ship) {
        while (ships.size() < 6) {
            ships.add(ship);
        }
    }
    
    public void addShot(Shot shot) {
        shotsFired.add(shot);
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Shot> getShotsFired() {
        return shotsFired;
    }
    
    
    
}
