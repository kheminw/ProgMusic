package logic;

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

}
