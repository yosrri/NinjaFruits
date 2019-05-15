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
import javafx.scene.control.Label;
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

	/*public ImageView fruitDrops(ArrayList<String>fruits) {
		FruitFactory factory = new FruitFactory();
		IDrops anon = factory.getFruit(fruits.get((int)(0+Math.random()*3)));
		ImageView fruitImg = new ImageView(SwingFXUtils.toFXImage(anon.getImage(),null));
	
		fruitImg.setFitHeight(70);
		fruitImg.setFitWidth(70);
		fruitImg.setX(50+Math.random()*750);
		fruitImg.setY(-100);
		int timelab = 10000;
		Duration duration = Duration.millis(timelab);
		timelab-=1000;
    	TranslateTransition transition = new TranslateTransition(duration ,fruitImg);
    	TranslateTransition x = new TranslateTransition(duration ,fruitImg);
    	transition.setDelay(Duration.millis(Math.random()*3000));
    	transition.setByY(800);
    	transition.setAutoReverse(false);
    	transition.setOnFinished(e->{
        	missed++;
        	life--;
        	missedLabel.setText("Missed: "+toString().valueOf(missed));
        	lifeLabel.setText("lifes: "+toString().valueOf(life));
        	});
        	transition.play();
        	EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
                @Override 
                public void handle(MouseEvent e) { 
                	fruitImg.setTranslateY(700); 	
                   score++;
                   missed--; 
                   life++;
                   System.out.println(score);
                   scoreLabel.setText("Score: "+toString().valueOf(score));
                   fruitImg.setVisible(false);
                  
                } 
             };  
             fruitImg.addEventFilter(MouseEvent.MOUSE_ENTERED, eventHandler); 
             fruitImg.setOnMouseMoved(e->
             { sliceSound();            	 
             });
	return fruitImg;
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
			drop.add(fruitDrops(x));
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
			String path = "E:\\Fruitnin\\src\\Slice.mp3";
			Media media = new Media(new File(path).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setAutoPlay(true);
		}*/
	public void start(Stage primaryStage) {}
}

