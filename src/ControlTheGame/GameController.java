package ControlTheGame;

import java.util.ArrayList;

import Objects.IDrops;

public interface GameController {
	 public ArrayList<IDrops> newgame(GameMode Game);
	    public void resetgame();
	    public boolean gameEnder(int x);
	    public void slice(IDrops obj);
	    public void changeGameVariable(int x);
	    public int getGameVariable();
	    public void setBoolean(Boolean x,IDrops drop);
	    public Boolean getBoolean(IDrops drop);
	    public void setY(int y,IDrops drop);
	    public void setX(int x,IDrops drop);
	    public void setMissed(int x);
	    public int getMissed();
	    public void saveGame();
	    public void loadGame();
	    public int getScore ();
	    public void setScore(int x);
}
