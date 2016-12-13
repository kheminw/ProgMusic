package logic;

// TODO: Auto-generated Javadoc
/**
 * The Class Timeline.
 */
public class Timeline {
	
	/** The spawn time. */
	private long spawnTime;
	
	/** The instance. */
	public static Timeline instance = new Timeline();
	
	/**
	 * Instantiates a new timeline.
	 */
	public Timeline() {
		//TODO get current time to spawnTime
		this.spawnTime = 0L;
	}
	
	/**
	 * Draw.
	 */
	public void draw(){
		// TODO merge timeline drawing from GUI
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public long getTime(){
		return spawnTime;
	}
}
