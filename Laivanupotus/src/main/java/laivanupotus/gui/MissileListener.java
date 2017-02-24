package laivanupotus.gui;

import java.awt.event.*;
import javax.swing.*;
import laivanupotus.domain.*;
import laivanupotus.game.*;

/**
 * Class takes care of the players shooting based on the input.
 */

public class MissileListener implements ActionListener {
    
    private Game game;
    private JButton jenson;
    private JTextField text;
    private JLabel message;
    
    /**
     * Gets created.
     * @param game game
     * @param jenson JButton for submitting
     * @param text JTextField to enter the details
     * @param message JLabel to communicate to the player
     */

    public MissileListener(Game game, JButton jenson, JTextField text, JLabel message) {
        this.game = game;
        this.jenson = jenson;
        this.message = message;
        this.text = text;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] details = text.getText().split(", ");
        if (details.length != 2) {
            message.setText("Details not correct");
        }
        int[] missile = new int[2];
        
        try {
            for (int i = 0; i < details.length; i++) {
                int number = Integer.parseInt(details[i]);
                missile[i] = number;
            }
        } catch (Exception ex) {
            message.setText("Details not correct");
        }
        
        Shot sh = new Shot(missile[0], missile[1]);
        if (!game.getPlayer().shoot(sh)) {
            message.setText("There was a problem shooting your missile");
//            timer.setDelay(3000);
            message.setText("Details in order (int):x, y");
        }
    }
}

