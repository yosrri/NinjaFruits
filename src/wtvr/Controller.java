package wtvr;

import java.util.ArrayList;

public class Controller implements GameController {
    private  int time;
    private int score;
    GameMode game;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public ArrayList<IDrops> newgame(GameMode game) {
        this.game=game;
        return game.createDrops();
    }

    @Override
    public void resetgame() {
      time=0;
      score=0;
    }

    @Override
    public boolean gameEnder(int x) {
        return game.endingCondition(x);
    }

    @Override
    public void slice(IDrops obj) {
        obj.setSlice(true);
    }
}
