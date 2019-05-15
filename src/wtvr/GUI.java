package wtvr;

import java.util.ArrayList;
import java.util.List;



import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.animation.Animation.Status;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;


public class GUI extends Application{
	List drop = new ArrayList();
    int missed=0;
    int score=0;
    int life=3;
    Label scoreLabel;
    Label lifeLabel;
    Label missedLabel;
    MediaPlayer mediaPlayer;
    Controller controller;
    GameMode firstMode;
	public ImageView fruitDrops() {
		controller = new Controller();
		firstMode=new ClassicMode();
		ArrayList<IDrops> drops = new ArrayList<>();
		drops=controller.newgame(firstMode);
		IDrops anon= drops.get((int)(0+Math.random()*5));
		ImageView dropImg = new ImageView(SwingFXUtils.toFXImage(anon.getImage(),null));
		
		dropImg.setFitHeight(70);
		dropImg.setFitWidth(70);
		dropImg.setX(50+Math.random()*750);
		dropImg.setY(-100);
		int timelab = 10000;
		Duration duration = Duration.millis(timelab);
		timelab-=1000;
    	TranslateTransition transition = new TranslateTransition(duration ,dropImg);
    	TranslateTransition x = new TranslateTransition(duration ,dropImg);
    	transition.setDelay(Duration.millis(Math.random()*3000));
    	transition.setByY(750);
    	transition.setAutoReverse(false);
    	transition.setOnFinished(e->{
        	//missed++;
        	//life--;
    		if(dropImg.isVisible())
            {
           	missed++;
            }
        	missedLabel.setText("Missed: "+toString().valueOf(missed));
        	lifeLabel.setText("lifes: "+toString().valueOf(life));
        	});
        	transition.play();
        	EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
                @Override 
                public void handle(MouseEvent e) { 
                	dropImg.setTranslateY(700); 	
                   score++;
                 //  missed--; 
                   life++;
                   System.out.println(score);
                   scoreLabel.setText("Score: "+toString().valueOf(score));
                   dropImg.setVisible(false);
                } 
             };  
             dropImg.addEventFilter(MouseEvent.MOUSE_ENTERED, eventHandler); 
             dropImg.setOnMouseMoved(e->
             { sliceSound();            	 
             });
             
             if(firstMode.endingCondition(missed))
             {
            	 	//transition.pause();
            	 	transition.stop();
            	 	Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Game Over!!");
					alert.setHeaderText("GOOD LUCK NEXT TIME");
					alert.showAndWait();
             }
	return dropImg;
}
	public ImageView bombDrops() {
		Bomb x = new Bomb();
		ImageView bombImg = new ImageView(SwingFXUtils.toFXImage(x.getImage(), null));
	
		bombImg.setFitHeight(70);
		bombImg.setFitWidth(70);
		bombImg.setX(50+Math.random()*750);
		bombImg.setY(-100);
				
		Duration duration = Duration.millis(5000);
    	TranslateTransition transition = new TranslateTransition(duration ,bombImg);
    	transition.setDelay(Duration.millis(Math.random()*3000));
    	transition.setByY(800);
    	transition.setAutoReverse(false);
    	transition.setOnFinished(e->{	
        	missedLabel.setText("Missed: "+toString().valueOf(missed));
        	lifeLabel.setText("lifes: "+toString().valueOf(life));
        	});
        	transition.play();
        	EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
                @Override 
                public void handle(MouseEvent e) { 
                	bombImg.setTranslateY(700);
                   scoreLabel.setText("Score: "+toString().valueOf(score));
                   bombImg.setVisible(false);
                  // if(imgNo==0)
                	   life--;
                   //else
                	 //  life=0;
                } 
             };  
             bombImg.addEventFilter(MouseEvent.MOUSE_ENTERED, eventHandler); 
	return bombImg;
}
	public void start(Stage primaryStage) {
		  
		ArrayList<String> x = new ArrayList<>();
		//

		scoreLabel= new Label("Score: "+"0");
		missedLabel= new Label("Missed: "+"0");
		x.add("apple");
		x.add("banana");
		x.add("watermelon");
		x.add("bomb");
		x.add("fatalbomb");
		lifeLabel= new Label("Lifes: "+"3");
		for(int i=0;i<10;i++)
			drop.add(fruitDrops());
		for(int i=0;i<2;i++)
			drop.add(bombDrops());
		Pane pane = new Pane();
		pane .getChildren().addAll(drop);
		VBox v1= new VBox();
		v1.getChildren().addAll(scoreLabel,lifeLabel,missedLabel,pane);

      
		Scene scene = new Scene(v1);
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(700);
		primaryStage.setMinWidth(750);
		primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);
		}
		public void sliceSound()
		{
			String path = "C:\\Users\\OMAR\\Desktop\\Images\\Slice.mp3";
			Media media = new Media(new File(path).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setAutoPlay(true);
		}
	}

