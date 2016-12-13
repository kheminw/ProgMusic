package logic;

// TODO: Auto-generated Javadoc
/**
 * The Class SlideButton.
 */
public class SlideButton extends GameButton {
	
	/**
	 * Instantiates a new slide button.
	 *
	 * @param timeInMillis the time in millis
	 * @param defaultScore the default score
	 * @param lane the lane
	 */
	public SlideButton(int timeInMillis, int lane) {
		super(timeInMillis, lane);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see logic.GameButton#hit()
	 */
	@Override
	public void hit() {
		// TODO Auto-generated method stub
		if(isActivated()&&!isDestroyed()){
			checkGrade();
			this.destroyed = true;
		}
	}

	/* (non-Javadoc)
	 * @see logic.GameButton#getZ()
	 */
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see logic.GameButton#isVisible()
	 */
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see logic.GameButton#draw()
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString(){
		return "SlideButton: "+"Lane: " +lane+" Time: "+spawnTime;
	}

}
