package laivanupotus.game;

import javax.swing.SwingUtilities;
import laivanupotus.domain.*;
import laivanupotus.gui.*;
import laivanupotus.player.*;

/**
 * Class has the components needed 
 * and a loop responsible of executing game actions.
 */

public class Game {
    
    private boolean end;
    private int turn;
    private Player player;
    private Ai ai;
    private Ai ai2;
    private Board boardAi;
    private Board boardPlayer;
    private Display disp;
    private ControlPanel cp;
    
    /**
     * Game gets created with all of its components.
     */

    public Game() {
        end = false;
        turn = 0;
        player = new Player();
        ai = new Ai();
        ai2 = new Ai();
        this.boardAi = new Board(ai.getPlayer(), ai2.getPlayer());
        this.boardPlayer = new Board(ai2.getPlayer(), ai.getPlayer());
        disp = new Display(this);
        SwingUtilities.invokeLater(disp);
        cp = new ControlPanel(this);
        SwingUtilities.invokeLater(cp);
    }
    
    /**
     * Game loop.
     */
    
    public void letsBegin() {
        
//        while (true) {
////            Ship s = new Ship(5, 0, 0, 1);
////            Ship sa = new Ship(4, 14, 0, 1);
////            Ship ss = new Ship(3, 14, 14, 3);
////            Ship sd = new Ship(3, 0, 14, 3);
////            Ship sf = new Ship(2, 7, 7, 1);
////            player.addShip(sf);
////            player.addShip(sd);
////            player.addShip(ss);
////            player.addShip(sa);
////            player.addShip(s);
//            if (player.shipsAreInitialized()) {
//                break;
//            }
//            
//            waitASecondOrTwo();
//        }
//        boardPlayer.update();
        
        boolean winner = true;
        
        while (!end) {
            
            if (turn % 2 == 0) {
                disp.setInfo("On vuorosi.");
//                playerShoots();
                ai2Shoots();
                boardAi.update();
                disp.setInfo("Odota...");
                waitASecondOrTwo();
                
            } else {
                aiShoots();
                boardPlayer.update();
                
                waitASecondOrTwo();
            }
            
            if (ai2.getPlayer().hasLost()) {
//            if (player.hasLost()) {
                winner = false;
                end = true;
            } else if (ai.getPlayer().hasLost()) {
                end = true;
            }

            turn++;

        }
        String text = "Voitit";
        if (!winner) {
            text = "Hävisit";
        }
        disp.setInfo(text + " pelin!");
        
    }
    
    private void playerShoots() {
        int shots = player.getShotsFired().size();
        while (true) {
            if (shots + 1 == player.getShotsFired().size()) {
                break;
            }
            waitASecondOrTwo();
        }
        Player aiPlayer = ai.getPlayer();
        didItHit(player, aiPlayer);
    }
    
    private void aiShoots() {
        ai.shoot();
        //RETURN SHOT?
        Player aiPlayer = ai.getPlayer();
        Player ai2Player = ai2.getPlayer();
        didItHit(aiPlayer, ai2Player);
    }
    
    private void ai2Shoots() {
        ai2.shoot();
        //RETURN SHOT?
        Player ai2Player = ai2.getPlayer();
        Player aiPlayer = ai.getPlayer();
        didItHit(ai2Player, aiPlayer);
    }
    
    private void didItHit(Player shooter, Player target) {
        Shot sh = shooter.getShotsFired().get(shooter.getShotsFired().size() - 1);
        for (Ship s : target.getShips()) {
            for (Particle p : s.getPieces()) {
                if (p.getX() == sh.getX() && p.getY() == sh.getY()) {
                    p.getShot();
                    sh.setHit(true);
                }
            }
        }
    }
    
    private void waitASecondOrTwo() {
        try {
            Thread.sleep(1250);
        } catch (Exception e) {
            System.out.println("Errror rror or rrr");
        }
    }

    public Ai getAi() {
        return ai;
    }

    public Player getPlayer() {
        return player;
    }

    public Board getBoardAi() {
        return this.boardAi;
    }

    public Board getBoardPlayer() {
        return this.boardPlayer;
    }
    
}
