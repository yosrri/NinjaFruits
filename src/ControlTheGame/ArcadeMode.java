package ControlTheGame;

import java.util.ArrayList;

import Objects.FruitFactory;
import Objects.IDrops;

public class ArcadeMode implements GameMode {
    private int score=0;
    private int time;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGameVariable() {
        return time;
    }

    public void setGameVariable(int x) {
        time=x;
    }

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
        if(time==10)
            return true;
        else return false;
    }
}