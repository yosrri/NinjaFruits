package wtvr;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class ClassicMode implements GameMode {

    @Override
    public ArrayList<IDrops> CreateDrops() {
        ArrayList<IDrops> Drops= new ArrayList<IDrops>();
        FruitFactory factory = new FruitFactory();
        Drops.add(factory.getFruit("apple"));
        Drops.add(factory.getFruit("banana"));
        Drops.add(factory.getFruit("watermelon"));
        Drops.add(new Bomb());
        Drops.add(new FatalBomb());
        return Drops;
    }

    @Override
    public boolean EndingCondiction(int lives) {
        if(lives<=0)
            return true;
         else return false;
    }
}
