package logic;

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

}
