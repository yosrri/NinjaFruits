package wtvr;

import java.util.ArrayList;

public class Controller implements GameController {
    int time;
    int score;
    @Override
    public ArrayList<IDrops> newgame(GameMode Game) {
        return Game.CreateDrops();
    }

    @Override
    public void resetgame(int time, int score) {
      time=0;
      score=0;
    }
}
