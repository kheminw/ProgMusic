package application;

import java.io.FileNotFoundException;
import java.util.Random;

import GUI.GameScreen;
import GUI.MenuScreen;
import GUI.SettingScreen;
import GUI.RenderableHolder;
import GUI.SelectSongScreen;
import GUI.SettingScreen;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import logic.MainLogic;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	
    private IntegerProperty brightness = new SimpleIntegerProperty();

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		 
		
		Scene scene = MainLogic.instance.getCurrentScreen();
		
		final DoubleBinding colorValue = brightness.multiply(2.55);

        StringExpression styleString = Bindings.format("-fx-base:rgb(%1$.0f , %1$.0f, %1$.0f)", colorValue);

        brightness.set(20);
		primaryStage.setTitle("ProgMusic");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
