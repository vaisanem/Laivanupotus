package laivanupotus.player;

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
    
    public void shoot() {
        
    }

    public Player getPlayer() {
        return player;
    }
    
    private void generateShips() {
        Ship five = new Ship(5, random.nextInt(16), random.nextInt(16), random.nextInt(4) + 1);
        player.addShip(five);
        while (true) {
            Ship four = new Ship(4, random.nextInt(16), random.nextInt(16), random.nextInt(4) + 1);
            if (player.addShip(four)) {
                break;
            }
        }
        while (true) {
            Ship three = new Ship(3, random.nextInt(16), random.nextInt(16), random.nextInt(4) + 1);
            if (player.addShip(three)) {
                break;
            }
        }
        while (true) {
            Ship three2 = new Ship(3, random.nextInt(16), random.nextInt(16), random.nextInt(4) + 1);
            if (player.addShip(three2)) {
                break;
            }
        }
        while (true) {
            Ship two = new Ship(2, random.nextInt(16), random.nextInt(16), random.nextInt(4) + 1);
            if (player.addShip(two)) {
                break;
            }
        }
        
    }
    
}
