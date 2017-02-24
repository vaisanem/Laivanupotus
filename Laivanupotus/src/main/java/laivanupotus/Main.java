package laivanupotus;

import javax.swing.SwingUtilities;
import laivanupotus.game.Game;
import laivanupotus.gui.*;

public class Main {
    
    /**
     * Game gets created and started.
     * @param args argh
     */
    
    public static void main(String[] args) {
        Game game = new Game();
//        ControlPanel cp = new ControlPanel(game);
//        SwingUtilities.invokeLater(cp);
//        Display disp = new Display(game);
//        SwingUtilities.invokeLater(disp);
//        game.setBoardAi(disp.getBoardAi());
//        game.setBoardPlayer(disp.getBoardPlayer());
//        while (true) {
//            if (game.getPlayer().shipsAreInitialized()) {
//                break;
//            }
//        }
        game.letsBegin();
    }
    
}
