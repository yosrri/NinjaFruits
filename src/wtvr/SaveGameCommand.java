package wtvr;

import ControlTheGame.SaveGame;

public class SaveGameCommand implements Command {
    SaveGame save;
    @Override
    public void excute() {
       save.saveProgress();
    }
    public SaveGameCommand(SaveGame save){
       this.save=save;
    }
}
