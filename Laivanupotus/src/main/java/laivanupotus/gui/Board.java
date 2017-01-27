package laivanupotus.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import laivanupotus.domain.*;
import laivanupotus.game.Game;
import laivanupotus.player.*;

public class Board extends JPanel{
    
    private Game game;

    public Board(Game game) {
        this.game = game;
    }
    
    protected void paintComponent(Graphics g) {
        super.paint(g);
        Ai ai = game.getAi();
        Player player = game.getPlayer();
        for (Ship s : ai.getPlayer().getShips()) {
            for (Particle p : s.getPieces()) {
                g.fillRect(p.getX(), p.getY(), 1, 1);
            }
        }
        
    }
    
    
}
