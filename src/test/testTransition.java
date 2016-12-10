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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Shear;
import javafx.util.Duration;

public class testTransition extends Pane {

	public testTransition() {
		// TODO Auto-generated method stub
		Polygon trapezoid = new Polygon();
		trapezoid.getPoints().addAll(new Double[] {310.0,70.0,315.0,91.0,295.0,91.0,300.0,70.0});
		trapezoid.setFill(Color.BLUE);
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
		note.setFill(Color.BLUE);
		note.setStroke(Color.BLUE);
		FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), note);
		fadeTransition.setFromValue(0.5f);
		fadeTransition.setToValue(1f);

		FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(3000), trapezoid);
		fadeTransition2.setFromValue(0.5f);
		fadeTransition2.setToValue(1f);

		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), note);
		translateTransition.setFromX(0);
		translateTransition.setToX(-80);
		translateTransition.setFromY(0);
		translateTransition.setToY(280);
		
//		TranslateTransition rectr = new TranslateTransition(Duration.millis(2000), trapezoid);
//		rectr.setFromX(0);
//		rectr.setFromY(0);
//		rectr.setToX(-80);
//		rectr.setToY(140);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), note);
		scaleTransition.setToX(6);
		scaleTransition.setToY(2);

//		ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(2000), trapezoid);
//		scaleTransition2.setToX(6);
//		scaleTransition2.setToY(14);
		
		LeftButtonTransition left = new LeftButtonTransition(trapezoid);
		
//		TranslateTransition rectr2 = new TranslateTransition(Duration.millis(2000), trapezoid);
//		rectr2.setFromX(0);
//		rectr2.setFromY(0);
//		rectr2.setToX(-60);
//		rectr2.setToY(140);

//		ScaleTransition scaleTransition3 = new ScaleTransition(Duration.millis(2000), trapezoid);
//		scaleTransition3.setToX(0);
//		scaleTransition3.setToY(0);
		
		FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(3000), trapezoid);
		fadeTransition3.setFromValue(1f);
		fadeTransition3.setToValue(0f);
		
		ParallelTransition parallelTransition = new ParallelTransition();
//		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, scaleTransition, scaleTransition2,
//				rectr, fadeTransition2);
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, scaleTransition, left, fadeTransition2);
		parallelTransition.play();
		
		parallelTransition.setOnFinished(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				LeftButtonCloseTransition leftClose = new LeftButtonCloseTransition(trapezoid);
				ParallelTransition close = new ParallelTransition(fadeTransition3, leftClose);
				close.getChildren().addAll();
				close.play();
			}
		});
//		SequentialTransition seqT = new SequentialTransition (parallelTransition,leftClose,fadeTransition3);
//	    seqT.setCycleCount(Timeline.INDEFINITE); 
		//seqT.play();
		
	     
		this.getChildren().addAll(note, rect,trapezoid);
	}

}
