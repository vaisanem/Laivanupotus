package laivanupotus.player;

/**
 * Class represents the artificial intelligence
 * behind the opponents actions.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import laivanupotus.domain.*;

public class Ai {
    
    private Random random;
    private Player player;

    public Ai() {
        this.random = new Random();
        this.player = new Player();  
        generateShips();
    }
    
    /**
     * Method tries to choose the best shooting option.
     */
    
    public void shoot() {
        Shot lastHit = null;
        List<Shot> lastFour = new ArrayList();
        for (int i = 1; i < 5; i++) {
            int indeksi = player.getShotsFired().size() - i;
            if (indeksi < 0) {
                break;
            }
            lastFour.add(player.getShotsFired().get(indeksi));
        }
        for (Shot sh : lastFour) {
            if (sh.getHit()) {
                lastHit = sh;
                break;
            }
        }
        boolean ampui = false;
        if (lastHit != null) {
            for (int i = -1; i < 2; i += 2) {
                Shot a = new Shot(lastHit.getX() + i, lastHit.getY());
                boolean ammuttu = false;
                for (Shot sh : player.getShotsFired()) {
                    if (sh.getX() == a.getX() && sh.getY() == a.getY()) {
                        ammuttu = true;
                    }
                }
                if (!ammuttu) {
                    if (player.shoot(a)) {
                        ampui = true;
                        break;
                    }
                }
                Shot b = new Shot(lastHit.getX(), lastHit.getY() + i);
                ammuttu = false;
                for (Shot sh : player.getShotsFired()) {
                    if (sh.getX() == b.getX() && sh.getY() == b.getY()) {
                        ammuttu = true;
                    }
                }
                if (!ammuttu) {
                    if (player.shoot(b)) {
                        ampui = true;
                        break;
                    }
                }
                
            }
        }
        
        if (!ampui) {
            while (true) {
                int x = random.nextInt(15);
                int y = random.nextInt(15);
                Shot shot = new Shot(x, y);
                if (!player.getShotsFired().contains(shot)) {
                    if (player.shoot(shot)) {
                        break;
                    }
                }
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
