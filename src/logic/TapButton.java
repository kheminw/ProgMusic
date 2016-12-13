package logic;

import javafx.scene.shape.Line;
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
	public TapButton(int timeInMillis, int lane) {
		super(timeInMillis, lane);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see logic.GameButton#hit()
	 */
	@Override
	public void hit() {
		// TODO Auto-generated method stub
		if(isVisible()){
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
		return isActivated()&&!isDestroyed();
	}

	/* (non-Javadoc)
	 * @see logic.GameButton#draw()
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		Line note = DrawingUtility.drawTapButton(this.lane);
		MainLogic.instance.getGameScreen().getChildren().add(note);
		this.isDrawn = true;
	}
	@Override
	public String toString(){
		return "TapButton: "+"Lane: " +lane+" Time: "+spawnTime;
	}

}
