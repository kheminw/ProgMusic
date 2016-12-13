package logic;

import javafx.scene.paint.Color;
import utility.DrawingUtility;
import utility.InvalidDirectionException;
import utility.InvalidLengthException;

// TODO: Auto-generated Javadoc
/**
 * The Class HoldButton.
 */
public class HoldButton extends GameButton {
	
	/** The hold time. */
	private int holdTime;
	
	/**
	 * Instantiates a new hold button.
	 *
	 * @param timeInMillis the time in millis
	 * @param defaultScore the default score
	 * @param holdTime the hold time
	 * @param lane the lane
	 */
	public HoldButton(int timeInMillis, int lane, int holdTime) {
		super(timeInMillis, lane);
		// TODO Auto-generated constructor stub
		this.holdTime = holdTime;
	}

	/* (non-Javadoc)
	 * @see logic.GameButton#hit()
	 */
	@Override
	public void hit() {
		// TODO Auto-generated method stub
		if(isActivated()&&!isDestroyed()){
			this.holdTime--;
			if(!checkGrade()) this.destroyed = true;
			if(holdTime==0) this.destroyed = true;
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
		try {
			DrawingUtility.drawHoldButton(lane, holdTime, Color.AQUA);
		} catch (InvalidDirectionException | InvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString(){
		return "HoldButton: "+"Lane: " +lane+" Time: "+spawnTime+" HoldTime: "+holdTime;
	}

}
