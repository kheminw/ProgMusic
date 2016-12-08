package logic;

public abstract class GameButton implements Tappable {
	
	protected long spawnTime;
	protected int score;
	protected long buttonDownTime = 0;
	protected boolean hit;
	protected boolean destroyed;
	protected int lane;
	
	public GameButton(int timeInMillis, int defaultScore, int lane) {
		this.spawnTime = timeInMillis;
		this.score = defaultScore;
		this.hit = false;
		this.destroyed = false;
		this.lane = lane;
	}
	
	//classes that inherit this class should also set the value of destroyed 
	abstract public void hit();
	
	public boolean checkGrade() {
		if(Math.abs(this.buttonDownTime - Timeline.instance.getTime()) == 25){
			//TODO gui.displayPerfect();
			PlayerStatus.setScore(score);
			PlayerStatus.setHp(5);
			PlayerStatus.setFever(8);
			PlayerStatus.incrementCombo();
			this.hit = true;
			return true;
		}
		else if(Math.abs(this.buttonDownTime - Timeline.instance.getTime()) == 50){
			//TODO gui.displayGood();
			PlayerStatus.setScore(score);
			PlayerStatus.setHp(3);
			PlayerStatus.setFever(5);
			PlayerStatus.incrementCombo();
			this.hit = true;
			return true;
		}
		else{
			//TODO gui.displayMiss();
			PlayerStatus.setHp(-15);
			PlayerStatus.setFever(-1000);
			PlayerStatus.resetCombo();
			return false;
		}
	}

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	@Override
	public boolean isActivated() {
		// TODO Auto-generated method stub
		return Math.abs(this.buttonDownTime - Timeline.instance.getTime())==120;
	}

}
