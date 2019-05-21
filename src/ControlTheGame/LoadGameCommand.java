package ControlTheGame;


public class LoadGameCommand implements  Command {
    LoadGame Load;
    @Override
    public void excute() {
        Load.loadProgress();
    }
    public LoadGameCommand(LoadGame Load){
        this.Load=Load;
    }
}
