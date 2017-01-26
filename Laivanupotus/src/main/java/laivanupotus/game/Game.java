package laivanupotus.game;

import laivanupotus.player.*;

public class Game {
    
    private boolean end;
    private boolean turn;
    private User user;
    private Ai ai;

    public Game() {
        end = false;
        turn = true;
        user = new User();
        ai = new Ai();
    }

    public Ai getAi() {
        return ai;
    }

    public User getUser() {
        return user;
    }
    
    
    
    
}
