package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuScreen extends Pane{
	private Canvas canvas;
	private GraphicsContext gc;
	private Text start;
	private Text option;
	private Text exit;
	
	public MenuScreen() throws FileNotFoundException {
		
	    Font f = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 30);

		
		this.canvas = new Canvas(800, 470);
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.bg[0], 0, 0,800,470);
		
		start = new Text(450, 165, "Start");
		start.setFont(f);
		start.setFill(Color.WHITE);
		
		option = new Text(500,225,"Setting");
		option.setFont(f);
		option.setFill(Color.WHITE);
		
		exit = new  Text(575,285,"Exit");
		exit.setFont(f);
		exit.setFill(Color.WHITE);
		
		DropShadow ds = new DropShadow();
		ds.setOffsetX(2.0f);
		ds.setOffsetY(2.0f);
		ds.setColor(Color.LIGHTGOLDENRODYELLOW);
		gc.drawImage(RenderableHolder.bg[1], 370, 50,270,60);
		this.getChildren().add(canvas);
		this.getChildren().addAll(start,option,exit);
		
		
		start.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				start.setEffect(ds);

			}
		});
		
		start.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				start.setEffect(null);
				
				start.setFill(Color.WHITE);
			}
		});
		
		option.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				option.setEffect(ds);

			}
		});
		
		option.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				option.setEffect(null);
				//start.setStyle(startStyle);
				option.setFill(Color.WHITE);
			}
		});
		
		exit.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				exit.setEffect(ds);

			}
		});
		
		exit.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				exit.setEffect(null);
				//start.setStyle(startStyle);
				exit.setFill(Color.WHITE);
			}
		});
		
		exit.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event){
				Alert exitConfirm = new Alert(AlertType.CONFIRMATION);
				exitConfirm.setTitle("Exit");
				exitConfirm.setHeaderText(null);
				exitConfirm.setContentText("Are you sure you want to exit the game?");
				Optional<ButtonType> result = exitConfirm.showAndWait();
				if((result.isPresent()) &&(result.get() == ButtonType.OK)){
					System.exit(0);
				}
			}
		});
	}
}
