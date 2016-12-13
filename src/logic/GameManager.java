package logic;

import javafx.application.Platform;
import javafx.scene.media.MediaPlayer;

// TODO: Auto-generated Javadoc
/**
 * The Class GameManager.
 */
public class GameManager {
	
	public static final int perfectDelay = 50;
	public static final int goodDelay = 100;
	public static final int activationDelay = 200;
	public static final float hardModifier = 0.5f;
	public static final float easyModifier = 1.5f;
	
	private static long currentTime;
	private static long endTime;
	private static Song currentSong;
	private Thread timer;
	public GameManager(Song song) {
		// TODO Auto-generated constructor stub
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
					//System.out.println("Time: " + currentTime + " Ends at: " + endTime);
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
