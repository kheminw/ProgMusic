package utility;

import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.animation.Transition;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class ButtonOpenTransition extends Transition {

	private Polygon polygon;
	private double[] points;
	private double movablePoint1XOffset;
	private double movablePoint1YOffset;
	private double movablePoint2XOffset;
	private double movablePoint2YOffset;
	private Translate trapezoidTrans;
	private Translate trapezoidTrans2;
	private int direction = 1;
	private Duration duration;
	private float animationRatio; 
	public ButtonOpenTransition(Polygon shape, int direction, Duration duration){
		// TODO Auto-generated constructor stub
		this.setCycleDuration(duration);
		this.polygon = shape;
		this.points = polygon.getPoints().stream().mapToDouble(d -> d).toArray();
		movablePoint1XOffset = points[0];
		movablePoint1YOffset = points[1];
		movablePoint2XOffset = points[6];
		movablePoint2YOffset = points[7];
		if(direction >= 1 && direction <= 3) this.direction = direction;
		this.duration = duration;
		this.animationRatio = (float)(this.duration.toMillis())/2000;
	}

	@Override
	protected void interpolate(double percentage) {
		double[] pointInterpolate = points.clone();
		double[] currentPoints = points.clone();
		pointInterpolate[2] = movablePoint1XOffset - pointInterpolate[2];
		pointInterpolate[3] -= movablePoint1YOffset;
		pointInterpolate[4] -= movablePoint2XOffset;
		pointInterpolate[5] -= movablePoint2YOffset;
		if(direction==1){
			trapezoidTrans = new Translate(30*(float)percentage*animationRatio, 280*(float)percentage*animationRatio);
			trapezoidTrans2 = new Translate(-130*(float)percentage*animationRatio, 280*(float)percentage*animationRatio);
		}
		else if(direction==2){
			trapezoidTrans = new Translate(-50*(float)percentage*animationRatio, 280*(float)percentage*animationRatio);
			trapezoidTrans2 = new Translate(-50*(float)percentage*animationRatio, 280*(float)percentage*animationRatio);
		}
		else if(direction==3){
			trapezoidTrans = new Translate(-130*(float)percentage*animationRatio, 280*(float)percentage*animationRatio);
			trapezoidTrans2 = new Translate(30*(float)percentage*animationRatio, 280*(float)percentage*animationRatio);
		}
		trapezoidTrans.transform2DPoints(pointInterpolate, 2, currentPoints, 2, 1);
		trapezoidTrans2.transform2DPoints(pointInterpolate, 4, currentPoints, 4, 1);
		currentPoints[2] = movablePoint1XOffset - currentPoints[2];
		currentPoints[3] += movablePoint1YOffset;
		currentPoints[4] += movablePoint2XOffset;
		currentPoints[5] += movablePoint2YOffset;
		
//		System.out.println();
//		System.out.print("Opening: ");
//		for(double point : currentPoints){
//			System.out.print(point+" ");
//		}
//		System.out.println();
		DrawingUtility.addPoints(polygon, currentPoints);
	}

}