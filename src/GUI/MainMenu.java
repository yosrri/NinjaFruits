package GUI;
import java.io.File;

import Sounds.Theme;
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
public class MainMenu {
Stage stage;
Scene scene;
ClassicModeGUI classicGUI ;
ArcadeModeGUI arcadeGUI;
Difficulty diff;
MediaPlayer mediaPlayer;
Theme theme;

public MainMenu(Stage stage)
{
	this.stage=stage;
}
public void prepareScene()
{
	theme = theme.getInstance();
	theme.getMediaPlayer().play();
	
//	themeSound();
	
	Group root = new Group();
	
	Image backgroundImg = new Image("background.jpeg");
	ImageView background = new ImageView(backgroundImg);
	
	Image arcadeImg = new Image("arcade.jpeg.png");
	ImageView arcade = new ImageView(arcadeImg);
	
	Image classicImg = new Image("classic.jpeg.png");
	ImageView classic = new ImageView(classicImg);
	
	arcade.setFitWidth(400);
	arcade.setFitHeight(150);
	
	classic.setFitWidth(400);
	classic.setFitHeight(150);
	
	background.setFitWidth(1080);
	background.setFitHeight(720);

	HBox hb = new HBox(100);
	hb.setPadding(new Insets(300, 100, 100, 100));
	hb.getChildren().addAll(classic,arcade);
	
	root.getChildren().addAll(background,hb);
	scene = new Scene(root,1080,720);
	
	classic.setOnMouseClicked(e->
	{
		//classicGUI.prepareScene();
		//stage.setScene(classicGUI.getScene());
		//
		diff.prepareScene();
		stage.setScene(diff.getScene());
		
		
	});
	
	arcade.setOnMouseClicked(e->
	{
		arcadeGUI.prepareScene();
		stage.setScene(arcadeGUI.getScene());
	});
	
}
public Scene getScene()
{
	return this.scene;
}
public void setArcadeMode(ArcadeModeGUI arcadeGUI)
{
	this.arcadeGUI=arcadeGUI;
}
public void setClassicMode(ClassicModeGUI classicGUI)
{
	this.classicGUI=classicGUI;
}
public void setDifficulty(Difficulty diff)
{
	this.diff=diff;
}

//public MediaPlayer themeSound() {
//	String path = "/Users/ahmedtharwatwagdy/Documents/java/workspace/Fruit Ninja/src/theme.mp3";
//	Media media = new Media(new File(path).toURI().toString());
//	mediaPlayer = new MediaPlayer(media);
////	mediaPlayer.setAutoPlay(true);
//	return mediaPlayer;
//}
}
