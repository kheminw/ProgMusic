package test;

import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.animation.Transition;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class LeftButtonTransition extends Transition {
	private Polygon polygon;
	private double[] points;
	double movablePoint1XOffset;
	double movablePoint1YOffset;
	double movablePoint2XOffset;
	double movablePoint2YOffset;
	public LeftButtonTransition(Polygon shape) {
		// TODO Auto-generated constructor stub
		this.setCycleDuration(Duration.millis(2000));
		this.polygon = shape;
		this.points = polygon.getPoints().stream().mapToDouble(d -> d).toArray();
		movablePoint1XOffset = points[0];
		movablePoint1YOffset = points[1];
		movablePoint2XOffset = points[6];
		movablePoint2YOffset = points[7];
	}

	public LeftButtonTransition(double arg0, Polygon shape) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.setCycleDuration(Duration.millis(2000));
		this.polygon = shape;
		this.points = polygon.getPoints().stream().mapToDouble(d -> d).toArray();
		movablePoint1XOffset = points[0];
		movablePoint1YOffset = points[1];
		movablePoint2XOffset = points[6];
		movablePoint2YOffset = points[7];
	}
	
	@Override
	protected void interpolate(double percentage) {
		// TODO Auto-generated method stub
		double[] pointInterpolate = points.clone();
		double[] currentPoints = points.clone();
		pointInterpolate[2] = movablePoint1XOffset - pointInterpolate[2];
		pointInterpolate[3] -= movablePoint1YOffset;
		pointInterpolate[4] -= movablePoint2XOffset;
		pointInterpolate[5] -= movablePoint2YOffset;
		Translate trapezoidTrans = new Translate(30*(float)percentage, 280*(float)percentage);
		Translate trapezoidTrans2 = new Translate(-130*(float)percentage, 280*(float)percentage);
		//Scale trapezoidScale = new Scale(6*(float)percentage, 14*(float)percentage);
		trapezoidTrans.transform2DPoints(pointInterpolate, 2, currentPoints, 2, 1);
		trapezoidTrans2.transform2DPoints(pointInterpolate, 4, currentPoints, 4, 1);
		//trapezoidScale.transform2DPoints(pointInterpolate, 2, currentPoints, 2, 2);
		currentPoints[2] = movablePoint1XOffset - currentPoints[2];
		currentPoints[3] += movablePoint1YOffset;
		currentPoints[4] += movablePoint2XOffset;
		currentPoints[5] += movablePoint2YOffset;
		
		for(double point : currentPoints){
			System.out.println(point);
		}
		polygon.getPoints().clear();
		polygon.getPoints().addAll(Arrays.stream(currentPoints).boxed().collect(Collectors.toList()));
//		System.out.println(polygon.getPoints());
	}

}
