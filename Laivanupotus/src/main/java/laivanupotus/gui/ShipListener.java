package laivanupotus.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import laivanupotus.domain.Ship;
import laivanupotus.game.*;

/**
 * Class takes care of adding the players ships.
 */

public class ShipListener implements ActionListener {
    
    private Game game;
    private JButton jenson;
    private JTextField text;
    private JLabel message;

    public ShipListener(Game game, JButton jenson, JTextField text, JLabel message) {
        this.game = game;
        this.jenson = jenson;
        this.text = text;
        this.message = message;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] details = text.getText().split(", ");
        if (details.length != 4) {
            message.setText("Details not correct");
        }
        int[] ship = new int[4];
        
        try {
            for (int i = 0; i < details.length; i++) {
                int number = Integer.parseInt(details[i]);
                ship[i] = number;
            }
        } catch (Exception ex) {
            message.setText("Details not correct");
        }
        
        Ship sh = new Ship(ship[0], ship[1], ship[2], ship[3]);
        if (!game.getPlayer().addShip(sh)) {
            message.setText("There was a problem adding your ship");
//            timer.setDelay(3000);
            message.setText("Details in order (int): length, x, y, direction");
        }
    }
}
