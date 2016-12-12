package GUI;

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
import javafx.scene.text.*;

public class SettingScreen extends VBox {
	private Canvas canvas;
	private GraphicsContext gc;
	public SettingScreen(){
		
		
		VBox setting = new VBox(60);
		setting.setAlignment(Pos.CENTER);
		setting.setPadding(new Insets(50));
		//title
		Text title = new Text("Setting");
		title.setStyle("-fx-font: 30px NixieOne;");
		title.setStrokeWidth(0.1);
		title.setStroke(Color.BLACK);
		title.setFill(Color.WHITE);
		
		//Sound
		HBox volume = new HBox(50);
		final Slider soundBar = new Slider(0, 100, 100);
		soundBar.setBlockIncrement(10);
		soundBar.setLayoutX(50);
		soundBar.setLayoutY(200);
		soundBar.setPrefWidth(500);
		Label soundLabel = new Label("Sound       ");
		soundLabel.setTextFill(Color.WHITE);
		Label soundValue = new Label("100");
		soundValue.setTextFill(Color.WHITE);
		volume.getChildren().addAll(soundLabel,soundBar,soundValue);
		soundBar.valueProperty().addListener(new ChangeListener() {
		
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				soundValue.textProperty().setValue( String.valueOf((int)soundBar.getValue()));
			}
		});
		//bright
		HBox brightness = new HBox(50);
		final Slider brightBar = new Slider(0, 100, 100);
		brightBar.setBlockIncrement(10);
		brightBar.setLayoutX(50);
		brightBar.setLayoutY(200);
		brightBar.setPrefWidth(500);
		Label brightValue = new Label("100");
		brightValue.setTextFill(Color.WHITE);
		Label brightLabel = new Label("Brightness");
		brightLabel.setTextFill(Color.WHITE);
		brightness.getChildren().addAll(brightLabel,brightBar,brightValue);
		brightBar.valueProperty().addListener(new ChangeListener() {
			
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				brightValue.textProperty().setValue( String.valueOf((int)brightBar.getValue()));
			}
		});
		
		Button restoreDefault = new Button("Restore Results");
		restoreDefault.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				soundBar.setValue(100);
				brightBar.setValue(100);
			}
		});
		
		Button clearHighScore = new Button("Reset highscore");
		
		Button back = new Button("Back");
		HBox restore = new HBox(50);
		
		ToggleButton tb = new ToggleButton("Difficulty : Easy");
		tb.setSelected(false);
		tb.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(tb.getText().equals("Difficulty : Easy")){
					tb.setText("Difficulty : Normal");
					tb.setSelected(false);

				}
				else if(tb.getText().equals("Difficulty : Normal")){
					tb.setText("Difficulty : Hard");
					tb.setSelected(false);

				}
				else if(tb.getText().equals("Difficulty : Hard")){
					tb.setText("Difficulty : Easy");
					tb.setSelected(false);

				}
			}
		});
		
		
		restore.setAlignment(Pos.CENTER);
		restore.getChildren().addAll(tb,restoreDefault,clearHighScore);
		setting.getChildren().addAll(title,volume,brightness,restore,back);

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
}