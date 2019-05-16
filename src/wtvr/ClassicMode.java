package wtvr;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class ClassicMode implements GameMode {
 int lives=3;

    public int getGameVariable() {
        return lives;
    }

    public void setGameVariable(int lives) {
        this.lives = lives;
    }

    @Override
    public void intializeGameVariable() {
        lives=3;
    }

    @Override
    public ArrayList<IDrops> createDrops() {
        ArrayList<IDrops> Drops= new ArrayList<IDrops>();
        FruitFactory factory = new FruitFactory();
        Drops.add(factory.getFruit("apple"));
        Drops.add(factory.getFruit("banana"));
        Drops.add(factory.getFruit("watermelon"));
        Drops.add(Bomb.getInstance());
        Drops.add(FatalBomb.getInstance());
        return Drops;
    }

    @Override
    public boolean endingCondition(int lives) {
        if(lives<=0)
            return true;
         else return false;
    }
}
