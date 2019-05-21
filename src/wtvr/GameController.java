package wtvr;

import java.util.ArrayList;

public interface GameController {
    public ArrayList<IDrops> newgame(GameMode Game);
    public void resetgame();
    public boolean gameEnder(int x);
    public void slice(IDrops obj);
    public void changeGameVariable(int x);
    public int getGameVariable();
    public void saveGame();
    public void loadGame();

}
