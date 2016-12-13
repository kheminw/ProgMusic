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
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import logic.GameManager;
import logic.MainLogic;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Application {
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		 
		
		Scene scene = MainLogic.instance.getCurrentScreen();
		
		
		
		primaryStage.setTitle("ProgMusic");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@Override
	public void stop(){
		if(MainLogic.instance.getGameScreen() != null){
			GameManager.timer.interrupt();
			GameManager.exec.shutdownNow();
			GameManager.exec2.shutdownNow();
		}
		Platform.exit();
		System.exit(0);
	}
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
