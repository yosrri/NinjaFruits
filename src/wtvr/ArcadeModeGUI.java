package wtvr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;





import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.scene.control.Label;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class ArcadeModeGUI{

	Stage stage;
	Scene scene;
	MainMenu menu;
	
    AnimationTimer timer;
    Timeline timeline;
    Pane root = new Pane();
    List drop = new ArrayList();
    double mouseX;
    double mouseY;
    double speed;
    double falling;
    Label lblMissed;
    Label timeLabel;
    Label scoreLabel;
    int missed;
    int score;
    int i ;
    MediaPlayer mediaPlayer;
    Controller controller;
    GameMode secondMode;

    public ArcadeModeGUI(Stage stage)
    {
    	this.stage=stage;
    }
    public void prepareScene(){
        controller = new Controller();
        secondMode = new ArcadeMode();
        lblMissed = new Label("Missed: 0"); 
        timeLabel = new Label("Time:"+String.valueOf(seconds)+" seconds");
        scoreLabel= new Label("Score: "+String.valueOf(score));
  
        missed = 0;
        score =0;
        
        speed = 1;
        falling = 500;
        
 

         timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {

            speed += falling / 3000;
            int randomNo=(int)(0 + Math.random() * 3);
            drop.add(controller.newgame(secondMode).get(randomNo).getImage());
     
            root.getChildren().add(((Node)drop.get(drop.size() -1)));
        }));

        timeline.setCycleCount(1000);
        timeline.play();
        start();
        timer = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                gameUpdate();
            }

        };
        timer.start();

        VBox vb = new VBox();
        vb.getChildren().addAll(scoreLabel,lblMissed,timeLabel);
        root.getChildren().addAll(vb);

         scene = new Scene(root, 750, 700);

        scene.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY=e.getY();
        });
    }
    int seconds=0;		//seconds counter
    Timer heraTimer= new Timer();
    TimerTask task = new TimerTask()
    {

        @Override
        public void run() {
        	if(controller.gameEnder(seconds))
        	{
        		task.cancel();
        		timer.stop();
        		timeline.stop();
//        		Alert alert = new Alert(AlertType.WARNING);
//				alert.setTitle("Game Over!!");
//				alert.setHeaderText("GOOD LUCK NEXT TIME");
//				alert.showAndWait();
        	}
        	else
        	{
        		 seconds++;
               //  System.out.println(seconds);
        	}
        }
    };
    public void start()
    {
    	heraTimer.scheduleAtFixedRate(task, 1000, 1000);
    	 timeLabel.setText("Time:"+String.valueOf(seconds)+" seconds");
    }
    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
    public void gameUpdate(){
    timeLabel.setText("Time:"+String.valueOf(seconds)+" seconds");
    
//        cont.setLayoutX(mouseX);
//        cont.setLayoutY(mouseY);
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
//            	 root.getChildren().remove(((Circle) drop.get(i)));
//               drop.remove(i);
//
//            }
//         };
//        for( i = 0; i < drop.size(); i++) {
//        	((Circle) drop.get(i)).setLayoutY(((Circle) drop.get(i)).getLayoutY() + speed + ((Circle) drop.get(i)).getLayoutY() / 150 );
//
//        	((Circle)drop.get(i)).addEventFilter(MouseEvent.MOUSE_ENTERED,eventHandler);
//        }
    	
        for(int i = 0; i < drop.size(); i++) {
            ((ImageView) drop.get(i)).setLayoutY(((ImageView) drop.get(i)).getLayoutY() + speed + ((ImageView) drop.get(i)).getLayoutY() / 150 );
            //if get droped into square
            if((((ImageView) drop.get(i)).getLayoutX() < mouseX && ((ImageView) drop.get(i)).getLayoutX()+100 >= mouseX) &&
                    ((ImageView) drop.get(i)).getLayoutY() < mouseY&&((ImageView) drop.get(i)).getLayoutY()+100>=mouseY ) {
                root.getChildren().remove(((ImageView) drop.get(i)));
                score+=1;
                drop.remove(i);
                sliceSound();
                scoreLabel.setText("Score: "+String.valueOf(score));
            }
            //if missed remove
            else if(((ImageView) drop.get(i)).getLayoutY() >= 750) {
                root.getChildren().remove(((ImageView) drop.get(i)));
                drop.remove(i);
                missed += 1;
                lblMissed.setText("Missed: " + String.valueOf(missed));
            }
        }
    }
    public void sliceSound() {
        String path = "E:\\Fruitnin\\src\\Slice.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }
    public Scene getScene()
    {
    	return scene;
    }
    public void setMainMenu(MainMenu menu)
    {
    	this.menu=menu;
    }
}
