package test;

import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.animation.Transition;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class CenterButtonCloseTransition extends Transition {
	private Polygon polygon;
	private double[] points;
	double movablePoint1XOffset;
	double movablePoint1YOffset;
	double movablePoint2XOffset;
	double movablePoint2YOffset;
	public CenterButtonCloseTransition(Polygon shape) {
		// TODO Auto-generated constructor stub
		for(double point: shape.getPoints()){
			System.out.println(point);
		}
		this.setCycleDuration(Duration.millis(2000));
		this.polygon = shape;
		this.points = polygon.getPoints().stream().mapToDouble(d -> d).toArray();
		movablePoint1XOffset = points[2];
		movablePoint1YOffset = points[3];
		movablePoint2XOffset = points[4];
		movablePoint2YOffset = points[5];
	}

	@Override
	protected void interpolate(double percentage) {
		// TODO Auto-generated method stub
		double[] pointInterpolate = points.clone();
		double[] currentPoints = polygon.getPoints().stream().mapToDouble(d -> d).toArray().clone();
		pointInterpolate[0] = movablePoint1XOffset - pointInterpolate[0];
		pointInterpolate[1] -= movablePoint1YOffset;
		pointInterpolate[6] -= movablePoint2XOffset;
		pointInterpolate[7] -= movablePoint2YOffset;
		pointInterpolate[2] = 0;
		pointInterpolate[3] = 0;
		pointInterpolate[4] = 0;
		pointInterpolate[5] = 0;
		Translate trapezoidTrans = new Translate(-37.5*(float)percentage, 280*(float)percentage);
		Translate trapezoidTrans2 = new Translate(-37.5*(float)percentage, 280*(float)percentage);
		Translate trapezoidTrans3 = new Translate(-30*(float)percentage, 280*(float)percentage);
		//Translate trapezoidTrans4 = new Translate()
		//Scale trapezoidScale = new Scale(6*(float)percentage, 14*(float)percentage);
		
		if(Double.compare(percentage, 0.8) <=0){
			trapezoidTrans.transform2DPoints(pointInterpolate, 0, currentPoints, 0, 1);
			trapezoidTrans2.transform2DPoints(pointInterpolate, 6, currentPoints, 6, 1);
			trapezoidTrans3.transform2DPoints(pointInterpolate, 2, currentPoints, 2, 2);
			currentPoints[0] = movablePoint1XOffset - currentPoints[0];
			currentPoints[1] += movablePoint1YOffset;
			currentPoints[6] += movablePoint2XOffset;
			currentPoints[7] += movablePoint2YOffset;
			currentPoints[2] = movablePoint1XOffset - currentPoints[2];
			currentPoints[3] += movablePoint1YOffset;
			currentPoints[4] += movablePoint2XOffset;
			currentPoints[5] += movablePoint2YOffset;
			testTransition.addPoints(polygon, currentPoints);
		}
		else{
			trapezoidTrans.transform2DPoints(pointInterpolate, 0, currentPoints, 0, 1);
			trapezoidTrans2.transform2DPoints(pointInterpolate, 6, currentPoints, 6, 1);
			currentPoints[0] = movablePoint1XOffset - currentPoints[0];
			currentPoints[1] += movablePoint1YOffset;
			currentPoints[6] += movablePoint2XOffset;
			currentPoints[7] += movablePoint2YOffset;
			testTransition.addPoints(polygon, currentPoints);
		}
		//trapezoidScale.transform2DPoints(pointInterpolate, 2, currentPoints, 2, 2);
		
		System.out.println("");
		System.out.print("Percentage: " + percentage + " Closing: "); 
		for(double point : polygon.getPoints().stream().mapToDouble(d -> d).toArray()){
			System.out.print(point+" ");
		}
		System.out.println("");
//		System.out.println(polygon.getPoints());
	}

}