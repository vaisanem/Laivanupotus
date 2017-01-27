package laivanupotus.game;

import laivanupotus.player.*;

public class Game {
    
    private boolean end;
    private boolean turn;
    private Player player;
    private Ai ai;

    public Game() {
        end = false;
        turn = true;
        player = new Player();
        ai = new Ai();
    }

    public Ai getAi() {
        return ai;
    }

    public Player getPlayer() {
        return player;
    }
    
    
    
    
}
