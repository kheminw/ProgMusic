package application;
	
import GUI.GameScreen;
import GUI.MenuScreen;
import GUI.OptionScreen;
import GUI.RenderableHolder;
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
	public void start(Stage primaryStage) {
			MenuScreen root = new MenuScreen();
			GameScreen game = new GameScreen();
			OptionScreen option = new OptionScreen();
			Scene scene = new Scene(option,800,470);
			Canvas canvas = new Canvas(800, 470);
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
