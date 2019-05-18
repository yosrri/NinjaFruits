package GUI;

import javafx.scene.Cursor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ControlTheGame.ClassicMode;
import ControlTheGame.Controller;
import ControlTheGame.GameMode;
import Objects.Bomb;
import Objects.FatalBomb;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import javafx.event.ActionEvent;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClassicModeGUI {

	private AnimationTimer timer;
	private Pane root = new Pane();
	private List drop = new ArrayList();
	private List obj = new ArrayList();
	private Timeline timeline;
	private double mouseX;
	private double mouseY;
	private double speed;
	private double falling;
	private Label lblMissed;
	private Label lives;
	private Label scoreLabel;
	private Label comboLabel;
	private int score = 0;
	private int combo = 0;
	private int bestCombo = 0;
	private int missed;
	private int i;
	private int divider;
	private int lifes = 3;
	private int randomNo;
	private MediaPlayer mediaPlayer;
	private Controller controller;
	private GameMode firstMode;
	private Image knifeImg;
	private ImageView knife;
	private Alert alertMenu;
	private ButtonType save;
	private ButtonType load;
	private ButtonType exit;

	Scene scene;
	Stage stage;
	MainMenu menu;

	public ClassicModeGUI(Stage stage) {
		this.stage = stage;
	}

	// @Override
	// public void start(Stage primaryStage) throws Exception {
	public void prepareScene() {

		controller = new Controller();
		firstMode = new ClassicMode();
		lblMissed = new Label("Missed:" + String.valueOf(missed));
		lives = new Label("Lives:" + String.valueOf(lifes));
		scoreLabel = new Label("Score: " + String.valueOf(score));
		comboLabel = new Label("Combo: " + String.valueOf(combo));

		// knifeImg = new Image("knife.png");
		// knife = new ImageView(knifeImg);

		Image backgroundImg = new Image("mode1.jpg");
		ImageView background = new ImageView(backgroundImg);

		missed = 0;
		bestCombo = combo;

		speed = 1;
		falling = 500;

		root.getChildren().addAll(background);

		timeline = new Timeline(new KeyFrame(Duration.millis(falling),
				event -> {

					speed += falling / divider;
					randomNo = (int) (0 + Math.random() * 5);
					drop.add(controller.newgame(firstMode).get(randomNo)
							.getImage());
					obj.add(controller.newgame(firstMode).get(randomNo));

					root.getChildren().add(((Node) drop.get(drop.size() - 1)));
				}));
		timeline.setCycleCount(1000);
		timeline.play();
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				gameUpdate();
			}
		};
		timer.start();

		VBox vb = new VBox(scoreLabel, lives, lblMissed, comboLabel);
		vb.getChildren().addAll();

		root.getChildren().addAll(vb);

		scene = new Scene(root, 1024, 683);
//		scene.setOnKeyPressed(e -> {
//			timer.stop();
//			timeline.pause();
//			if (e.getCode().equals(KeyCode.ESCAPE)) {
//				alertMenu = new Alert(Alert.AlertType.INFORMATION);
//				alertMenu.setTitle("Pause");
//				alertMenu.setHeaderText("Your Score Is " + score
//						+ "\nYour Missed Are " + missed
//						+ "\nYour Highest Combo Is " + bestCombo);
//				 save = new ButtonType("Save");
//				alertMenu.getButtonTypes().add(save);
//			     load = new ButtonType("Load");
//			     alertMenu.getButtonTypes().add(load);
//			     exit = new ButtonType("Exit");
//			     alertMenu.getButtonTypes().add(exit);
//				alertMenu.show();
//			}
//		});
//		alertMenu.setOnHidden(e -> {
//			if(alertMenu.getButtonTypes().equals(save))
//			{
//				timer.start();
//				timeline.play();
//			}
//			if(alertMenu.getButtonTypes().equals(load))
//			{
//				timer.start();
//				timeline.play();
//			}
//			if(alertMenu.getButtonTypes().equals(exit))
//			{
//				stage.close();
//			}
//			
//		});
		// scene.setCursor(Cursor.NONE);

		scene.setOnMouseMoved(e -> {
			mouseX = e.getX();
			mouseY = e.getY();
		});

		scoreLabel.setFont(Font.font("Bold", 16));
		lives.setFont(Font.font("Bold", 16));
		lblMissed.setFont(Font.font("Bold", 16));
		comboLabel.setFont(Font.font("Bold", 16));
		scoreLabel.setStyle("-fx-text-fill:YELLOW");
		lives.setStyle("-fx-text-fill:RED");
		lblMissed.setStyle("-fx-text-fill:GREEN");
		comboLabel.setStyle("-fx-text-fill:ORANGE");
	}

	public int rand(int min, int max) {
		return (int) (Math.random() * max + min);
	}

	public void gameUpdate() {
		// knife.setFitWidth(100);
		// knife.setFitHeight(100);
		// knife.setLayoutX(mouseX-60);
		// knife.setLayoutY(mouseY-60);

		if (combo > bestCombo)
			bestCombo = combo;
		lblMissed.setText("Missed: " + String.valueOf(missed));
		lives.setText("Lifes: " + String.valueOf(lifes));
		scoreLabel.setText("Score: " + String.valueOf(score));
		comboLabel.setText("Combo: " + String.valueOf(combo));

		for (int i = 0; i < drop.size(); i++) {
			((ImageView) drop.get(i)).setLayoutY(((ImageView) drop.get(i))
					.getLayoutY()
					+ speed
					+ ((ImageView) drop.get(i)).getLayoutY() / 150);
			// if get droped into square
			if ((((ImageView) drop.get(i)).getLayoutX() < mouseX && ((ImageView) drop
					.get(i)).getLayoutX() + 100 >= mouseX)
					&& ((ImageView) drop.get(i)).getLayoutY() < mouseY
					&& ((ImageView) drop.get(i)).getLayoutY() + 100 >= mouseY) {
				root.getChildren().remove(((ImageView) drop.get(i)));
				System.out.println(obj.get(i));
				if (obj.get(i) instanceof Bomb) {
					lifes -= 1;
				}
				if (obj.get(i) instanceof FatalBomb) {
					lifes = 0;
				}

				obj.remove(i);
				drop.remove(i);
				sliceSound();
				score += 1;
				combo += 1;
				if (controller.gameEnder(lifes)) {
					lifes = 0;
					timer.stop();
					timeline.stop();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Game Over!!");
					alert.setHeaderText("GOOD LUCK NEXT TIME\n"
							+ "Your Score Is " + score + "\nYour Missed Are "
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
				if (obj.get(i) instanceof Bomb) {
					continue;
				}
				if (obj.get(i) instanceof FatalBomb) {
					continue;
				}
				drop.remove(i);
				obj.remove(i);
				missed += 1;
				lifes -= 1;
				combo = 0;
				if (controller.gameEnder(lifes)) {
					lifes = 0;
					timer.stop();
					timeline.stop();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Game Over!!");
					alert.setHeaderText("GOOD LUCK NEXT TIME\n"
							+ "Your Score Is " + score + "\nYour Missed Are "
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
		String path = "C:/Users/OMAR/Desktop/NinjaFruits-TharwatUpdates/Herra/src/Slice.mp3";
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
	}

	public Scene getScene(int divider) {
		this.divider = divider;
		return scene;
	}

	public void setMainMenu(MainMenu menu) {
		this.menu = menu;
	}
}
