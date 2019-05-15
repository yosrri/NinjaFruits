package wtvr;

import java.util.ArrayList;

public class ArcadeMode implements GameMode {
    @Override
    public ArrayList<IDrops> CreateDrops() {
        ArrayList<IDrops> Drops= new ArrayList<IDrops>();
        FruitFactory factory = new FruitFactory();
        Drops.add(factory.getFruit("apple"));
        Drops.add(factory.getFruit("banana"));
        Drops.add(factory.getFruit("watermelon"));
        return Drops;
    }

    @Override
    public boolean EndingCondiction(int time) {
        if(time==60)
            return true;
        else return false;
    }


}
