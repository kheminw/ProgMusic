package logic;

// TODO: Auto-generated Javadoc
/**
 * The Class GameManager.
 */
public class GameManager {
	
	/** The Constant perfectDelay. */
	public static final int perfectDelay = 50;
	
	/** The Constant goodDelay. */
	public static final int goodDelay = 100;
	
	/** The Constant activationDelay. */
	public static final int activationDelay = 200;
	
	/** The Constant hardModifier. */
	public static final float hardModifier = 0.5f;
	
	/** The Constant easyModifier. */
	public static final float easyModifier = 1.5f;
	
	/** The current time. */
	private static long currentTime;
	
	/** The end time. */
	private static long endTime;
	
	/** The current song. */
	private static Song currentSong;
	
	/**
	 * Instantiates a new game manager.
	 */
	public GameManager() {
		// TODO Auto-generated constructor stub
		currentTime = 0;
		endTime = currentSong.getTotalTime();
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
