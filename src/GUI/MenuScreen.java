package GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
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
	private String startStyle = "-fx-font: 30px Designosaur; -fx-fill:linear-gradient(from 0% 0% to 100% 100% ,#6d90b8 10%, #2296ee 90%);-fx-stroke:black;-fx-stroke-width:0.1;";
	public MenuScreen() {
		
		this.canvas = new Canvas(800, 470);
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.menuScreen[0], 0, 0,800,470);
		start = new Text(450, 150, "Start");
		start.setStyle(startStyle);
		DropShadow ds = new DropShadow();
		ds.setOffsetX(2.0f);
		ds.setOffsetY(2.0f);
		ds.setColor(Color.WHITE);
		
		
		
		
		
		option = new Text("Option");
		exit = new  Text("Exit");
		gc.drawImage(RenderableHolder.menuScreen[1], 370, 50,270,60);
		this.getChildren().add(canvas);
		this.getChildren().add(start);
		
		
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
				start.setStyle(startStyle);
			}
		});
	}
}
