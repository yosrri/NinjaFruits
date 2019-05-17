package wtvr;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.paint.Color;
public class AlertBox {
 public static void display(String title,String message)  {
	 Stage window= new Stage();
	 window.initModality(Modality.APPLICATION_MODAL);
	 window.setTitle(title);
	 window.setWidth(250);
	 window.setHeight(100);
	 Label label= new Label(message);
	 //label.setText(message);
     label.setTextFill(Color.rgb(210, 39, 30));

	 Button button= new Button("ok");
	 button.setOnAction(e->window.close());
	 button.setOnKeyPressed(e->{
		 switch(e.getCode()) {
		 case ENTER:
		 window.close();
		 }
	 });
	 button.setStyle("-fx-border-color:red");
	 VBox layout= new VBox();
	 layout.getChildren().addAll(label,button);
	 layout.setAlignment(Pos.BASELINE_CENTER);
	 
	 Scene scene= new Scene(layout);
	 window.setScene(scene);
	 window.showAndWait(); 
 }}