package laivanupotus.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.WindowConstants;
import laivanupotus.game.Game;

public class ControlPanel implements Runnable {
    
    private JFrame frame;
    private Game game;

    public ControlPanel(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        frame = new JFrame("Battleship");

        frame.setPreferredSize(new Dimension(400, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container) {
        
    }
}
