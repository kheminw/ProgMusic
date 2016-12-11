package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class DrawingUtility {
	public static void drawTapButton(int r) {
		Line note = new Line();

		 if(r == 1){
		 note.setLayoutX(400);
		 }
		 if(r == 2){
		 note.setLayoutX(485);
		 }
		 if(r == 3){
		 note.setLayoutX(570);
		 }
		note.setLayoutY(90);
		note.setStartX(-100);
		note.setEndX(-90);
		note.setStartY(0);
		note.setEndY(0);

		note.setStrokeWidth(10);
		note.setStrokeLineCap(StrokeLineCap.ROUND);
		note.setStroke(Color.DARKBLUE);
		FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), note);
		fadeTransition.setFromValue(0.3f);
		fadeTransition.setToValue(1f);
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), note);
		if(r == 1){
		translateTransition.setFromX(0);
		translateTransition.setToX(-80);
		translateTransition.setFromY(0);
		translateTransition.setToY(280);
		 }
		 if(r == 2){
			 translateTransition.setFromX(0);
			 translateTransition.setToX(0);
			 translateTransition.setFromY(0);
			 translateTransition.setToY(280);
		 }
		 if(r == 3){
		 translateTransition.setFromX(0);
		 translateTransition.setToX(80);
		 translateTransition.setFromY(0);
		 translateTransition.setToY(280);
		 }
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), note);
		scaleTransition.setToX(6);
		scaleTransition.setToY(2);
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, scaleTransition);
		parallelTransition.play();
		
	}
	public static List<Node> drawHoldButton(int r, long millis, Color color) throws InvalidDirectionException{
		//millis can only be 2000, 1000 or 500 
		List<Node> objects = new ArrayList<Node>();
		Polygon leftTrapezoid = new Polygon();
		leftTrapezoid.getPoints().addAll(new Double[] {310.0,70.0,315.0,91.0,295.0,91.0,300.0,70.0});
		leftTrapezoid.setFill(color);
		Polygon rightTrapezoid = new Polygon();
		rightTrapezoid.getPoints().addAll(new Double[] {480.0,70.0,485.0,91.0,465.0,91.0,470.0,70.0});
		rightTrapezoid.setFill(color);
		Polygon centerTrapezoid = new Polygon();
		centerTrapezoid.getPoints().addAll(new Double[] {395.0,70.0,400.0,91.0,380.0,91.0,385.0,70.0});
		centerTrapezoid.setFill(color);
		Line note = new Line();
		note.setLayoutY(90);
		note.setStartY(0);
		note.setEndY(0);
		note.setStrokeWidth(10);
		note.setStrokeLineCap(StrokeLineCap.ROUND);
		note.setFill(color);
		note.setStroke(color);
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), note);
		scaleTransition.setToX(6);
		scaleTransition.setToY(2);
		FadeTransition fadeTransition = null;
		FadeTransition fadeTransition2 = null;
		TranslateTransition translateTransition = null;
		ButtonOpenTransition open = null;
		if(r==1){
			note.setLayoutX(400);
			note.setStartX(-100);
			note.setEndX(-90);
			open = new ButtonOpenTransition(leftTrapezoid, 1);
			fadeTransition = new FadeTransition(Duration.millis(2000), note);
			fadeTransition.setFromValue(0.5f);
			fadeTransition.setToValue(1f);
			fadeTransition2 = new FadeTransition(Duration.millis(2000), leftTrapezoid);
			fadeTransition2.setFromValue(0.5f);
			fadeTransition2.setToValue(0.7f);
			translateTransition = new TranslateTransition(Duration.millis(2000), note);
			translateTransition.setFromX(0);
			translateTransition.setToX(-80);
			translateTransition.setFromY(0);
			translateTransition.setToY(280);
			objects.add(note);
			objects.add(leftTrapezoid);
		}
		else if(r==2){
			note.setLayoutX(485);
			note.setStartX(-100);
			note.setEndX(-90);
			open = new ButtonOpenTransition(centerTrapezoid, 2);
			fadeTransition = new FadeTransition(Duration.millis(2000), note);
			fadeTransition.setFromValue(0.5f);
			fadeTransition.setToValue(1f);
			fadeTransition2 = new FadeTransition(Duration.millis(2000), centerTrapezoid);
			fadeTransition2.setFromValue(0.5f);
			fadeTransition2.setToValue(0.7f);
			translateTransition = new TranslateTransition(Duration.millis(2000), note);
			translateTransition.setFromX(0);
			translateTransition.setToX(-80);
			translateTransition.setFromY(0);
			translateTransition.setToY(280);
			objects.add(note);
			objects.add(centerTrapezoid);
		}
		else if(r==3){
			note.setLayoutX(570);
			note.setStartX(-100);
			note.setEndX(-90);
			open = new ButtonOpenTransition(rightTrapezoid, 3);
			fadeTransition = new FadeTransition(Duration.millis(2000), note);
			fadeTransition.setFromValue(0.5f);
			fadeTransition.setToValue(1f);
			fadeTransition2 = new FadeTransition(Duration.millis(2000), centerTrapezoid);
			fadeTransition2.setFromValue(0.5f);
			fadeTransition2.setToValue(0.7f);
			translateTransition = new TranslateTransition(Duration.millis(2000), note);
			translateTransition.setFromX(0);
			translateTransition.setToX(-80);
			translateTransition.setFromY(0);
			translateTransition.setToY(280);
			objects.add(note);
			objects.add(rightTrapezoid);
		}
		else{
			throw new InvalidDirectionException();
		}
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, scaleTransition, open, fadeTransition2);
		parallelTransition.play();
		return objects;
	}
	public synchronized static void addPoints(Polygon polygon, double[] array){
		polygon.getPoints().clear();
		polygon.getPoints().addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
	}
}
