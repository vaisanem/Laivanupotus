package laivanupotus.player;

/**
 * Class represents the artificial intelligence
 * behind the opponents actions.
 */

import java.util.*;
import java.util.Random;
import laivanupotus.domain.*;

public class Ai {
    
    private Random random;
    private Player player;
    private List<Shot> possibleShots;

    public Ai() {
        this.random = new Random();
        this.player = new Player();
        possibleShots = new ArrayList();
        generateShips();
        generateAllPossibleShots();
    }
    
    /**
     * Method tries to choose the best shooting option.
     */
    
    public void shoot() {
        Shot lastHit = null;
        List<Shot> lastFive = new ArrayList();
        for (int i = 1; i < 6; i++) {
            int index = player.getShotsFired().size() - i;
            if (index < 0) {
                break;
            }
            lastFive.add(player.getShotsFired().get(index));
        }
        //we have gathered last 5 shots
        if (!onTheSameLine(lastFive)) {
            for (Shot sh : lastFive) {
                if (sh.getHit()) {
                    lastHit = sh;
                    break;
                }
            }
            //checked if a ship has been hitted with 1 of 5 last shots
            boolean didShoot = false;
            if (lastHit != null) {
                for (int i = -1; i < 2; i += 2) {
                    Shot a = new Shot(lastHit.getX() + i, lastHit.getY());
                    boolean alreadyShot = false;
                    for (Shot sh : player.getShotsFired()) {
                        if (sh.getX() == a.getX() && sh.getY() == a.getY()) {
                            alreadyShot = true;
                        }
                    }
                    if (!alreadyShot) {
                        if (player.shoot(a)) {
                            didShoot = true;
                            possibleShots.remove(a);
                            break;
                        }
                    }
                    Shot b = new Shot(lastHit.getX(), lastHit.getY() + i);
                    alreadyShot = false;
                    for (Shot sh : player.getShotsFired()) {
                        if (sh.getX() == b.getX() && sh.getY() == b.getY()) {
                            alreadyShot = true;
                        }
                    }
                    if (!alreadyShot) {
                        if (player.shoot(b)) {
                            didShoot = true;
                            possibleShots.remove(b);
                            break;
                        }
                    }
                }
                //tries shooting to the surroundings of the lastHit
            }
            if (!didShoot) {
                shootRandomly();
            }
            //if no better option, shoots randomly
        }  
    }
    
    private boolean onTheSameLine(List<Shot> lastFive) {
        int sameX = 0;
        int sameY = 0;
        if (lastFive.isEmpty()) {
            return false;
        }
        Shot shot = lastFive.get(0);
        for (Shot s : lastFive) {
            if (s.getHit()) {
                if (shot.getX() - s.getX() == 0) {
                    int diffY = shot.getY() - s.getY();
                    if (diffY > -5 && diffY < 5) {
                        sameX++;
                    }
                } else if (shot.getY() - s.getY() == 0) {
                    int diffX = shot.getX() - s.getX();
                    if (diffX > -5 && diffX < 5) {
                        sameY++;
                    }
                }
            }
        }
        //checks if there is multiple shots aligned
        if (sameX > 1) {
            return shootInTheSameLine('x', lastFive);
        } else if (sameY > 1) {
            return shootInTheSameLine('y', lastFive);
        } else {
            return false;
        }
    }
    
    private boolean shootInTheSameLine(char c, List<Shot> lastFive) {
        Shot shot = null;
        int direction = 0;
        if (lastFive.get(0).getHit()) {
            shot = lastFive.get(0);
            direction = 1;
        } else {
            for (Shot s : lastFive) {
                if (s.getHit()) {
                    shot = s;
                    direction = -1;
                }
            }
        }
        if (c == 'x') {
            Shot shot1 = new Shot(shot.getX(), shot.getY() + direction);
            if (player.shoot(shot1)) {
                possibleShots.remove(shot1);
                return true;
            } else {
                return false;
            }
        } else {
            Shot shot1 = new Shot(shot.getX() +  direction, shot.getY());
            if (player.shoot(shot1)) {
                possibleShots.remove(shot1);
                return true;
            } else {
                return false;
            }
        }
    }
    
    private void shootRandomly() {
        while (true) {
            Shot shot = possibleShots.get(random.nextInt(possibleShots.size()));
            if (!player.getShotsFired().contains(shot)) {
                if (player.shoot(shot)) {
                    possibleShots.remove(shot);
                    break;
                }
            }
        }
    }
    
    private void takeOutSurroundings(int length) {
        //to be coming soon
    }
    
    private void generateAllPossibleShots() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Shot s = new Shot(i, j);
                possibleShots.add(s);
            }
        }
    }

    public Player getPlayer() {
        return player;
    }
    
    private void generateShips() {
        generateShip(5);
        generateShip(4);
        generateShip(3);
        generateShip(3);
        generateShip(2);
    }
    
    private void generateShip(int length) {
        while (true) {
            Ship two = new Ship(length, random.nextInt(15), random.nextInt(15), random.nextInt(4) + 1);
            if (player.addShip(two)) {
                return;
            }
        }
    }
}
