package logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import GUI.GameScreen;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import utility.DrawingUtility;

// TODO: Auto-generated Javadoc
/**
 * The Class GameManager.
 */
public class GameManager {

	public static final int perfectDelay = 50;
	public static final int goodDelay = 100;
	public static final int activationDelay = 200;
	public static final int drawDelay = 2000;
	public static final float hardModifier = 0.5f;
	public static final float easyModifier = 1.5f;

	private static long currentTime;
	private static long endTime;
	private static Song currentSong;
	public static Thread timer;
	private Thread drawer;
	public static ScheduledExecutorService exec = Executors.newScheduledThreadPool(10);
	public static ScheduledService<Void> drawService;
	private GameScreen gameScreen;

	public GameManager(Song song, GameScreen game) {
		// TODO Auto-generated constructor stub
		this.gameScreen = game;
		currentSong = song;
		currentTime = 0;
		endTime = currentSong.getTotalTime();
		MainLogic.instance.getMp().setOnEndOfMedia(new Runnable(){
			@Override
			public void run(){
				MainLogic.instance.getMp().stop();
			}
		});
		timer = new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println(endTime);
				while(currentTime < endTime){
					currentTime = (long) MainLogic.instance.getMp().currentTimeProperty().get().toMillis();
					if(currentTime>endTime-1000) break;
				}
				MainLogic.instance.getMp().stop();
				Platform.runLater(new Runnable(){
					@Override
					public void run(){
						MainLogic.instance.switchScreen("MenuScreen");
					}
				});
			}
		});
//		gameScreen.setOnKeyPressed(new EventHandler<KeyEvent>(){
//			@Override
//			public void handle(KeyEvent k){
//				System.out.println(currentTime);
//			}
//		});
//		Platform.runLater(() -> gameScreen.requestFocus());
		drawService = new ScheduledService<Void>(){
			@Override
			protected Task<Void> createTask(){
				return new Task<Void>(){
					@Override
					public Void call(){
						for(long time: currentSong.getNotes().keySet()){
							if(Math.abs(time - currentTime) <= 50){
								for(GameButton btn: currentSong.getNotes().get(time)){
									if(!btn.isDrawn){
										System.out.println("draw " + btn.toString());
										System.out.println(MainLogic.instance.getCurrentScreen().getRoot());
										Platform.runLater(() -> btn.draw());
										//btn.draw();
									}
								}
							}		
						}
						return null;
					}
				};
			}
		};
//		Task<Void> drawing = new Task<Void>(){
//			@Override
//			public Void call(){
//				for(long time: currentSong.getNotes().keySet()){
//					if(Math.abs(time - currentTime) <= drawDelay||true){
//						for(GameButton btn: currentSong.getNotes().get(time)){
//							if(!btn.isDrawn){
//								btn.draw();
//							}
//						}
//					}		
//				}
//				return null;
//			}
//		};
		System.out.println(MainLogic.instance.getCurrentScreen().getRoot());
		drawService.setPeriod(Duration.millis(10));
		drawService.setExecutor(exec);
		
	}
	
	/**
	 * Gets the current time.
	 *
	 * @return the current time
	 */
	public static long getCurrentTime(){
		return currentTime;
	}
	
	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public static long getEndTime(){
		return endTime;
	}
	
	/**
	 * Sets the end time.
	 *
	 * @param end the new end time
	 */
	public static void setEndTime(long end){
		endTime = end;
	}
}
