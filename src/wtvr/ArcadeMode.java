package wtvr;

import java.util.ArrayList;

public class ArcadeMode implements GameMode {
    @Override
    public ArrayList<IDrops> createDrops() {
        ArrayList<IDrops> drops= new ArrayList<IDrops>();
        FruitFactory factory = new FruitFactory();
        drops.add(factory.getFruit("apple"));
        drops.add(factory.getFruit("banana"));
        drops.add(factory.getFruit("watermelon"));
        return drops;
    }

    @Override
    public boolean endingCondition(int time) {
        if(time==60)
            return true;
        else return false;
    }
}
