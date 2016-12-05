package logic;

public class Timeline {
	
	private long spawnTime;
	public static Timeline instance = new Timeline();
	
	public Timeline() {
		//TODO get current time to spawnTime
		this.spawnTime = 0L;
	}
	
	public void draw(){
		// TODO merge timeline drawing from GUI
	}

	public long getTime(){
		return spawnTime;
	}
}
