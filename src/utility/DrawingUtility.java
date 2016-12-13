package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

// TODO: Auto-generated Javadoc
/**
 * The Class DrawingUtility.
 */
public class DrawingUtility   {

	/**
	 * Draw tap button.
	 *
	 * @param r the r
	 */
	public static Line drawTapButton(int r) {
		Line note = new Line();

		 if(r == 1){
		 note.setLayoutX(400);
		 note.setStroke(Color.RED);
		 }
		 if(r == 2){
		 note.setLayoutX(485);
		 note.setStroke(Color.GREEN);
		 }
		 if(r == 3){
		 note.setLayoutX(570);
		 note.setStroke(Color.DARKBLUE);
		 }
		note.setLayoutY(90);
		note.setStartX(-100);
		note.setEndX(-90);
		note.setStartY(0);
		note.setEndY(0);
		note.setStrokeWidth(10);
		note.setStrokeLineCap(StrokeLineCap.ROUND);
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
		return(note);
		
	}
	
	/**
	 * Draw hold button.
	 *
	 * @param r the r
	 * @param millis the millis
	 * @param color the color
	 * @return the list
	 * @throws InvalidDirectionException the invalid direction exception
	 * @throws InvalidLengthException the invalid length exception
	 */
	public static List<Node> drawHoldButton(int r, long millis, Color color) throws InvalidDirectionException, InvalidLengthException{
		//millis can only be 2000, 1000 or 500
		if(millis != 500 && millis != 1000 && millis != 2000) throw new InvalidLengthException();
		
		float animationRatio = (float)millis/2000;
		System.out.println(animationRatio);
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
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(millis), note);
		scaleTransition.setToX(6*animationRatio);
		scaleTransition.setToY(2*animationRatio);
		FadeTransition fadeTransition = null;
		FadeTransition fadeTransition2 = null;
		TranslateTransition translateTransition = null;
		ButtonOpenTransition open = null;
		if(r==1){
			note.setLayoutX(400);
			note.setStartX(-100);
			note.setEndX(-90);
			open = new ButtonOpenTransition(leftTrapezoid, 1, Duration.millis(millis));
			fadeTransition = new FadeTransition(Duration.millis(millis), note);
			fadeTransition.setFromValue(0.5f);
			fadeTransition.setToValue(1f);
			fadeTransition2 = new FadeTransition(Duration.millis(millis), leftTrapezoid);
			fadeTransition2.setFromValue(0.5f);
			fadeTransition2.setToValue(0.7f);
			translateTransition = new TranslateTransition(Duration.millis(millis), note);
			translateTransition.setFromX(0);
			translateTransition.setToX(-80*animationRatio);
			translateTransition.setFromY(0);
			translateTransition.setToY(280*animationRatio);
			open.setOnFinished(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
					ButtonCloseTransition close = new ButtonCloseTransition(leftTrapezoid, 1, Duration.millis(millis));
					FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(2000), leftTrapezoid);
					fadeTransition3.setFromValue(0.7f);
					fadeTransition3.setToValue(0.7f);
					TranslateTransition contTr = new TranslateTransition(Duration.millis(2000-millis), note);
					contTr.setFromX(-80*animationRatio);
					contTr.setToX(-80);
					contTr.setFromY(280*animationRatio);
					contTr.setToY(280);
					ScaleTransition contSc = new ScaleTransition(Duration.millis(2000-millis), note);
					contSc.setFromX(6*animationRatio);
					contSc.setToX(6);
					contSc.setFromY(2*animationRatio);
					contSc.setToY(2);
					ParallelTransition closeParallel = new ParallelTransition(close, fadeTransition3, contTr, contSc);
					closeParallel.play();
				}
			});
			objects.add(note);
			objects.add(leftTrapezoid);
		}
		else if(r==2){
			note.setLayoutX(485);
			note.setStartX(-100);
			note.setEndX(-90);
			open = new ButtonOpenTransition(centerTrapezoid, 2, Duration.millis(millis));
			fadeTransition = new FadeTransition(Duration.millis(millis), note);
			fadeTransition.setFromValue(0.5f);
			fadeTransition.setToValue(1f);
			fadeTransition2 = new FadeTransition(Duration.millis(millis), centerTrapezoid);
			fadeTransition2.setFromValue(0.5f);
			fadeTransition2.setToValue(0.7f);
			translateTransition = new TranslateTransition(Duration.millis(millis), note);
			translateTransition.setFromX(0);
			translateTransition.setToX(0);
			translateTransition.setFromY(0);
			translateTransition.setToY(280*animationRatio);
			open.setOnFinished(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
					ButtonCloseTransition close = new ButtonCloseTransition(centerTrapezoid, 2, Duration.millis(millis));
					FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(2000), centerTrapezoid);
					fadeTransition3.setFromValue(0.7f);
					fadeTransition3.setToValue(0.7f);
					TranslateTransition contTr = new TranslateTransition(Duration.millis(2000-millis), note);
					contTr.setFromX(0*animationRatio);
					contTr.setToX(0);
					contTr.setFromY(280*animationRatio);
					contTr.setToY(280);
					ScaleTransition contSc = new ScaleTransition(Duration.millis(2000-millis), note);
					contSc.setFromX(6*animationRatio);
					contSc.setToX(6);
					contSc.setFromY(2*animationRatio);
					contSc.setToY(2);
					ParallelTransition closeParallel = new ParallelTransition(close, fadeTransition3, contTr, contSc);
					closeParallel.play();
				}
			});
			objects.add(note);
			objects.add(centerTrapezoid);
		}
		else if(r==3){
			note.setLayoutX(570);
			note.setStartX(-100);
			note.setEndX(-90);
			open = new ButtonOpenTransition(rightTrapezoid, 3, Duration.millis(millis));
			fadeTransition = new FadeTransition(Duration.millis(millis), note);
			fadeTransition.setFromValue(0.5f);
			fadeTransition.setToValue(1f);
			fadeTransition2 = new FadeTransition(Duration.millis(millis), rightTrapezoid);
			fadeTransition2.setFromValue(0.5f);
			fadeTransition2.setToValue(0.7f);
			translateTransition = new TranslateTransition(Duration.millis(millis), note);
			translateTransition.setFromX(0);
			translateTransition.setToX(80*animationRatio);
			translateTransition.setFromY(0);
			translateTransition.setToY(280*animationRatio);
			open.setOnFinished(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
					ButtonCloseTransition close = new ButtonCloseTransition(rightTrapezoid, 3, Duration.millis(millis));
					FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(2000), rightTrapezoid);
					fadeTransition3.setFromValue(0.7f);
					fadeTransition3.setToValue(0.7f);
					TranslateTransition contTr = new TranslateTransition(Duration.millis(2000-millis), note);
					contTr.setFromX(80*animationRatio);
					contTr.setToX(80);
					contTr.setFromY(280*animationRatio);
					contTr.setToY(280);
					ScaleTransition contSc = new ScaleTransition(Duration.millis(2000-millis), note);
					contSc.setFromX(6*animationRatio);
					contSc.setToX(6);
					contSc.setFromY(2*animationRatio);
					contSc.setToY(2);
					ParallelTransition closeParallel = new ParallelTransition(close, fadeTransition3, contTr, contSc);
					closeParallel.play();
				}
			});
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
	
	/**
	 * Adds the points.
	 *
	 * @param polygon the polygon
	 * @param array the array
	 */
	public synchronized static void addPoints(Polygon polygon, double[] array){
		polygon.getPoints().clear();
		polygon.getPoints().addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
	}
	
	/**
	 * Display perfect.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public static Text displayPerfect()throws FileNotFoundException{
		Font f = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 24);
		Text perfect = new Text(360, 150, "Perfect");
		perfect.setFont(f);
		perfect.setFill(Color.LIME);
		return(perfect);
	}
	
	/**
	 * Display good.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public static Text displayGood()throws FileNotFoundException{
		Font f = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 24);
		Text good = new Text(360, 150, "Good");
		good.setFont(f);
		good.setFill(Color.YELLOW);
		return(good);
	}
	
	/**
	 * Display miss.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public static Text displayMiss()throws FileNotFoundException{
		Font f = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 24);
		Text miss = new Text(360, 150, "Miss");
		miss.setFont(f);
		miss.setFill(Color.RED);
		return(miss);
	}
}
