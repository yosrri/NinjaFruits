package wtvr;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	//Image buttonImg = new Image("test.jpg");
	//ImageView button = new ImageView(buttonImg);
	
	background.setFitWidth(1080);
	background.setFitHeight(720);
	
	//button.setFitHeight(150);
	//button.setFitWidth(300);
	
	Button classic = new Button("Classic Mode");
	Button arcade = new Button("Arcade Mode");
	//newgame.setGraphic(button);
	
	VBox vb = new VBox(100);
	vb.setPadding(new Insets(200, 100, 500, 500));
	vb.getChildren().addAll(classic,arcade);
	
	root.getChildren().addAll(background,vb);
	scene = new Scene(root,1080,720);
	
	classic.setOnAction(e->
	{
		stage.setScene(classicGUI.getScene());
	});
	
	arcade.setOnAction(e->
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
