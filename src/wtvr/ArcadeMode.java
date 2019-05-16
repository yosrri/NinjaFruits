package wtvr;

import java.util.ArrayList;

public class ArcadeMode implements GameMode {

    private int time;

    @Override
    public int getGameVariable() {
        return time;
    }

    @Override
    public void setGameVariable(int x) {
        time=x;
    }

    @Override
    public void intializeGameVariable() {
        time=0;
    }

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
