package GUI;

import javafx.scene.text.Font;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ControlTheGame.ArcadeMode;
import ControlTheGame.Controller;
import ControlTheGame.GameMode;
import Objects.IDrops;
import Sounds.Theme;
import Sounds.Track1;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.scene.control.Label;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
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

public class ArcadeModeGUI {

	Stage stage;
	Scene scene;
	MainMenu menu;

	private AnimationTimer timer;
	private Timeline timeline;
	private Pane root = new Pane();
	private List drop = new ArrayList();
	private List dropsliced = new ArrayList();
	private List dropsliced2 = new ArrayList();
	private List obj = new ArrayList();
	private IDrops temp;
	private double mouseX;
	private double mouseY;
	private double speed;
	private double falling;
	private Label lblMissed;
	private Label timeLabel;
	private Label scoreLabel;
	private Label comboLabel;
	private int missed;
//	private int score;
	private int i;
//	private int combo = 0;
	private int bestCombo = 0;
	private MediaPlayer mediaPlayer;
	private Controller controller;
	private GameMode secondMode;
	private int seconds = 0;
	Theme theme;
//	Surprise surprise;
	Track1 track1;
	

	public ArcadeModeGUI(Stage stage) {
		this.stage = stage;
	}
	 public void throwObj(ImageView x) {
	    	Duration duration = Duration.millis(1000);
	    	TranslateTransition transition = new TranslateTransition(duration ,x);
	    	transition.setAutoReverse(false);
	    	transition.setByY(1200);
	    	transition.play();
	    	
	    }
	public void prepareScene() {
//		theme=theme.getInstance();
//		theme.getMediaPlayer().stop();
		controller = new Controller();
		secondMode = new ArcadeMode();
		
		comboLabel = new Label("Combo: " + String.valueOf(controller.getCombo()));
		lblMissed = new Label("Missed:");
		timeLabel = new Label("Time:" + String.valueOf(seconds) + " seconds");
		scoreLabel = new Label("Score: " + String.valueOf(controller.getScore()));

		Image backgroundImg = new Image("mode1.jpg");
		ImageView background = new ImageView(backgroundImg);

		missed = 0;
//		score = 0;

		speed = 1;
		falling = 500;
		root.getChildren().add(background);

		timeline = new Timeline(new KeyFrame(Duration.millis(falling),
				event -> {

					speed += falling / 3000;
					int randomNo = (int) (0 + Math.random() * 3);

					temp = controller.newgame(secondMode).get(randomNo);
					
					obj.add(temp);
					drop.add(temp.getImage());
					dropsliced.add(temp.getHalfImage());
					dropsliced2.add(temp.getSecHalfImage());

					root.getChildren().add(((Node) drop.get(drop.size() - 1)));
					
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
		vb.getChildren().addAll(scoreLabel, lblMissed, timeLabel,comboLabel);
		root.getChildren().addAll(vb);

		scene = new Scene(root, 1024, 683);

		scene.setOnMouseMoved(e -> {
			mouseX = e.getX();
			mouseY = e.getY();
		});
		
		
		scoreLabel.setFont(Font.font("Bold",16));
		timeLabel.setFont(Font.font("Bold",16));
		lblMissed.setFont(Font.font("Bold",16));
		comboLabel.setFont(Font.font("Bold",16));
		scoreLabel.setStyle("-fx-text-fill:YELLOW");
		timeLabel.setStyle("-fx-text-fill:RED");
		lblMissed.setStyle("-fx-text-fill:GREEN");
		comboLabel.setStyle("-fx-text-fill:ORANGE");
	}

	// seconds=0; //seconds counter
	Timer heraTimer = new Timer();
	TimerTask task = new TimerTask() {

		@Override
		public void run() {
//			  EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//		          @Override
//		          public void handle(MouseEvent e) {
//		          sliceSound();
//
//		          }
//		       };
//		       root.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			if (controller.gameEnder(seconds)) {
				task.cancel();
			} else {
				seconds++;
			}
		}
	};

	public void start() {
	
		heraTimer.scheduleAtFixedRate(task, 1000, 1000);
	}

	public int rand(int min, int max) {
		return (int) (Math.random() * max + min);
	}

	public void gameUpdate() {
	  
		theme=theme.getInstance();
//		surprise=surprise.getInstance();
		track1=track1.getInstance();
		if (controller.getCombo() > bestCombo)
			bestCombo = controller.getCombo();
		scoreLabel.setText("Score: " + String.valueOf(controller.getScore()));
		comboLabel.setText("Combo: " + String.valueOf(controller.getCombo()));
		timeLabel.setText("Time:" + String.valueOf(seconds) + " seconds");
		lblMissed.setText("Missed: " + String.valueOf(missed));

		for (int i = 0; i < drop.size(); i++) {
			((ImageView) drop.get(i)).setLayoutY(((ImageView) drop.get(i))
					.getLayoutY()
					+ speed
					+ ((ImageView) drop.get(i)).getLayoutY() / 150);
			if ((((ImageView) drop.get(i)).getLayoutX() < mouseX && ((ImageView) drop
					.get(i)).getLayoutX() + 100 >= mouseX)
					&& ((ImageView) drop.get(i)).getLayoutY() < mouseY
					&& ((ImageView) drop.get(i)).getLayoutY() + 100 >= mouseY) {
				System.out.println(obj.get(i) + "     " + obj.get(i));
				root.getChildren().remove(((ImageView) drop.get(i)));
//	            System.out.println(dropsliced.size()+"  sliced");			
//	            System.out.println(drop.size()+"  normal");			
				
	            ((ImageView) dropsliced.get(i)).setLayoutX(((ImageView) drop.get(i)).getLayoutX());
				((ImageView) dropsliced.get(i)).setLayoutY(((ImageView) drop.get(i)).getLayoutY());
				 
				((ImageView) dropsliced2.get(i)).setLayoutX(((ImageView) drop.get(i)).getLayoutX()+50);
					((ImageView) dropsliced2.get(i)).setLayoutY(((ImageView) drop.get(i)).getLayoutY()+30);
					
				
				root.getChildren().add((ImageView)dropsliced.get(i));
				root.getChildren().add((ImageView)dropsliced2.get(i));
				throwObj((ImageView)dropsliced.get(i));
				throwObj((ImageView)dropsliced2.get(i));
//				score += 1;
				controller.setScore(controller.getScore()+1);
//				combo+=1;
				controller.setCombo(controller.getCombo()+1);
//				((IDrops)drop.get(i)).setSlice(true);
				drop.remove(i);
				obj.remove(i);
				dropsliced.remove(i);
				dropsliced2.remove(i);
//				slice=slice.getInstance();
//				slice.getMediaPlayer().play();
				sliceSound();
				scoreLabel.setText("Score: " + String.valueOf(controller.getScore()));
				if (controller.gameEnder(seconds)) {
					theme.getMediaPlayer().stop();
//					surprise.getMediaPlayer().play();
					track1.getMediaPlayer().play();
					task.cancel();
					timer.stop();
					timeline.stop();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Game Over!!");
					alert.setHeaderText("GOOD LUCK NEXT TIME\n"
							+ "Your Score Is " + controller.getScore() + "\nYour Missed Are "
							+ missed + "\nYour Highest Combo Is " + bestCombo);
					alert.show();
					alert.setOnHidden(e -> {
						stage.close();
					});
				}
			}
			// if missed remove
			else if (((ImageView) drop.get(i)).getLayoutY() >= 1024) {
				root.getChildren().remove(((ImageView) drop.get(i)));
				drop.remove(i);
				obj.remove(i);
				dropsliced.remove(i);
				dropsliced2.remove(i);

				missed += 1;
//				combo=0;
				controller.setCombo(0);
				
				if (controller.gameEnder(seconds)) {
					theme.getMediaPlayer().stop();
//					surprise.getMediaPlayer().play();
					track1.getMediaPlayer().play();
					task.cancel();
					timer.stop();
					timeline.stop();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Game Over!!");
					alert.setHeaderText("GOOD LUCK NEXT TIME\n"
							+ "Your Score Is " + controller.getScore() + "\nYour Missed Are "
							+ missed + "\nYour Highest Combo Is " + bestCombo);
					alert.show();					
					alert.setOnHidden(e -> {
					stage.close();
					});
				}
			}
		
		}
	}
	public void sliceSound() {
		String path = "/Users/ahmedtharwatwagdy/Documents/java/workspace/Fruit Ninja/src/Slice.mp3";
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
	}

	public Scene getScene() {
		return scene;
	}

	public void setMainMenu(MainMenu menu) {
		this.menu = menu;
	}
}
