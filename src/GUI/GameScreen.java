package GUI;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Effect;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Text;

public class GameScreen extends Pane {
	private Canvas canvas;
	private GraphicsContext gc;
	private Text currentScore;
	private String startStyle = "-fx-font: 30px Designosaur; -fx-fill:linear-gradient(from 0% 0% to 100% 100% ,#6d90b8 10%, #2296ee 90%);-fx-stroke:black;-fx-stroke-width:0.1;";
	
	public GameScreen() {
		
		this.canvas = new Canvas(800, 470);
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.bg[3], 0, 0,800,470);
		Line tapLine = new Line();
		tapLine.setStyle("-fx-stroke:#f0f1f5");
		tapLine.setEndX(350);
		tapLine.setLayoutX(390);
		tapLine.setLayoutY(370);
		tapLine.setStartX(-350);
		tapLine.setStrokeLineCap(StrokeLineCap.ROUND);
		tapLine.setStrokeLineJoin(StrokeLineJoin.BEVEL);
		tapLine.setStrokeWidth(20);

		MotionBlur mb = new MotionBlur();
		mb.setRadius(63);
		tapLine.setEffect(mb);
		
		this.getChildren().add(canvas);
		this.getChildren().add(tapLine);

	}
}
