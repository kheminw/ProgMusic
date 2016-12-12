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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
			MenuScreen root = new MenuScreen();
			GameScreen game = new GameScreen();
			SettingScreen setting = new SettingScreen();
			SelectSongScreen select = new SelectSongScreen();
			Scene scene = new Scene(select,800,470);
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
