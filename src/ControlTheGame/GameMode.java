package ControlTheGame;

import java.util.ArrayList;

import Objects.IDrops;

public interface GameMode {
	   public ArrayList<IDrops>  createDrops();
	   public boolean endingCondition(int x);
	   public int getGameVariable();
	   public void setGameVariable(int x);
	   public void intializeGameVariable();
	   public void setScore(int x);
	   public int getScore();
}