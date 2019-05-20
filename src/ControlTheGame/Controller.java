package ControlTheGame;

import java.util.ArrayList;

import Objects.IDrops;

public class Controller implements GameController {
    private int score=0;
    private int combo=0;
    private int missed=0;
    public int getMissed() {
		return missed;
	}

	public void setMissed(int missed) {
		this.missed = missed;
	}

	GameMode game;
    
    public int getCombo() {
		return combo;
	}

	public void setCombo(int combo) {
		this.combo = combo;
	}


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

	@Override
	public void setBoolean(Boolean x, IDrops drop) {
		drop.setSlice(x);
		
	}

	@Override
	public Boolean getBoolean(IDrops drop) {
		// TODO Auto-generated method stub
		return drop.isSlice();
	}

	@Override
	public void setY(int y, IDrops drop) {
		// TODO Auto-generated method stub
		drop.setY(y);
		
	}

	@Override
	public void setX(int x, IDrops drop) {
		// TODO Auto-generated method stub
		drop.setX(x);
		
	}
}
