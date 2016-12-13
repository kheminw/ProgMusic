package logic;

import javafx.scene.Node;
import javafx.scene.shape.Line;
import utility.DrawingUtility;

// TODO: Auto-generated Javadoc
/**
 * The Class TapButton.
 */
public class TapButton extends GameButton {

	public Node note;
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
//		System.out.println("being drawn lane: "+this.lane);
		Line note = DrawingUtility.drawTapButton(this.lane);
		this.note = note;
		MainLogic.instance.getGameScreen().addNote(note);
		this.isDrawn = true;
	}
	public void remove(){
		MainLogic.instance.getGameScreen().removeNote(note);
	}
	@Override
	public String toString(){
		return "TapButton: "+"Lane: " +lane+" Time: "+spawnTime;
	}

}
