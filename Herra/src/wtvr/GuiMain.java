package wtvr;
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
		ClassicModeGUI classicGUI = new ClassicModeGUI(primaryStage);
		ArcadeModeGUI arcadeGUI = new ArcadeModeGUI(primaryStage);
        primaryStage.setTitle("Fruit Ninja");
        mainmenu.prepareScene();
        classicGUI.prepareScene();
        arcadeGUI.prepareScene();
        classicGUI.setMainMenu(mainmenu);
        arcadeGUI.setMainMenu(mainmenu);
        mainmenu.setClassicMode(classicGUI);
        mainmenu.setArcadeMode(arcadeGUI);
        primaryStage.setScene(mainmenu.getScene());
        primaryStage.show();
	}

}
