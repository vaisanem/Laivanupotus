package laivanupotus;

import javax.swing.SwingUtilities;
import laivanupotus.game.Game;
import laivanupotus.gui.*;

public class Main {
    
    public static void main(String[] args) {
        Game game = new Game();
        ControlPanel cp = new ControlPanel(game);
        SwingUtilities.invokeLater(cp);
        Display disp = new Display(game);
        SwingUtilities.invokeLater(disp);
    }
    
}
