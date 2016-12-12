package application;
	
import java.io.FileNotFoundException;

import GUI.GameScreen;
import GUI.MenuScreen;
import GUI.SettingScreen;
import GUI.RenderableHolder;
import GUI.SelectSongScreen;
import GUI.SettingScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import logic.MainLogic;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
			Scene scene = MainLogic.instance.getCurrentScreen();
			primaryStage.setTitle("ProgMusic");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
