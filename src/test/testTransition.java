package test;

import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
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
		Polygon rightTrapezoid = new Polygon();
		rightTrapezoid.getPoints().addAll(new Double[] {480.0,70.0,485.0,91.0,465.0,91.0,470.0,70.0});
		rightTrapezoid.setFill(Color.BLUE);
		Polygon centerTrapezoid = new Polygon();
		centerTrapezoid.getPoints().addAll(new Double[] {395.0,70.0,400.0,91.0,380.0,91.0,385.0,70.0});
		centerTrapezoid.setFill(Color.BLUE);
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
		
//		TranslateTransition rectr = new TranslateTransition(Duration.millis(2000), centerTrapezoid);
//		rectr.setFromX(0);
//		rectr.setFromY(0);
//		rectr.setToX(0);
//		rectr.setToY(140);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), note);
		scaleTransition.setToX(6);
		scaleTransition.setToY(2);

//		ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(2000), centerTrapezoid);
//		scaleTransition2.setToX(6);
//		scaleTransition2.setToY(14);
		
		LeftButtonTransition left = new LeftButtonTransition(trapezoid);
		CenterButtonTransition center = new CenterButtonTransition(centerTrapezoid);
		RightButtonTransition right = new RightButtonTransition(rightTrapezoid);
		
//		TranslateTransition rectr2 = new TranslateTransition(Duration.millis(2000), centerTrapezoid);
//		rectr2.setFromX(0);
//		rectr2.setFromY(0);
//		rectr2.setToX(-60);
//		rectr2.setToY(140);
//
//		ScaleTransition scaleTransition3 = new ScaleTransition(Duration.millis(2000), centerTrapezoid);
//		scaleTransition3.setToX(0);
//		scaleTransition3.setToY(0);
		
		FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(3000), trapezoid);
		fadeTransition3.setFromValue(1f);
		fadeTransition3.setToValue(0f);
		
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, scaleTransition, left, fadeTransition2,
				right, center);
		parallelTransition.play();
		Thread timer = new Thread(new Runnable(){
			@Override
			public void run(){
				Instant start = Instant.now();
				while(true){
					Instant current = Instant.now();
					java.time.Duration between = java.time.Duration.between(start, current);
					if(between.compareTo(java.time.Duration.ofMillis(500)) >= 1){
						//parallelTransition.stop();
						break;
					}
				}
				CenterButtonCloseTransition centerClose = new CenterButtonCloseTransition(centerTrapezoid);
				ParallelTransition close = new ParallelTransition(centerClose);
				close.getChildren().addAll();
				close.play();
				System.out.println(parallelTransition.getStatus().toString());
				System.out.println(close.getStatus().toString());
			}
		});
		timer.start();
		parallelTransition.setOnFinished(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				LeftButtonCloseTransition leftClose = new LeftButtonCloseTransition(trapezoid);
				RightButtonCloseTransition rightClose = new RightButtonCloseTransition(rightTrapezoid);
				ParallelTransition close = new ParallelTransition(fadeTransition3, leftClose, rightClose);
				close.getChildren().addAll();
				close.play();
			}
		});
		
//		SequentialTransition seqT = new SequentialTransition (parallelTransition,leftClose,fadeTransition3);
//	    seqT.setCycleCount(Timeline.INDEFINITE); 
		//seqT.play();
		
	     
		this.getChildren().addAll(note, rect,trapezoid, rightTrapezoid, centerTrapezoid);
	}
	public synchronized static void addPoints(Polygon polygon, double[] array){
		polygon.getPoints().clear();
		polygon.getPoints().addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
	}
}
