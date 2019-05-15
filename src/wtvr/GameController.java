package wtvr;

import java.util.ArrayList;

public interface GameController {
    public ArrayList<IDrops> newgame(GameMode Game);
    public void resetgame(int time,int score);

}
