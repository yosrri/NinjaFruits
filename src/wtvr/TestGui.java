package wtvr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;





import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class TestGui extends Application {

    AnimationTimer timer;
    Pane root = new Pane();
    List drop = new ArrayList();
    double mouseX;
    double mouseY;
    double speed;
    double falling;
    Label lblMissed;
    int missed;
    int i ;
    MediaPlayer mediaPlayer;
    Controller controller;
    GameMode firstMode;
    public static void main(String[] args) {
        Application.launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        firstMode = new ClassicMode();
        lblMissed = new Label("Missed: 0");
        lblMissed.setLayoutX(10);
        lblMissed.setLayoutY(10);
        missed = 0;

        speed = 1;
        falling = 500;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {

            speed += falling / 3000;
            drop.add(controller.newgame(firstMode).get((int)(0 + Math.random() * 5)).getImage());
            root.getChildren().add(((Node)drop.get(drop.size() -1)));
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

        root.getChildren().addAll(lblMissed);

        Scene scene = new Scene(root, 750, 700);

        scene.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY=e.getY();
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
    public void gameUpdate(){

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
                drop.remove(i);
                sliceSound();
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
}
