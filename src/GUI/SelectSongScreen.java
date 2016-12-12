package GUI;

import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SelectSongScreen extends Pane {
	
	private Canvas canvas;
	private GraphicsContext gc;
    private Font song = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 40);
    private Font f = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 16);

	public SelectSongScreen() throws FileNotFoundException{
		Image image = RenderableHolder.bg[4];
		// new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
		BackgroundSize backgroundSize = new BackgroundSize(800, 470, true, true, true, true);
		// new BackgroundImage(image, repeatX, repeatY, position, size)
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		// new Background(images...)
		Background background = new Background(backgroundImage);
		this.setBackground(background);
		
		this.canvas = new Canvas(800, 470);
		gc = canvas.getGraphicsContext2D();
		Rectangle open = new Rectangle(800, 470, Color.BLACK);
		FadeTransition fadeTransition = 
	            new FadeTransition(Duration.millis(3000), open);
	        fadeTransition.setFromValue(1.0f);
	        fadeTransition.setToValue(0.3f);
		fadeTransition.play();
		
		Line splitW = new Line(-200	, 0, 200, 0);
		splitW.setLayoutX(400);
		splitW.setLayoutY(235);
		splitW.setRotate(90);
		splitW.setStroke(Color.WHITE);
		FadeTransition fadeTransitionLine1 = 
	            new FadeTransition(Duration.millis(3000), splitW);
	        fadeTransitionLine1.setFromValue(0f);
	        fadeTransitionLine1.setToValue(1f);
		fadeTransitionLine1.play();
		
		Line split = new Line(-100,0,200,0);
		split.setLayoutX(150);
		split.setLayoutY(200);
		split.setStroke(Color.WHITE);
		FadeTransition fadeTransitionLine2 = 
	            new FadeTransition(Duration.millis(3000), split);
	        fadeTransitionLine2.setFromValue(0f);
	        fadeTransitionLine2.setToValue(1f);
		fadeTransitionLine2.play();
		
		Text firstSong = new Text(190, 75, "L");
		firstSong.setFont(song);
		firstSong.setFill(Color.WHITE);
		FadeTransition fadeTransition1 = 
	            new FadeTransition(Duration.millis(3000), firstSong);
	        fadeTransition1.setFromValue(0f);
	        fadeTransition1.setToValue(1f);
		fadeTransition1.play();
		
		Text secondSong = new Text(140, 150, "ANiMA");
		secondSong.setFont(song);
		secondSong.setFill(Color.WHITE);
		FadeTransition fadeTransition2 = 
	            new FadeTransition(Duration.millis(3000), secondSong);
	        fadeTransition2.setFromValue(0f);
	        fadeTransition2.setToValue(1f);
		fadeTransition2.play();
		
		Text score = new Text(180, 230, "0000000");
		score.setFont(f);
		score.setFill(Color.WHITE);
		FadeTransition fadeTransitionScore = 
	            new FadeTransition(Duration.millis(3000), score);
	        fadeTransitionScore.setFromValue(0f);
	        fadeTransitionScore.setToValue(1f);
		fadeTransitionScore.play();
//		Text score = new Text (120,250,"0000000");
//		score.setFont(song);
//		score.setFill(Color.WHITE);
		
		this.getChildren().addAll(canvas,open,splitW,split,firstSong,secondSong);
		drawLabel(170, 320, "80.00%");
		drawLabel(180, 230, "Score");
	}
	
	public void drawLabel(int x,int y,String text){
		Text t = new Text(x, y, text);
		FadeTransition fadeTransition1 = 
	            new FadeTransition(Duration.millis(3000), t);
	        fadeTransition1.setFromValue(0f);
	        fadeTransition1.setToValue(1f);
		fadeTransition1.play();
		t.setFont(f);
		t.setFill(Color.WHITE);
		this.getChildren().add(t);
	}
}
