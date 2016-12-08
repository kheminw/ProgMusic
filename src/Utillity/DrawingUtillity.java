package Utillity;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class DrawingUtillity {
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
		note.setFill(Color.DARKBLUE);
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
}
