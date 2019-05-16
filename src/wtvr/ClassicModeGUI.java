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
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class ClassicModeGUI {

    AnimationTimer timer;
    Pane root = new Pane();
    List drop = new ArrayList();
    Timeline timeline;
    double mouseX;
    double mouseY;
    double speed;
    double falling;
    Label lblMissed;
    Label lives;
    Label scoreLabel;
    Label comboLabel;
    int score=0;
    int combo=0;
    int missed;
    int i ;
    int lifes=3;
    int randomNo;
    MediaPlayer mediaPlayer;
    Controller controller;
    GameMode firstMode;
    
    Scene scene ;
    Stage stage;
    MainMenu menu;
    
    public ClassicModeGUI(Stage stage)
    {
    	this.stage=stage;
    }
    
   

  //  @Override
   // public void start(Stage primaryStage) throws Exception {
    public void prepareScene(){
    	
        controller = new Controller();
        firstMode = new ClassicMode();
        lblMissed = new Label("Missed:"+String.valueOf(missed));
        lives=new Label("Lives:"+String.valueOf(lifes));
        scoreLabel = new Label("Score: "+String.valueOf(score));
        comboLabel = new Label("Combo: "+String.valueOf(combo));
        
        missed = 0;

        speed = 1;
        falling = 500;
        
        

         timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {

            speed += falling / 3000;
             randomNo=(int)(0 + Math.random() * 5);
            drop.add(controller.newgame(firstMode).get(randomNo).getImage());
     
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
        
        VBox vb = new VBox(scoreLabel,lives,lblMissed,comboLabel);
        vb.getChildren().addAll();

        root.getChildren().addAll(vb);

         scene = new Scene(root, 750, 700);

        scene.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY=e.getY();
        });

    }

    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
    public void gameUpdate(){
    	 lblMissed.setText("Missed: " + String.valueOf(missed));
         lives.setText("Lifes: " + String.valueOf(lifes));
         scoreLabel.setText("Score: "+String.valueOf(score));
         comboLabel.setText("Combo: "+String.valueOf(combo));
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
                score+=1;
                combo+=1;
            }

            //if missed remove
            else if(((ImageView) drop.get(i)).getLayoutY() >= 750) {
                root.getChildren().remove(((ImageView) drop.get(i)));
                drop.remove(i);
                missed += 1;
                lifes-=1;
                
                combo=0;
               
                if(controller.gameEnder(lifes))
            	{
                	lifes=0;
            		timer.stop();
            		timeline.stop();
//            		Alert alert = new Alert(AlertType.WARNING);
//    				alert.setTitle("Game Over!!");
//    				alert.setHeaderText("GOOD LUCK NEXT TIME");
//    				alert.showAndWait();
            	}
            }
        }
    }
    public void sliceSound() {
        String path = "C:\\Users\\OMAR\\Desktop\\NinjaFruits-ZawawyUpdates\\src\\Slice.mp3";
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
