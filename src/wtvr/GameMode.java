package wtvr;

import java.util.ArrayList;

public interface GameMode {
   public ArrayList<IDrops>  createDrops();
   public boolean endingCondition(int x);
   public int getGameVariable();
   public void setGameVariable(int x);
   public void intializeGameVariable();
}
