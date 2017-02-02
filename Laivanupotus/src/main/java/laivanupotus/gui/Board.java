package laivanupotus.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import laivanupotus.domain.*;
import laivanupotus.game.Game;
import laivanupotus.player.*;

public class Board extends JPanel {
    
    private Game game;

    public Board(Game game) {
        this.game = game;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Ai ai = game.getAi();
        Player player = game.getPlayer();
        g.setColor(Color.BLACK);
        for (Ship s : ai.getPlayer().getShips()) {
            for (Particle p : s.getPieces()) {
                g.fill3DRect(p.getX() * 20, p.getY() * 20, 20, 20, true);
            }
        }
        
    }
    
    
}
