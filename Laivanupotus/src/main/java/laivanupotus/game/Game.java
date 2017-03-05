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
        this.boardAi = new Board(ai.getPlayer(), player, false);
        this.boardPlayer = new Board(player, ai.getPlayer(), true);
        disp = new Display(this);
        SwingUtilities.invokeLater(disp);
        cp = new ControlPanel(this);
        SwingUtilities.invokeLater(cp);
    }
    
    /**
     * Game loop.
     */
    
    public void letsBegin() {
        
        cp.disableMissileButton();
        while (true) {
            
            if (player.shipsAreInitialized()) {
                break;
            }
            
            boardPlayer.update();
            waitASecond();
        }
        
        cp.disableShipButton();
        
        boolean winner = true;
        
        while (!end) {
            
            if (turn % 2 == 0) {
                disp.setInfo("Your turn.");
                cp.enableMissileButton();
                playerShoots();
//                ai2Shoots();
                boardAi.update();
                disp.setInfo("Wait...");
                cp.disableMissileButton();
                waitASecond();
                
            } else {
                aiShoots();
                boardPlayer.update();
                waitASecond();
            }
            
            if (player.hasLost()) {
                winner = false;
                end = true;
            } else if (ai.getPlayer().hasLost()) {
                end = true;
            }

            turn++;

        }
        boardAi.update();
        waitASecond();
        cp.disableMissileButton();
        String text = "won";
        if (!winner) {
            text = "lost";
        }
        disp.setInfo("You " + text + " the game!");
    }
    
    private void playerShoots() {
        int shots = player.getShotsFired().size();
        while (true) {
            if (shots + 1 == player.getShotsFired().size()) {
                break;
            }
            waitASecond();
        }
        didItHit(player, ai.getPlayer());
    }
    
    private void aiShoots() {
        ai.shoot();
        didItHit(ai.getPlayer(), player);
    }
    
//    private void ai2Shoots() {
//        ai2.shoot();
//        //RETURN SHOT?
//        Player ai2Player = ai2.getPlayer();
//        Player aiPlayer = ai.getPlayer();
//        didItHit(ai2Player, aiPlayer);
//    }
    
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
    
    private void waitASecond() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Threadia ei nukuta.");
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
