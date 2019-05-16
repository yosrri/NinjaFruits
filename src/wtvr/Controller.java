package wtvr;

import java.util.ArrayList;

public class Controller implements GameController {
    private int score;
    GameMode game;

    @Override
    public int getGameVariable() {
        return game.getGameVariable();
    }

    public void changeGameVariable(int x) {
        game.setGameVariable(x);
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
        game.intializeGameVariable();
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
