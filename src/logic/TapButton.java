package logic;

import utility.DrawingUtility;

public class TapButton extends GameButton {

	public TapButton(int timeInMillis, int defaultScore, int lane) {
		super(timeInMillis, defaultScore, lane);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		if(isActivated()&&!isDestroyed()){
			checkGrade();
			this.destroyed = true;
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
		DrawingUtility.drawTapButton(this.lane);
	}

}
