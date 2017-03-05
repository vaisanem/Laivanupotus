package laivanupotus.gui;

import java.awt.*;
import javax.swing.*;
import laivanupotus.game.Game;

/**
 * Class presents both of the boards to the player.
 */

public class Display implements Runnable {
    
    private JFrame frame;
    private Game game;
    private JLabel info;

    public Display(Game game) {
        this.game = game;
        this.info = new JLabel("Place your ships.");
    }

    @Override
    public void run() {
        frame = new JFrame("Battleship");
        int leveys = (2 * 15 + 2) * 30 + 10 + (400);
        int korkeus = (15 + 1) * 30 + 10;
        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container) {
        container.setLayout(new GridLayout(1, 3));
        container.add(game.getBoardAi());
        Container con = new Container();
        con.setLayout(new GridLayout(6, 1));
        info.setHorizontalAlignment(JLabel.CENTER);
        con.add(info);
        container.add(con);
        container.add(game.getBoardPlayer());
    }
    
    public void update() {
        createComponents(frame);
    }
    
    public void setInfo(String text) {
        info.setText(text);
    }
    
//    public JPanel luoPaneeli() {
//        JPanel paneeli = new JPanel();
//        paneeli.setLayout(new GridLayout(2, 1));
//        JTextField text = new JTextField();
//        JButton butt = new JButton("Enter");
//        JLabel message = new JLabel();
//        butt.addActionListener(new ShipListener(game, butt, text, message));
//        paneeli.add(text);
//        paneeli.add(butt);
//        return paneeli;
//    }
    
}
