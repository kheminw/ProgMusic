package logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import GUI.GameScreen;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;

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
	private Thread timer;
	private Thread drawer;
	private ScheduledExecutorService exec = Executors.newScheduledThreadPool(10);
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
		this.timer = new Thread(new Runnable(){
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
		gameScreen.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent k){
				System.out.println	(currentTime);
				
			}
		});
		Platform.runLater(() -> gameScreen.requestFocus());
		drawer = new Thread(new Runnable(){
			@Override
			public void run(){
				for(long time: currentSong.getNotes().keySet()){
					if(time - drawDelay <= currentTime){
						for(GameButton btn: currentSong.getNotes().get(time)){
							if(!btn.isDrawn){
								Platform.runLater(new Runnable(){
									@Override
									public void run(){
										btn.draw();
									}
								});
							}
						}
					}		
				}
			}
		});
		timer.start();
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
