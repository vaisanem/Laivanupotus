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
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Start again");
        }
        game.letsBegin();
    }
    
}
