package logic;

public class GameManager {
	
	public static final int perfectDelay = 50;
	public static final int goodDelay = 100;
	public static final int activationDelay = 200;
	public static final float hardModifier = 0.5f;
	public static final float easyModifier = 1.5f;
	
	private static long currentTime;
	private static long endTime;
	private static Song currentSong;
	public GameManager() {
		// TODO Auto-generated constructor stub
		currentTime = 0;
		endTime = currentSong.getTotalTime();
	}
	public static long getCurrentTime(){
		return currentTime;
	}
	public static long getEndTime(){
		return endTime;
	}
	public static void setEndTime(long end){
		endTime = end;
	}
}
