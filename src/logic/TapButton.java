package logic;

import utility.DrawingUtility;

// TODO: Auto-generated Javadoc
/**
 * The Class TapButton.
 */
public class TapButton extends GameButton {

	/**
	 * Instantiates a new tap button.
	 *
	 * @param timeInMillis the time in millis
	 * @param defaultScore the default score
	 * @param lane the lane
	 */
	public TapButton(int timeInMillis, int defaultScore, int lane) {
		super(timeInMillis, defaultScore, lane);
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
		DrawingUtility.drawTapButton(this.lane);
	}

}
