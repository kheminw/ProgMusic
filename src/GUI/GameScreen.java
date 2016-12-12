package GUI;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Effect;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.PlayerStatus;
import utility.DrawingUtility;
import utility.InvalidDirectionException;
import utility.InvalidLengthException;

public class GameScreen extends Pane {
	private Canvas canvas;
	private GraphicsContext gc;
	private Text currentScore;
	
	public GameScreen() {
		
		

		this.canvas = new Canvas(800, 470);
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.bg[3], 0, 0,800,470);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		gc.strokeRoundRect(30, 120, 30, 200, 5, 5);
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
		List<Node> objects = null;
		List<Node> objects2 = null;
		List<Node> objects3 = null;
		try {
			objects = DrawingUtility.drawHoldButton(3, 1000, Color.BLUE);
			objects2 = DrawingUtility.drawHoldButton(2, 500, Color.ALICEBLUE);
			objects3 = DrawingUtility.drawHoldButton(1, 500, Color.AQUA);
		} catch (InvalidDirectionException | InvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getChildren().add(canvas);
		this.getChildren().add(tapLine);
		this.getChildren().addAll(objects);
		this.getChildren().addAll(objects2);
		this.getChildren().addAll(objects3);
		Rectangle highHp = new Rectangle(30, 200);
		highHp.setLayoutX(30);
		highHp.setLayoutY(120);
		highHp.setFill(Color.LIMEGREEN);
		if(PlayerStatus.getHp() > 85){
		}
		
	}
}
