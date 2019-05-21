package wtvr;

import ControlTheGame.LoadGame;
import ControlTheGame.SaveGame;

import java.util.ArrayList;

public class Controller implements GameController {
    private int score;
    GameMode game;
    CommandControl controller;
    @Override
    public int getGameVariable() {
        return game.getGameVariable();
    }

    @Override
    public void saveGame() {
        controller.setCommand(new SaveGameCommand(new SaveGame(score,game.getGameVariable())));
        controller.buttonWasPressed();
    }

    @Override
    public void loadGame() {
      controller.setCommand(new LoadGameCommand(new LoadGame(score,getGameVariable())));
      controller.buttonWasPressed();
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
