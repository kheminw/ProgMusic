package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class OptionScreen extends Pane {
	
	public OptionScreen(){
		final Slider sound = new Slider(0, 100, 100);
		sound.setBlockIncrement(10);
		sound.setLayoutX(50);
		sound.setLayoutY(50	);
		sound.setPrefWidth(600);
		this.getChildren().add(sound);
	}
}
