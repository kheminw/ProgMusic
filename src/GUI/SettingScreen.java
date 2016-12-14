package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.MainLogic;
import logic.PlayerStatus;
import javafx.scene.text.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SettingScreen.
 */
public class SettingScreen extends VBox {
	
	/** The title font. */
	private Font titleFont = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Light.otf")), 30);
	
	/** The f. */
	private Font f = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Light.otf")), 15);
	
	/** The button font. */
	private Font buttonFont = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Light.otf")), 12);
	
	/** The sound bar. */
	private	Slider soundBar;
	
	/** The opacity bar. */
	private	Slider opacityBar;
	

	/**
	 * Instantiates a new setting screen.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public SettingScreen() throws FileNotFoundException{
		
		VBox setting = new VBox(60);
		setting.setAlignment(Pos.CENTER);
		setting.setPadding(new Insets(50));
		//title
		Text title = new Text("Setting");
		title.setFont(titleFont);
		title.setFill(Color.WHITE);
		
		//Sound
		HBox volume = new HBox(50);
		soundBar = new Slider(0, 100,100);
		soundBar.setBlockIncrement(10);
		soundBar.setLayoutX(50);
		soundBar.setLayoutY(200);
		soundBar.setPrefWidth(500);
		Label soundLabel = new Label("Sound  ");
		soundLabel.setTextFill(Color.WHITE);
		soundLabel.setFont(f);
		Label soundValue = new Label("100");
		soundValue.setTextFill(Color.WHITE);
		soundValue.setFont(f);
		volume.getChildren().addAll(soundLabel,soundBar,soundValue);
		soundBar.valueProperty().addListener(new ChangeListener() {
		
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				soundValue.textProperty().setValue( String.valueOf((int)soundBar.getValue()));
				MainLogic.instance.setVolume(soundBar.getValue()/100);
				MainLogic.instance.getMp().setVolume(soundBar.getValue()/100);
			}
		});
		//bright
		HBox opacity = new HBox(50);
		opacityBar = new Slider(0, 100, 100);
		opacityBar.setBlockIncrement(10);
		opacityBar.setLayoutX(50);
		opacityBar.setLayoutY(200);
		opacityBar.setPrefWidth(500);
		Label opacityValue = new Label("100");
		opacityValue.setTextFill(Color.WHITE);
		opacityValue.setFont(f);
		Label opacityLabel = new Label("Opacity");
		opacityLabel.setFont(f);
		opacityLabel.setTextFill(Color.WHITE);
		opacity.getChildren().addAll(opacityLabel,opacityBar,opacityValue);
		
		opacityBar.valueProperty().addListener(new ChangeListener() {
			
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				opacityValue.textProperty().setValue( String.valueOf((int)opacityBar.getValue()));
				MainLogic.instance.setOpacity(soundBar.getValue()/100);
				MainLogic.instance.getSetting().setOpacity(opacityBar.getValue()/100);
				
			}
		});
		
		Button restoreDefault = new Button("Restore Defaults");
		restoreDefault.setFont(buttonFont);
		restoreDefault.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				soundBar.setValue(100);
				opacityBar.setValue(100);
			}
		});
		
		Button clearHighScore = new Button("Reset highscore");
		clearHighScore.setFont(buttonFont);
		Button back = new Button("Back");
		back.setFont(buttonFont);
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				MainLogic.instance.switchScreen("MenuScreen");
			}
		});
		
		HBox restore = new HBox(50);
		
		ToggleButton tb = new ToggleButton("Difficulty : Easy");
		tb.setSelected(false);
		tb.setFont(buttonFont);
		tb.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(tb.getText().equals("Difficulty : Easy")){
					PlayerStatus.setMode(2);
					tb.setText("Difficulty : Normal");
					tb.setSelected(false);

				}
				else if(tb.getText().equals("Difficulty : Normal")){
					PlayerStatus.setMode(3);
					tb.setText("Difficulty : Hard");
					tb.setSelected(false);

				}
				else if(tb.getText().equals("Difficulty : Hard")){
					PlayerStatus.setMode(1);
					tb.setText("Difficulty : Easy");
					tb.setSelected(false);

				}
			}
		});
		
		
		restore.setAlignment(Pos.CENTER);
		restore.getChildren().addAll(tb,restoreDefault,clearHighScore);
		setting.getChildren().addAll(title,volume,opacity,restore,back);

		this.getChildren().add(setting);
		
		Image image = RenderableHolder.bg[2];
		// new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
		BackgroundSize backgroundSize = new BackgroundSize(800, 470, true, true, true, true);
		// new BackgroundImage(image, repeatX, repeatY, position, size)
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		// new Background(images...)
		Background background = new Background(backgroundImage);
		this.setBackground(background);
	}

	
	
	/**
	 * Gets the sound bar.
	 *
	 * @return the sound bar
	 */
	public Slider getSoundBar() {
		return soundBar;
	}

	/**
	 * Gets the opacity bar.
	 *
	 * @return the opacity bar
	 */
	public Slider getOpacityBar() {
		return opacityBar;
	}
}
