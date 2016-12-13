package logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import GUI.GameScreen;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import utility.DrawingUtility;

// TODO: Auto-generated Javadoc
/**
 * The Class GameManager.
 */
public class GameManager {

	public static final int perfectDelay = 80;
	public static final int goodDelay = 140;
	public static final int activationDelay = 500;
	public static final int drawDelay = 2000;
	public static final float hardModifier = 0.5f;
	public static final float easyModifier = 1.5f;

	private static long currentTime;
	private static long endTime;
	private static Song currentSong;
	public static Thread timer;
	public static Text perfect;
	public static Text good;
	public static Text miss;
	public static ScheduledExecutorService exec = Executors.newScheduledThreadPool(10);
	public static ScheduledExecutorService exec2 = Executors.newScheduledThreadPool(10);
	public static ScheduledService<Void> drawService;
	public static ScheduledService<Void> hitService;
	private static List<KeyCode> currentKey;
	private GameScreen gameScreen;
	
	public GameManager(Song song, GameScreen game) {
		// TODO Auto-generated constructor stub
		try {
			perfect = DrawingUtility.displayPerfect();
			good = DrawingUtility.displayGood();
			miss = DrawingUtility.displayMiss();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentKey = new ArrayList<KeyCode>();
		PlayerStatus.initialize();
		this.gameScreen = game;
		currentSong = song;
		currentTime = 0;
		endTime = currentSong.getTotalTime();
		MainLogic.instance.getMp().setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				MainLogic.instance.getMp().stop();
			}
		});
		timer = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(endTime);
				while (currentTime < endTime) {
					currentTime = (long) MainLogic.instance.getMp().currentTimeProperty().get().toMillis();
					if (currentTime > endTime - 1000)
						break;
				}
				MainLogic.instance.getMp().stop();
				PlayerStatus.setGameOver(true);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						if(PlayerStatus.getScore()>currentSong.getHighScore()){
							currentSong.setHighScore(PlayerStatus.getScore());
							utility.Utility.writeScore(PlayerStatus.getScore(), currentSong.getTitle());
							Alert score = new Alert(AlertType.INFORMATION);
							score.setTitle("Game Over");
							score.setHeaderText(null);
							score.setContentText("Your score is: "+PlayerStatus.getScore()+"\nHigh score!");
							score.showAndWait();
						}
						else{
							currentSong.setHighScore(PlayerStatus.getScore());
							Alert score = new Alert(AlertType.INFORMATION);
							score.setTitle("Game Over");
							score.setHeaderText(null);
							score.setContentText("Your score is: "+PlayerStatus.getScore());
							score.showAndWait();
						}
						MainLogic.instance.switchScreen("MenuScreen");
					}
				});
			}
		});
		gameScreen.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent k) {
				System.out.println(k.getCode().toString() + " " + currentTime);
				if (!currentKey.contains(k.getCode())) {
					currentKey.add(k.getCode());
				}
			}
		});
		gameScreen.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent k) {
				System.out.println(k.getCode().toString() + " " + currentTime);
				if (currentKey.contains(k.getCode())) {
					currentKey.remove(k.getCode());
				}
			}
		});
		Platform.runLater(() -> gameScreen.requestFocus());
		drawService = new ScheduledService<Void>() {
			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					public Void call() {
						for (long time : currentSong.getNotes().keySet()) {
							if (Math.abs(time - currentTime) <= 50) {
								for (GameButton btn : currentSong.getNotes().get(time)) {
									if (!btn.isDrawn) {
//										System.out.println("draw " + btn.toString());
//										System.out.println(MainLogic.instance.getCurrentScreen().getRoot());
										Platform.runLater(() -> btn.draw());
										// btn.draw();
									}
								}
							} else if (currentTime - time >= 3000) {
								for (GameButton btn : currentSong.getNotes().get(time)) {
									if(btn.isDrawn && btn.isActivated() && !btn.isHit()){
										btn.setButtonDownTime(-1000);
										Platform.runLater(() -> btn.hit());
									}
									Platform.runLater(() -> btn.remove());
								}
							}
						}
						return null;
					}
				};
			}
		};
		hitService = new ScheduledService<Void>() {
			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					public Void call() {
						for (long time : currentSong.getNotes().keySet()) {
							for (GameButton btn : currentSong.getNotes().get(time)) {
								if (currentTime - time >= 2000) {
									for (KeyCode key : currentKey) {
										if (btn.isDrawn && btn.isActivated() && key.equals(KeyCode.S) && btn.lane == 1 && !btn.isHit()) {
											btn.setButtonDownTime(currentTime);
											Platform.runLater(() -> btn.hit());
										}
										else if (btn.isDrawn && btn.isActivated() && key.equals(KeyCode.D) && btn.lane == 2 && !btn.isHit()) {
											btn.setButtonDownTime(currentTime);
											Platform.runLater(() -> btn.hit());
										}
										else if (btn.isDrawn && btn.isActivated() && key.equals(KeyCode.F) && btn.lane == 3 && !btn.isHit()) {
											btn.setButtonDownTime(currentTime);
											Platform.runLater(() -> btn.hit());
										}
									}
								}
							}
						}
						Platform.runLater(() ->{
							MainLogic.instance.getGameScreen().changeScore(PlayerStatus.getScore());
//							Rectangle newHp = new Rectangle(30, 200);
//							newHp.setLayoutX(30);
//							newHp.setLayoutY(120);
//							newHp.setFill(Color.LIMEGREEN);
//							newHp.setHeight((PlayerStatus.getHp()/100)*200);
//							newHp.setLayoutY(120+((PlayerStatus.getHp()-100)/100)*200);
//							System.out.println(PlayerStatus.getHp());
//							if(PlayerStatus.getHp() > 80){
//								System.out.println("set fill");
//								newHp.setFill(Color.LIME);
//							}
//							else if(PlayerStatus.getHp() > 60){
//								newHp.setFill(Color.YELLOWGREEN);
//							}
//							else if(PlayerStatus.getHp() > 40){
//								newHp.setFill(Color.YELLOW);
//							}
//							else if(PlayerStatus.getHp() > 20){
//								newHp.setFill(Color.ORANGE);
//							}
//							else if(PlayerStatus.getHp() > 0){
//								newHp.setFill(Color.RED);
//							}
//							MainLogic.instance.getGameScreen().removeHp();
//							MainLogic.instance.getGameScreen().addHp(newHp);
						});
						return null;
					}
				};
			}
		};
//		System.out.println(MainLogic.instance.getCurrentScreen().getRoot());
		drawService.setPeriod(Duration.millis(10));
		drawService.setExecutor(exec);
		hitService.setPeriod(Duration.millis(1));
		hitService.setExecutor(exec2);

	}

	/**
	 * Gets the current time.
	 *
	 * @return the current time
	 */
	public static long getCurrentTime() {
		return currentTime;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public static long getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param end
	 *            the new end time
	 */
	public static void setEndTime(long end) {
		endTime = end;
	}
}
