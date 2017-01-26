package laivanupotus;

import javax.swing.SwingUtilities;
import laivanupotus.game.Game;
import laivanupotus.gui.*;

public class Main {
    
    public static void main(String[] args) {
        Game game = new Game();
        ControlPanel sui = new ControlPanel(game);
        SwingUtilities.invokeLater(sui);
        Display gui = new Display(game);
        SwingUtilities.invokeLater(gui);
    }
    
}
