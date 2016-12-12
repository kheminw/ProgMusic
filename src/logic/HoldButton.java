package logic;

import javafx.scene.paint.Color;
import utility.DrawingUtility;
import utility.InvalidDirectionException;
import utility.InvalidLengthException;

public class HoldButton extends GameButton {
	private int holdTime;
	public HoldButton(int timeInMillis, int defaultScore, int holdTime, int lane) {
		super(timeInMillis, defaultScore, lane);
		// TODO Auto-generated constructor stub
		this.holdTime = holdTime;
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		if(isActivated()&&!isDestroyed()){
			this.holdTime--;
			if(!checkGrade()) this.destroyed = true;
			if(holdTime==0) this.destroyed = true;
		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

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

}
