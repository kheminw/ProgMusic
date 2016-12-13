package utility;

import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.animation.Transition;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonCloseTransition.
 */
public class ButtonCloseTransition extends Transition {
	
	/** The polygon. */
	private Polygon polygon;
	
	/** The points. */
	private double[] points;
	
	/** The movable point 1 X offset. */
	double movablePoint1XOffset;
	
	/** The movable point 1 Y offset. */
	double movablePoint1YOffset;
	
	/** The movable point 2 X offset. */
	double movablePoint2XOffset;
	
	/** The movable point 2 Y offset. */
	double movablePoint2YOffset;
	
	/** The direction. */
	private int direction;
	
	/** The duration. */
	private Duration duration;
	
	/** The animation ratio. */
	private float animationRatio;
	
	/** The trapezoid trans. */
	private Translate trapezoidTrans;
	
	/** The trapezoid trans 2. */
	private Translate trapezoidTrans2;
	
	/** The trapezoid trans 3. */
	private Translate trapezoidTrans3;
	
	/** The trapezoid trans 4. */
	private Translate trapezoidTrans4;
	
	/**
	 * Instantiates a new button close transition.
	 *
	 * @param shape the shape
	 * @param direction the direction
	 * @param duration the duration
	 */
	public ButtonCloseTransition(Polygon shape, int direction, Duration duration) {
		// TODO Auto-generated constructor stub
//		for(double point: shape.getPoints()){
//			System.out.println(point);
//		}
		this.setCycleDuration(Duration.millis(2000));
		this.polygon = shape;
		this.points = polygon.getPoints().stream().mapToDouble(d -> d).toArray();
		movablePoint1XOffset = points[2];
		movablePoint1YOffset = points[3];
		movablePoint2XOffset = points[4];
		movablePoint2YOffset = points[5];
		if(direction >= 1 &&direction <= 3) this.direction = direction;
		this.duration = duration;
		this.animationRatio = (float) (this.duration.toMillis()/2000);
	}

	/* (non-Javadoc)
	 * @see javafx.animation.Transition#interpolate(double)
	 */
	@Override
	protected void interpolate(double percentage) {
		// TODO Auto-generated method stub
		double[] pointInterpolate = points.clone();
		double[] currentPoints = polygon.getPoints().stream().mapToDouble(d -> d).toArray().clone();
		if(direction==1){
			trapezoidTrans = new Translate(30*(float)percentage*(1), 280*(float)percentage);
			trapezoidTrans2 = new Translate(-130*(float)percentage*(1), 280*(float)percentage);
			trapezoidTrans3 = new Translate(30*(float)percentage*(1), (280*(float)percentage)+(10*(float)percentage*(animationRatio)));
			trapezoidTrans4 = new Translate(-130*(float)percentage*(1), (280*(float)percentage)+(10*(float)percentage*(animationRatio)));
		}
		else if(direction==2){
			trapezoidTrans = new Translate(-50*(float)percentage*(1), 280*(float)percentage);
			trapezoidTrans2 = new Translate(-50*(float)percentage*(1), 280*(float)percentage);
			trapezoidTrans3 = new Translate(-50*(float)percentage*(1), 280*(float)percentage);
			trapezoidTrans4 = new Translate(-50*(float)percentage*(1), 280*(float)percentage);
		}
		else if(direction==3){
			trapezoidTrans = new Translate(-130*(float)percentage*(1), 280*(float)percentage);
			trapezoidTrans2 = new Translate(30*(float)percentage*(1), 280*(float)percentage);
			trapezoidTrans3 = new Translate(-130*(float)percentage*(1), 280*(float)percentage);
			trapezoidTrans4 = new Translate(30*(float)percentage*(1), 280*(float)percentage);
		}
		pointInterpolate[0] = movablePoint1XOffset - pointInterpolate[0];
		pointInterpolate[1] -= movablePoint1YOffset;
		pointInterpolate[6] -= movablePoint2XOffset;
		pointInterpolate[7] -= movablePoint2YOffset;
		pointInterpolate[2] = 0;
		pointInterpolate[3] = 0;
		pointInterpolate[4] = 0;
		pointInterpolate[5] = 0;
		//Scale trapezoidScale = new Scale(6*(float)percentage, 14*(float)percentage);
		
		if(Double.compare(percentage, 1-animationRatio) <=0){
			trapezoidTrans.transform2DPoints(pointInterpolate, 0, currentPoints, 0, 1);
			trapezoidTrans2.transform2DPoints(pointInterpolate, 6, currentPoints, 6, 1);
			trapezoidTrans3.transform2DPoints(pointInterpolate, 2, currentPoints, 2, 1);
			trapezoidTrans4.transform2DPoints(pointInterpolate, 4, currentPoints, 4, 1);
			currentPoints[0] = movablePoint1XOffset - currentPoints[0];
			currentPoints[1] += movablePoint1YOffset;
			currentPoints[6] += movablePoint2XOffset;
			currentPoints[7] += movablePoint2YOffset;
			currentPoints[2] = movablePoint1XOffset - currentPoints[2];
			currentPoints[3] += movablePoint1YOffset;
			currentPoints[4] += movablePoint2XOffset;
			currentPoints[5] += movablePoint2YOffset;
			DrawingUtility.addPoints(polygon, currentPoints);
		}
		else{
			trapezoidTrans.transform2DPoints(pointInterpolate, 0, currentPoints, 0, 1);
			trapezoidTrans2.transform2DPoints(pointInterpolate, 6, currentPoints, 6, 1);
			currentPoints[0] = movablePoint1XOffset - currentPoints[0];
			currentPoints[1] += movablePoint1YOffset;
			currentPoints[6] += movablePoint2XOffset;
			currentPoints[7] += movablePoint2YOffset;
			DrawingUtility.addPoints(polygon, currentPoints);
		}
		//trapezoidScale.transform2DPoints(pointInterpolate, 2, currentPoints, 2, 2);
		
//		System.out.println("");
//		System.out.print("Percentage: " + percentage + " Closing: "); 
//		for(double point : polygon.getPoints().stream().mapToDouble(d -> d).toArray()){
//			System.out.print(point+" ");
//		}
//		System.out.println("");
//		System.out.println(polygon.getPoints());
	}

}