package laivanupotus.game;

import javax.swing.SwingUtilities;
import laivanupotus.domain.*;
import laivanupotus.gui.*;
import laivanupotus.player.*;

public class Game {
    
    private boolean end;
    private int turn;
    private Player player;
    private Ai ai;
    private Board boardAi;
    private Board boardPlayer;
    private Display disp;
    private ControlPanel cp;

    public Game() {
        end = false;
        turn = 0;
        player = new Player();
        ai = new Ai();
        this.boardAi = new Board(ai.getPlayer(), player);
        this.boardPlayer = new Board(player, ai.getPlayer());
        disp = new Display(this);
        SwingUtilities.invokeLater(disp);
        cp = new ControlPanel(this);
        SwingUtilities.invokeLater(cp);
    }
    
    public void letsBegin() {
        
        while (true) {
//            Ship s = new Ship(5, 0, 0, 1);
//            Ship sa = new Ship(4, 14, 0, 1);
//            Ship ss = new Ship(3, 14, 14, 3);
//            Ship sd = new Ship(3, 0, 14, 3);
//            Ship sf = new Ship(2, 7, 7, 1);
//            player.addShip(sf);
//            player.addShip(sd);
//            player.addShip(ss);
//            player.addShip(sa);
//            player.addShip(s);
            if (player.shipsAreInitialized()) {
                break;
            }
        }
        boardPlayer.update();
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            System.out.println("Error roor ror orrr rr");
//        }
        
        while (!end) {
            
            if (turn % 2 == 0) {
                int shots = player.getShotsFired().size();
                while (true) {
                    if (shots + 1 == player.getShotsFired().size()) {
                        break;
                    }
                }
                boardAi.update();
            } else {
                ai.shoot();
                //RETURN SHOT?
                Shot sh = ai.getPlayer().getShotsFired().get(ai.getPlayer().getShotsFired().size() - 1);
                for (Ship s : player.getShips()) {
                    for (Particle p : s.getPieces()) {
                        if (p.getX() == sh.getX() && p.getY() == sh.getY()) {
                            p.getShot();
                            sh.setHit(true);
                        }
                    }
                }
                boardPlayer.update();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("Errror rror or rrr");
                }
            }

            turn++;

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
