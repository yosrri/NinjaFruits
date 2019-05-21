package GUI;
import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;

public class GuiMain extends Application {
   public static void main(String[] args)
   {
	   launch(args);
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
