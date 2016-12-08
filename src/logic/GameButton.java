package logic;

public abstract class GameButton implements Tappable {
	
<<<<<<< HEAD
	private long spawnTime;
	private int score;
	private long buttonDownTime = 0;
	private boolean hit;
	private boolean destroyed;
	
	public GameButton(int timeInMillis, int defaultScore) {
=======
	protected long spawnTime;
	protected int score;
	protected long buttonDownTime = 0;
	protected boolean hit;
	protected boolean destroyed;
	protected int lane;
	
	public GameButton(int timeInMillis, int defaultScore, int lane) {
>>>>>>> master
		this.spawnTime = timeInMillis;
		this.score = defaultScore;
		this.hit = false;
		this.destroyed = false;
<<<<<<< HEAD
=======
		this.lane = lane;
>>>>>>> master
	}
	
	//classes that inherit this class should also set the value of destroyed 
	abstract public void hit();
	
	public boolean checkGrade() {
		if(Math.abs(this.buttonDownTime - Timeline.instance.getTime()) == 25){
			//TODO gui.displayPerfect();
			PlayerStatus.setScore(score);
<<<<<<< HEAD
=======
			PlayerStatus.setHp(5);
			PlayerStatus.setFever(8);
>>>>>>> master
			this.hit = true;
			return true;
		}
		else if(Math.abs(this.buttonDownTime - Timeline.instance.getTime()) == 50){
			//TODO gui.displayGood();
			PlayerStatus.setScore(score);
<<<<<<< HEAD
=======
			PlayerStatus.setHp(3);
			PlayerStatus.setFever(5);
>>>>>>> master
			this.hit = true;
			return true;
		}
		else{
			//TODO gui.displayMiss();
<<<<<<< HEAD
=======
			PlayerStatus.setHp(-15);
			PlayerStatus.setFever(-1000);
>>>>>>> master
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
