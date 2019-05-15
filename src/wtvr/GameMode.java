package wtvr;

import java.util.ArrayList;

public interface GameMode {
   public ArrayList<IDrops>  CreateDrops();
   public boolean EndingCondiction(int x);
}
