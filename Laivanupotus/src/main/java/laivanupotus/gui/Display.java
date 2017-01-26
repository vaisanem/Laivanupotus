package laivanupotus.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import laivanupotus.game.Game;

public class Display implements Runnable{
    
    private JFrame frame;
    private Game game;
    private Board board;

    public Display(Game game) {
        this.game = game;
    }
    
    

    @Override
    public void run() {
        frame = new JFrame("Battleship");

        frame.setPreferredSize(new Dimension(850, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container) {
        this.board = new Board(game);
        container.add(board);
    }
}
