package wtvr;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class ClassicMode implements GameMode {

    @Override
    public ArrayList<IDrops> createDrops() {
        ArrayList<IDrops> drops= new ArrayList<IDrops>();
        FruitFactory factory = new FruitFactory();
        drops.add(factory.getFruit("apple"));
        drops.add(factory.getFruit("banana"));
        drops.add(factory.getFruit("watermelon"));
        drops.add(new Bomb());
        drops.add(new FatalBomb());
        return drops;
    }

    @Override
    public boolean endingCondition(int lives) {
        if(lives<=0)
            return true;
         else return false;
    }
}
