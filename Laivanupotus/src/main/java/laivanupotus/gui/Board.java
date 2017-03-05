package laivanupotus.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import laivanupotus.domain.*;
import laivanupotus.player.*;

/**
 * Class paints the playing board with ships and shots.
 */

public class Board extends JPanel {
    
    private Player player;
    private Player opponent;
    private boolean shipsVisible;
    
    /**
     * Creates a board.
     * @param player Player whose ships are being painted
     * @param opponent Player whose shots are being painted
     * @param shipsVisible Determines if ships are painted visible
     */

    public Board(Player player, Player opponent, boolean shipsVisible) {
        this.player = player;
        this.opponent = opponent;
        this.shipsVisible = shipsVisible;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                g.setColor(Color.blue);
                g.fillRect(i * 30, j * 30, 30, 30);
            }
        }
        
        if (shipsVisible || opponent.hasLost()) {
            g.setColor(Color.BLACK);
        }
        for (Ship s : player.getShips()) {
            for (Particle p : s.getPieces()) {
                g.fillRect(p.getX() * 30, p.getY() * 30, 30, 30);
            }
        }
        
        for (Shot sh : opponent.getShotsFired()) {
            if (sh.getHit()) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.gray);
            }
            g.fillOval(sh.getX() * 30, sh.getY() * 30, 30, 30);
        }
        
    }
    
    /**
     * Updates the board.
     */
    
    public void update() {
        repaint();
    }
    
    
}
