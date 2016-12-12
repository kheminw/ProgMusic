package logic;

public class GameManager {
	
	private static long currentTime;
	private static long endTime;
	private static Song currentSong;
	public GameManager() {
		// TODO Auto-generated constructor stub
		currentTime = 0;
		endTime = currentSong.getTotalTime();
	}

}
