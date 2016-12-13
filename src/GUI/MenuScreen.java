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
import javafx.animation.FadeTransition;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import logic.MainLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuScreen.
 */
public class MenuScreen extends Pane{
	
	/** The canvas. */
	private Canvas canvas;
	
	/** The gc. */
	private GraphicsContext gc;
	
	/** The start. */
	private Text start;
	
	/** The option. */
	private Text option;
	
	/** The exit. */
	private Text exit;
	
	/** The f. */
	private  Font f = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 30);
	
	/**
	 * Instantiates a new menu screen.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public MenuScreen() throws FileNotFoundException {
		

		Image image = RenderableHolder.bg[0];
		// new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
		BackgroundSize backgroundSize = new BackgroundSize(800, 470, true, true, true, true);
		// new BackgroundImage(image, repeatX, repeatY, position, size)
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		// new Background(images...)
		Background background = new Background(backgroundImage);
		this.setBackground(background);
		
		this.canvas = new Canvas(800, 470);
		gc = canvas.getGraphicsContext2D();
		Rectangle open = new Rectangle(800, 470, Color.WHITE);
		FadeTransition fadeTransition = 
	            new FadeTransition(Duration.millis(5000), open);
	        fadeTransition.setFromValue(1.0f);
	        fadeTransition.setToValue(0f);
		fadeTransition.play();
		
		Stop[] stopStart = new Stop[] { new Stop(0, Color.STEELBLUE), new Stop(1, Color.SKYBLUE)};
		LinearGradient lg1 = new LinearGradient(1, 0.5, 1, 1, true, CycleMethod.NO_CYCLE, stopStart);
		start = new Text(450, 165, "Start");
		start.setFont(f);
		start.setFill(lg1);
		FadeTransition fadeTransitionStart = 
	            new FadeTransition(Duration.millis(6000), start);
	        fadeTransitionStart.setFromValue(0f);
	        fadeTransitionStart.setToValue(1f);
		fadeTransitionStart.play();
		
		Stop[] stopOption = new Stop[] { new Stop(0, Color.LIGHTBLUE), new Stop(1, Color.ORANGE)};
		LinearGradient lg2 = new LinearGradient(1, 0.5, 1, 1, true, CycleMethod.NO_CYCLE, stopOption);
		option = new Text(500,225,"Setting");
		option.setFont(f);
		option.setFill(lg2);
		FadeTransition fadeTransitionOption = 
	            new FadeTransition(Duration.millis(6000), option);
	        fadeTransitionOption.setFromValue(0f);
	        fadeTransitionOption.setToValue(1f);
		fadeTransitionOption.play();
		
		Stop[] stopExit = new Stop[] { new Stop(0, Color.ORANGE), new Stop(1, Color.ORANGERED)};
		LinearGradient lg3 = new LinearGradient(1, 0.5, 1, 1, true, CycleMethod.NO_CYCLE, stopExit);
		exit = new  Text(575,285,"Exit");
		exit.setFont(f);
		exit.setFill(lg3);
		FadeTransition fadeTransitionExit = 
	            new FadeTransition(Duration.millis(6000), exit);
	        fadeTransitionExit.setFromValue(0f);
	        fadeTransitionExit.setToValue(1f);
		fadeTransitionExit.play();
		
		DropShadow ds = new DropShadow();
		ds.setOffsetX(2.0f);
		ds.setOffsetY(2.0f);
		ds.setColor(Color.LIGHTGOLDENRODYELLOW);
		gc.drawImage(RenderableHolder.bg[1], 370, 50,270,60);
		this.getChildren().add(canvas);
		this.getChildren().addAll(open,option,exit,start);
		

		
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
				
				start.setFill(lg1);
			}
		});
		
		start.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event){
				MainLogic.instance.switchScreen("SelectSongScreen");
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
				option.setFill(lg2);
			}
		});
		
		option.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event){
				MainLogic.instance.switchScreen("SettingScreen");
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
				exit.setFill(lg3);
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
