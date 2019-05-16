package wtvr;
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
import javafx.stage.Stage;
public class MainMenu {
Stage stage;
Scene scene;
ClassicModeGUI classicGUI ;
ArcadeModeGUI arcadeGUI;
public MainMenu(Stage stage)
{
	this.stage=stage;
}
public void prepareScene()
{
	
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
	
	//button.setFitHeight(150);
	//button.setFitWidth(300);
	
	//Button classic = new Button("Classic Mode");
	//Button arcade = new Button("Arcade Mode");
	//newgame.setGraphic(button);
	
	HBox hb = new HBox(100);
	hb.setPadding(new Insets(300, 100, 100, 100));
	hb.getChildren().addAll(classic,arcade);
	
	root.getChildren().addAll(background,hb);
	scene = new Scene(root,1080,720);
	
	classic.setOnMouseClicked(e->
	{
		stage.setScene(classicGUI.getScene());
	});
	
	arcade.setOnMouseClicked(e->
	{
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
}
