package logic;

import java.util.List;

import javafx.scene.Node;
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
	private List<Node> objects;
	
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
		checkGrade();
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
		try {
			List<Node> objects = DrawingUtility.drawHoldButton(lane, holdTime, Color.AQUA);
			this.objects = objects;
			MainLogic.instance.getGameScreen().addLongNote(objects);
		} catch (InvalidDirectionException | InvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.isDrawn = true;
	}
	public void remove(){
		for(Node object: objects){
			MainLogic.instance.getGameScreen().removeNote(object);
		}
	}
	@Override
	public String toString(){
		return "HoldButton: "+"Lane: " +lane+" Time: "+spawnTime+" HoldTime: "+holdTime;
	}

}
