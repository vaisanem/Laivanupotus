package laivanupotus.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
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
        User user = game.getUser();
        
    }
    
    
}
