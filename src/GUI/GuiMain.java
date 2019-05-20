package GUI;
import java.io.File;

import ControlTheGame.LoadGame;
import ControlTheGame.SaveGame;
import javafx.application.Application;
import javafx.stage.Stage;

public class GuiMain extends Application {
	static int x;
	static int y;
   public static void main(String[] args)
   {
//	   launch(args);
	   SaveGame save = new SaveGame(5,6);
	   save.saveProgress();
	   LoadGame load= new LoadGame(x,y);
	   load.loadProgress();
	   System.out.println(x+"   "+y);
	   
	   
   }
	@Override
	public void start(Stage primaryStage) throws Exception {
		MainMenu mainmenu = new MainMenu(primaryStage);
		Difficulty diff = new Difficulty(primaryStage);
		ClassicModeGUI classicGUI = new ClassicModeGUI(primaryStage);
		ArcadeModeGUI arcadeGUI = new ArcadeModeGUI(primaryStage);
        primaryStage.setTitle("Fruit Ninja");
        mainmenu.prepareScene();
        diff.prepareScene();
       // classicGUI.prepareScene();
       // arcadeGUI.prepareScene();
        diff.setMainMenu(mainmenu);
        arcadeGUI.setMainMenu(mainmenu);
        diff.setClassicMode(classicGUI);
       // classicGUI.setMainMenu(mainmenu);
       
       
        mainmenu.setDifficulty(diff);
       // mainmenu.setClassicMode(classicGUI);
        mainmenu.setArcadeMode(arcadeGUI);
        primaryStage.setScene(mainmenu.getScene());
        primaryStage.show();
	}
	

}
