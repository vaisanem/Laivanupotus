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
    
    /**
     * AI is born, ships and shooting options are generated.
     */

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
        List<Shot> lastTen = new ArrayList();
        for (int i = 1; i < 11; i++) {
            int index = player.getShotsFired().size() - i;
            if (index < 0) {
                break;
            }
            lastTen.add(player.getShotsFired().get(index));
        }
        //we have gathered last 10 shots
        for (Shot sh : lastTen) {
            if (sh.getHit()) {
                lastHit = sh;
                break;
            }
        }
        //checked if a ship has been hitted with 1 of 5 last shots
        if (lastHit != null) {
            if (!onTheSameLine(lastTen)) {
                boolean didShoot = shootToSurroundings(lastHit);
                if (!didShoot) {
                    shootRandomly();
                }
            }
        } else {
            shootRandomly();
        }
    }
    
    private boolean onTheSameLine(List<Shot> lastTen) {
        List<Shot> same = new ArrayList();
        int sameX = 0;
        int sameY = 0;
        if (lastTen.isEmpty()) {
            return false;
        }
        Shot shot = null;
        for (Shot s : lastTen) {
            if (s.getHit()) {
                shot = s;
                same.add(shot);
                break;
            }
        }
        for (Shot s : lastTen) {
            if (!shot.equals(s) && s.getHit()) {
                if (shot.getX() - s.getX() == 0) {
                    int diffY = shot.getY() - s.getY();
                    if (diffY > -5 && diffY < 5) {
                        sameX++;
                        same.add(s);
                    }
                }    
                if (shot.getY() - s.getY() == 0) {
                    int diffX = shot.getX() - s.getX();
                    if (diffX > -5 && diffX < 5) {
                        sameY++;
                        same.add(s);
                    }
                }
            }
        }
        //checks if there is multiple shots aligned
        if (sameX > 0) {
            takeOutSurroundings('x', same);
            return shootInTheSameLine('x', lastTen);
        } else if (sameY > 0) {
            takeOutSurroundings('y', same);
            return shootInTheSameLine('y', lastTen);
        } else {
            return false;
        }
    }
    
    private boolean shootInTheSameLine(char c, List<Shot> lastTen) {
        Shot shot = null;
        if (lastTen.get(0).getHit()) {
            shot = lastTen.get(0);
        } else {
            for (Shot s : lastTen) {
                if (s.getHit()) {
                    shot = s;
                }
            }
        }
        if (c == 'x') {
            Shot shot1 = new Shot(shot.getX(), shot.getY() + 1);
            Shot shot2 = new Shot(shot.getX(), shot.getY() - 1);
            if (possibleShots.contains(shot1) && player.shoot(shot1)) {
                possibleShots.remove(shot1);
                return true;
            } else if (possibleShots.contains(shot2) && player.shoot(shot2)) {
                possibleShots.remove(shot2);
                return true;
            } else {
                return false;
            }
        } else {
            Shot shot1 = new Shot(shot.getX() + 1, shot.getY());
            Shot shot2 = new Shot(shot.getX() - 1, shot.getY());
            if (possibleShots.contains(shot1) && player.shoot(shot1)) {
                possibleShots.remove(shot1);
                return true;
            } else if (possibleShots.contains(shot2) && player.shoot(shot2)) {
                possibleShots.remove(shot2);
                return true;
            } else {
                return false;
            }
        }
    }
    
    private boolean shootToSurroundings(Shot lastHit) {
        if (lastHit != null) {
            for (int i = -1; i < 2; i += 2) {
                Shot a = new Shot(lastHit.getX() + i, lastHit.getY());
                if (possibleShots.contains(a)) {
                    if (player.shoot(a)) {
                        possibleShots.remove(a);
                        return true;
                    }
                }
                Shot b = new Shot(lastHit.getX(), lastHit.getY() + i);
                if (possibleShots.contains(b)) {
                    if (player.shoot(b)) {
                        possibleShots.remove(b);
                        return true;
                    }
                }
            }
            //tries shooting to the surroundings of the lastHit
        }
        return false;
    }
    
    private void shootRandomly() {
        while (true) {
            Shot shot = possibleShots.get(random.nextInt(possibleShots.size()));
            if (possibleShots.contains(shot)) {
                if (player.shoot(shot)) {
                    possibleShots.remove(shot);
                    break;
                }
            }
        }
    }
    
    private void takeOutSurroundings(char c, List<Shot> same) {
        if (same.size() > 2) {
            for (Shot s : same) {
                if (c == 'x') {
                    Shot sh = new Shot(s.getX() + 1, s.getY());
                    Shot sho = new Shot(s.getX() - 1, s.getY());
                    possibleShots.remove(sh);
                    possibleShots.remove(sho);
                } else if (c == 'y') {
                    Shot sh = new Shot(s.getX(), s.getY() + 1);
                    Shot sho = new Shot(s.getX(), s.getY() - 1);
                    possibleShots.remove(sh);
                    possibleShots.remove(sho);
                }
            }
        }
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
