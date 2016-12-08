package logic;

public abstract class GameButton implements Tappable {
	
	private long spawnTime;
	private int score;
	private long buttonDownTime = 0;
	private boolean hit;
	private boolean destroyed;
	
	public GameButton(int timeInMillis, int defaultScore) {
		this.spawnTime = timeInMillis;
		this.score = defaultScore;
		this.hit = false;
		this.destroyed = false;
	}
	
	//classes that inherit this class should also set the value of destroyed 
	abstract public void hit();
	
	public boolean checkGrade() {
		if(Math.abs(this.buttonDownTime - Timeline.instance.getTime()) == 25){
			//TODO gui.displayPerfect();
			PlayerStatus.setScore(score);
			this.hit = true;
			return true;
		}
		else if(Math.abs(this.buttonDownTime - Timeline.instance.getTime()) == 50){
			//TODO gui.displayGood();
			PlayerStatus.setScore(score);
			this.hit = true;
			return true;
		}
		else{
			//TODO gui.displayMiss();
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
