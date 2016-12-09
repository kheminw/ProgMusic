package test;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.geometry.Pos;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Shear;
import javafx.util.Duration;

public class testTransition extends Pane {

	public testTransition() {
		// TODO Auto-generated method stub

		
		Rectangle rect = new Rectangle();
		rect.setWidth(10);
		rect.setHeight(20);
		rect.setLayoutX(310);
		rect.setLayoutY(90);
		Shear sh = new Shear();
		sh.setX(-0.45);
		rect.getTransforms().add(sh);
		Line note = new Line();
		note.setLayoutX(400);
		note.setLayoutY(90);
		note.setStartX(-100);
		note.setEndX(-90);
		note.setStartY(0);
		note.setEndY(0);

		note.setStrokeWidth(10);
		note.setStrokeLineCap(StrokeLineCap.ROUND);
		note.setFill(Color.DARKBLUE);
		FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), note);
		fadeTransition.setFromValue(0.5f);
		fadeTransition.setToValue(1f);

		FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(3000), rect);
		fadeTransition2.setFromValue(0.3f);
		fadeTransition2.setToValue(1f);

		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1900), note);
		// if(s == 1){
		translateTransition.setFromX(0);
		translateTransition.setToX(-80);
		translateTransition.setFromY(0);
		translateTransition.setToY(280);
		// }
		TranslateTransition rectr = new TranslateTransition(Duration.millis(2000), rect);
		rectr.setFromX(0);
		rectr.setFromY(0);
		rectr.setToX(-40);
		rectr.setToY(140);
		// if(s == 2){
		// translateTransition.setFromX(0);
		// translateTransition.setToX(0);
		// translateTransition.setFromY(0);
		// translateTransition.setToY(280);
		// }
		// translateTransition.setFromX(0);
		// translateTransition.setToX(80);
		// translateTransition.setFromY(0);
		// translateTransition.setToY(280);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), note);
		scaleTransition.setToX(6);
		scaleTransition.setToY(2);

		ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(2000), rect);
//		scaleTransition2.setFromX(1);
//		scaleTransition2.setToX(6);
//		scaleTransition2.setFromY(1);
//		scaleTransition2.setToY(14);
		scaleTransition2.setToX(6);
		scaleTransition2.setToY(14);
		TranslateTransition rectr2 = new TranslateTransition(Duration.millis(2000), rect);
		rectr2.setFromX(-40);
		rectr2.setFromY(140);
		rectr2.setToX(-80);
		rectr2.setToY(280);
		ScaleTransition scaleTransition3 = new ScaleTransition(Duration.millis(2000), rect);
		scaleTransition3.setToX(0);
		scaleTransition3.setToY(0);
		FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(3000), rect);
		fadeTransition3.setFromValue(1f);
		fadeTransition3.setToValue(0f);
		
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, scaleTransition, scaleTransition2,
				rectr, fadeTransition2

		);
		
		ParallelTransition close = new ParallelTransition();
		close.getChildren().addAll(rectr2,scaleTransition3,fadeTransition3);
		SequentialTransition seqT = new SequentialTransition (parallelTransition,close);
	     seqT.play();
		
		this.getChildren().addAll(note, rect);
	}

}
