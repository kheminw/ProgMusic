package GUI;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameManager;
import logic.MainLogic;
import logic.PlayerStatus;
import utility.DrawingUtility;
import utility.InvalidDirectionException;
import utility.InvalidLengthException;

// TODO: Auto-generated Javadoc
/**
 * The Class GameScreen.
 */
public class GameScreen extends Pane {
	
	/** The canvas. */
	private Canvas canvas;
	
	/** The gc. */
	private GraphicsContext gc;
	
	/** The current score. */
	private Text currentScore;
	
	/** The hp. */
	private Rectangle hp ;
	private Label score;
	
	/**
	 * Instantiates a new game screen.
	 */
	public GameScreen() {
		
		

		this.canvas = new Canvas(800, 470);
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.bg[3], 0, 0,800,470);
//		gc.setStroke(Color.BLACK);
//		gc.setLineWidth(1);
//		gc.strokeRoundRect(30, 120, 30, 200, 5, 5);
		score = new Label();
		score.setTextFill(Color.WHITE);
		score.setLayoutX(23);
		score.setLayoutY(23);
		score.setMaxWidth(100);
		score.setText("0");
		score.setFont(Font.font("Tahoma", 30));
		Line tapLine = new Line();
		tapLine.setStyle("-fx-stroke:#f0f1f5");
		tapLine.setEndX(350);
		tapLine.setLayoutX(390);
		tapLine.setLayoutY(370);
		tapLine.setStartX(-350);
		tapLine.setStrokeLineCap(StrokeLineCap.ROUND);
		tapLine.setStrokeLineJoin(StrokeLineJoin.BEVEL);
		tapLine.setStrokeWidth(20);

		MotionBlur mb = new MotionBlur();
		mb.setRadius(63);
		tapLine.setEffect(mb);
//		List<Node> objects = null;
//		List<Node> objects2 = null;
//		List<Node> objects3 = null;
//		try {
//			objects = DrawingUtility.drawHoldButton(3, 1000, Color.BLUE);
//			objects2 = DrawingUtility.drawHoldButton(2, 500, Color.ALICEBLUE);
//			objects3 = DrawingUtility.drawHoldButton(1, 500, Color.AQUA);
//		} catch (InvalidDirectionException | InvalidLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		GameManager gm = new GameManager(MainLogic.instance.getSongSet().get(SelectSongScreen.getCurrentSong()), this);
		this.getChildren().add(canvas);
		this.getChildren().add(tapLine);
		this.getChildren().add(score);
//		this.getChildren().addAll(objects);
//		this.getChildren().addAll(objects2);
//		this.getChildren().addAll(objects3);
//		hp = new Rectangle(30, 200);
//		hp.setLayoutX(30);
//		hp.setLayoutY(120);
//		hp.setFill(Color.LIMEGREEN);
//		this.getChildren().add(hp);
//		Thread t = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				while(!PlayerStatus.isGameOver()){
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					hp.setHeight((PlayerStatus.getHp()/100)*120);
//					hp.setLayoutY(120+(PlayerStatus.getHp()/100)*120);
//					if(PlayerStatus.getHp() > 80){
//						hp.setFill(Color.LIME);
//					}
//					else if(PlayerStatus.getHp() > 60){
//						hp.setFill(Color.YELLOWGREEN);
//					}
//					else if(PlayerStatus.getHp() > 40){
//						hp.setFill(Color.YELLOW);
//					}
//					else if(PlayerStatus.getHp() > 20){
//						hp.setFill(Color.ORANGE);
//					}
//					else if(PlayerStatus.getHp() > 0){
//						hp.setFill(Color.RED);
//					}
//				}
//			}
//		});
	
	}
	public synchronized void changeScore(int score){
		String cur = Integer.toString(score);
		this.score.setText(cur);
	}
	public synchronized void removeHp(){
		this.getChildren().remove(hp);
	}
	public synchronized void addHp(Rectangle hp){
		if(!this.getChildren().contains(hp)){
			this.hp = hp;
			this.getChildren().add(this.hp);
		}
	}
	public synchronized void addNote(Node node){
		if(!this.getChildren().contains(node))this.getChildren().add(node);
	}
	public synchronized void addLongNote(List<Node> nodes){
		this.getChildren().addAll(nodes);
	}
	public synchronized void removeNote(Node node){
		this.getChildren().remove(node);
	}
}
