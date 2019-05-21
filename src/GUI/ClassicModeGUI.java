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
import Objects.IDrops;
import Sounds.Theme;
import Sounds.Track1;
import Sounds.Track2;
import Sounds.Track3;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import javafx.event.ActionEvent;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
import javafx.scene.control.*;
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
	private List dropsliced = new ArrayList();
	private List dropsliced2 = new ArrayList();
	private Timeline timeline;
	private double mouseX;
	private double mouseY;
	private double speed;
	private double falling;
	private Label lblMissed;
	private Label lives;
	private Label scoreLabel;
	private Label comboLabel;
	// private int score = 0;
	// private int combo = 0;
	private int bestCombo = 0;
	// private int missed;
	private int i;
	private IDrops temp;
	private int divider;
	// private int lifes = 3;
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
	private MediaPlayer mp;
	private Optional<ButtonType> result;

	Scene scene;
	Stage stage;
	MainMenu menu;
	Theme theme;
	Track2 track2;
	Track3 track3;

	public ClassicModeGUI(Stage stage) {
		this.stage = stage;
	}

	public void throwObj(ImageView x) {
		Duration duration = Duration.millis(1000);
		TranslateTransition transition = new TranslateTransition(duration, x);
		transition.setAutoReverse(false);
		transition.setByY(1200);
		// transition.setDelay(Duration.millis(2000));
		transition.play();
	}

	public void prepareScene() {

		controller = new Controller();
		firstMode = new ClassicMode();
		controller.newgame(firstMode);
		lblMissed = new Label("Missed:"
				+ String.valueOf(controller.getMissed()));
		lives = new Label("Lives:"
				+ String.valueOf(controller.getGameVariable()));
		scoreLabel = new Label("Score: "
				+ String.valueOf(controller.getScore()));
		comboLabel = new Label("Combo: "
				+ String.valueOf(controller.getCombo()));
		// knifeImg = new Image("knife.png");
		// knife = new ImageView(knifeImg);

		Image backgroundImg = new Image("mode1.jpg");
		ImageView background = new ImageView(backgroundImg);

		// missed = 0;
		bestCombo = controller.getCombo();

		speed = 1;
		falling = 500;

		root.getChildren().addAll(background);

		timeline = new Timeline(new KeyFrame(Duration.millis(falling),
				event -> {

					speed += falling / divider;
					randomNo = (int) (0 + Math.random() * 5);

					temp = controller.newgame(firstMode).get(randomNo);

					obj.add(temp);
					drop.add(temp.getImage());
					dropsliced.add(temp.getHalfImage());
					dropsliced2.add(temp.getSecHalfImage());
					root.getChildren().add(((Node) drop.get(drop.size() - 1)));
					if (temp.isSlice())
						controller.setMissed(controller.getMissed() + 1);

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
		root.getChildren().addAll(vb);

		scene = new Scene(root, 1024, 683);
		scene.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ESCAPE)) {
				timer.stop();
				timeline.pause();
				alertMenu = new Alert(Alert.AlertType.INFORMATION);
				alertMenu.setTitle("Pause");
				alertMenu.setHeaderText("Your Score Is "
						+ controller.getScore() + "\nYour Remaining Lifes Are "
						+ controller.getGameVariable() + "\nYour Missed Are "
						+ controller.getMissed() + "\nYour Highest Combo Is "
						+ bestCombo);
				save = new ButtonType("Save");
				alertMenu.getButtonTypes().add(save);
				load = new ButtonType("Load");
				alertMenu.getButtonTypes().add(load);
				exit = new ButtonType("Exit");
				alertMenu.getButtonTypes().add(exit);
				result = alertMenu.showAndWait();
				if (result.get() == save) {
					controller.saveGame();
					timer.start();
					timeline.play();

				}
				if (result.get() == load) {
					controller.loadGame();
					timer.start();
					timeline.play();
				}
				if (result.get() == ButtonType.OK) {
					timer.start();
					timeline.play();
				}
				if (result.get() == exit) {
					stage.close();
				}
			}
		});
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

		theme = theme.getInstance();
		track2 = track2.getInstance();
		track3 = Track3.getInstance();
		if (controller.getCombo() > bestCombo)
			bestCombo = controller.getCombo();
		lblMissed.setText("Missed: " + String.valueOf(controller.getMissed()));
		lives.setText("Lifes: " + String.valueOf(controller.getGameVariable()));
		scoreLabel.setText("Score: " + String.valueOf(controller.getScore()));
		comboLabel.setText("Combo: " + String.valueOf(controller.getCombo()));
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
					controller
							.changeGameVariable(controller.getGameVariable() - 1);
				} else if (obj.get(i) instanceof FatalBomb) {
					track2.getMediaPlayer().play();
					track3.getMediaPlayer().setMute(true);
					controller.changeGameVariable(0);
				} else {
					((ImageView) dropsliced.get(i))
							.setLayoutX(((ImageView) drop.get(i)).getLayoutX());
					((ImageView) dropsliced.get(i))
							.setLayoutY(((ImageView) drop.get(i)).getLayoutY());

					((ImageView) dropsliced2.get(i))
							.setLayoutX(((ImageView) drop.get(i)).getLayoutX() + 50);
					((ImageView) dropsliced2.get(i))
							.setLayoutY(((ImageView) drop.get(i)).getLayoutY() + 30);
					((IDrops) obj.get(i)).setSlice(true);

					root.getChildren().add((ImageView) dropsliced.get(i));
					root.getChildren().add((ImageView) dropsliced2.get(i));
					throwObj((ImageView) dropsliced.get(i));
					throwObj((ImageView) dropsliced2.get(i));
				}
				obj.remove(i);
				drop.remove(i);
				dropsliced.remove(i);
				dropsliced2.remove(i);
				sliceSound();
				controller.setScore(controller.getScore() + 1);
				controller.setCombo(controller.getCombo() + 1);
				if (controller.gameEnder(controller.getGameVariable())) {
					theme.getMediaPlayer().stop();
					track3.getMediaPlayer().play();
					controller.changeGameVariable(0);
					timer.stop();
					timeline.stop();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Game Over!!");
					alert.setHeaderText("GOOD LUCK NEXT TIME\n"
							+ "Your Score Is " + controller.getScore()
							+ "\nYour Missed Are " + controller.getMissed()
							+ "\nYour Highest Combo Is " + bestCombo);
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
				dropsliced.remove(i);
				dropsliced2.remove(i);
				controller.setMissed(controller.getMissed() + 1);
				// missed += 1;
				// lifes -= 1;
				controller.changeGameVariable(controller.getGameVariable() - 1);
				controller.setCombo(0);
				// combo = 0;
				if (controller.gameEnder(controller.getGameVariable())) {
					theme.getMediaPlayer().stop();
					// lifes = 0;
					controller.changeGameVariable(0);
					timer.stop();
					timeline.stop();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Game Over!!");
					alert.setHeaderText("GOOD LUCK NEXT TIME\n"
							+ "Your Score Is " + controller.getScore()
							+ "\nYour Missed Are " + controller.getMissed()
							+ "\nYour Highest Combo Is " + bestCombo);
					alert.show();
					alert.setOnHidden(e -> {
						stage.close();
					});
				}
			}
		}

	}

	public void sliceSound() {
		String path = "C:/Users/OMAR/Desktop/Images/Slice.mp3";
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setStartTime(Duration.ONE);
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
