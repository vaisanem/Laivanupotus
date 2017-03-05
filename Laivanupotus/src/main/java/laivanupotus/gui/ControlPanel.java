package laivanupotus.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.WindowConstants;
import laivanupotus.game.Game;

/**
 * Class takes the input from the player.
 */

public class ControlPanel implements Runnable {
    
    private JFrame frame;
    private Game game;
    private JButton jenson;
    private JButton jenson2;

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
        container.setLayout(new GridLayout(12, 1));
        JLabel label = new JLabel("PLACE YOUR SHIP");
        label.setHorizontalAlignment(JLabel.CENTER);
        JLabel message = new JLabel("");
        JLabel info = new JLabel("Details in order (int): length, x, y, direction");
        JTextField text = new JTextField();
        text.setText(" length, x, y, direction 1 (Up), 2 (Right), 3 (Down), 4 (Left)");
        jenson = new JButton("Enter");
        jenson.addActionListener(new ShipListener(game, jenson, text, message));
        JLabel space = new JLabel("_________________________________________________________________");
        JLabel label2 = new JLabel("SHOOT A MISSILE");
        label2.setHorizontalAlignment(JLabel.CENTER);
        JLabel message2 = new JLabel("");
        JLabel info2 = new JLabel("Details in order (int): x, y");
        JTextField text2 = new JTextField();
        text2.setText("x, y");
        jenson2 = new JButton("Enter");
        jenson2.addActionListener(new MissileListener(game, jenson2, text2, message2));
        container.add(label);
        container.add(info);
        container.add(message);
        container.add(text);
        container.add(jenson);
        container.add(space);
        container.add(label2);
        container.add(info2);
        container.add(message2);
        container.add(text2);
        container.add(jenson2);
    }
    
    public void disableShipButton() {
        jenson.setEnabled(false);
    }
    
    public void disableMissileButton() {
        jenson2.setEnabled(false);
    }
    
    public void enableMissileButton() {
        jenson2.setEnabled(true);
    }
}
