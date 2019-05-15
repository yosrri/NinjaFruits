package wtvr;

import java.util.ArrayList;

public interface GameMode {
   public ArrayList<IDrops>  createDrops();
   public boolean endingCondition(int x);
}
