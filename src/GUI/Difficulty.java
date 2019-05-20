package GUI;
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
public class Difficulty {
Stage stage;
Scene scene;
MainMenu menu;

ClassicModeGUI classicGUI ;
ArcadeModeGUI arcadeGUI;

public Difficulty(Stage stage)
{
	this.stage=stage;
}
public void prepareScene()
{
	Group root = new Group();
	
	Image backgroundImg = new Image("background.jpeg");
	ImageView background = new ImageView(backgroundImg);
	
	Image easyImg = new Image("easy.png.png");
	ImageView easy = new ImageView(easyImg);
	
	Image normalImg = new Image("normal.png.png");
	ImageView normal = new ImageView(normalImg);
	
	Image ninjaImg = new Image("hard.png.png");
	ImageView ninja = new ImageView(ninjaImg);
	
	easy.setFitWidth(350);
	easy.setFitHeight(100);
	
	normal.setFitWidth(350);
	normal.setFitHeight(100);
	
	ninja.setFitWidth(350);
	ninja.setFitHeight(100);
	
	background.setFitWidth(1080);
	background.setFitHeight(720);

	HBox hb = new HBox();
	hb.setPadding(new Insets(300, 0, 100, 0));
	hb.getChildren().addAll(easy,normal,ninja);
	
	root.getChildren().addAll(background,hb);
	scene = new Scene(root,1080,720);
	
	easy.setOnMouseClicked(e->
	{
		classicGUI.prepareScene();
		stage.setScene(classicGUI.getScene(15000));
	});
	
	normal.setOnMouseClicked(e->
	{
		classicGUI.prepareScene();
		stage.setScene(classicGUI.getScene(5000));
	});
	ninja.setOnMouseClicked(e->
	{
		classicGUI.prepareScene();
		stage.setScene(classicGUI.getScene(1500));
	});
	
}
public Scene getScene()
{
	return this.scene;
}
public void setClassicMode(ClassicModeGUI classicGUI)
{
	this.classicGUI=classicGUI;
}
public void setMainMenu(MainMenu menu) {
	this.menu = menu;
}

}
