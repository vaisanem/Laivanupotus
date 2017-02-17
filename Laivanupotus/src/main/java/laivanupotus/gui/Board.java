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

    public Board(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
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
        
        g.setColor(Color.BLACK);
        for (Ship s : player.getShips()) {
            for (Particle p : s.getPieces()) {
                g.fill3DRect(p.getX() * 30, p.getY() * 30, 30, 30, true);
            }
        }
        
        for (Shot sh : opponent.getShotsFired()) {
            if (sh.getHit()) {
                g.setColor(Color.red);
                g.fillOval(sh.getX() * 30, sh.getY() * 30, 30, 30);
            } else {
                g.setColor(Color.gray);
                g.fillOval(sh.getX() * 30, sh.getY() * 30, 30, 30);
            }
        }
        
    }
    
    /**
     * Updates the board.
     */
    
    public void update() {
        repaint();
    }
    
    
}
