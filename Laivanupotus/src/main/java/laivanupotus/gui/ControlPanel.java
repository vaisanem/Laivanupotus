package laivanupotus.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
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
        container.setLayout(new GridLayout(10, 3));
        JLabel label = new JLabel("PLACE YOUR SHIP");
        JLabel message = new JLabel("Details in order (int): length, x, y, direction");
        JTextField text = new JTextField();
        text.setText(" length, x, y, direction 1 (Up), 2 (Right), 3 (Down), 4 (Left)");
        JButton jenson = new JButton("Enter");
        jenson.addActionListener(new ShipListener(game, jenson, text, message));
        JLabel space = new JLabel("");
        JLabel label2 = new JLabel("SHOOT A MISSILE");
        JLabel message2 = new JLabel("Details in order (int): x, y");
        JTextField text2 = new JTextField();
        text2.setText("x, y");
        JButton jenson2 = new JButton("Enter");
        jenson2.addActionListener(new MissileListener(game, jenson2, text2, message2));
        container.add(label);
        container.add(message);
        container.add(text);
        container.add(jenson);
        container.add(space);
        container.add(label2);
        container.add(message2);
        container.add(text2);
        container.add(jenson2);
    }
}
