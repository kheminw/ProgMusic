package logic;

import GUI.IRenderable;

// TODO: Auto-generated Javadoc
/**
 * The Class GameButton.
 */
public abstract class GameButton implements Tappable, IRenderable {
	
	/** The spawn time. */
	protected long spawnTime;
	
	/** The score. */
	protected int score;
	
	/** The button down time. */
	protected long buttonDownTime = 0;
	
	/** The hit. */
	protected boolean hit;
	
	/** The destroyed. */
	protected boolean destroyed;
	
	/** The lane. */
	protected int lane;
	
	protected boolean isDrawn;
	
	/**
	 * Instantiates a new game button.
	 *
	 * @param timeInMillis the time in millis
	 * @param defaultScore the default score
	 * @param lane the lane
	 */
	public GameButton(int timeInMillis, int lane) {
		this.spawnTime = timeInMillis;
		this.score = 100;
		this.hit = false;
		this.destroyed = false;
		this.lane = lane;
		this.isDrawn = false;
	}
	
	/* (non-Javadoc)
	 * @see logic.Tappable#hit()
	 */
	//classes that inherit this class should also set the value of destroyed 
	abstract public void hit();
	
	/* (non-Javadoc)
	 * @see GUI.IRenderable#getZ()
	 */
	abstract public int getZ();
	
	/* (non-Javadoc)
	 * @see GUI.IRenderable#isVisible()
	 */
	abstract public boolean isVisible();
	
	/* (non-Javadoc)
	 * @see GUI.IRenderable#draw()
	 */
	abstract public void draw();
	
	/**
	 * Check grade.
	 *
	 * @return true, if successful
	 */
	public boolean checkGrade() {
		if(Math.abs(this.buttonDownTime - Timeline.instance.getTime()) <= GameManager.perfectDelay*PlayerStatus.getMode()){
			//TODO gui.displayPerfect();
			PlayerStatus.setScore(score);
			PlayerStatus.setHp(5);
			PlayerStatus.setFever(8);
			PlayerStatus.incrementCombo();
			this.hit = true;
			return true;
		}
		else if(Math.abs(this.buttonDownTime - Timeline.instance.getTime()) <= GameManager.goodDelay*PlayerStatus.getMode()){
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

	/* (non-Javadoc)
	 * @see logic.Tappable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	/* (non-Javadoc)
	 * @see logic.Tappable#isActivated()
	 */
	@Override
	public boolean isActivated() {
		// TODO Auto-generated method stub
		return Math.abs(this.buttonDownTime - Timeline.instance.getTime())<=GameManager.activationDelay;
	}
	@Override
	public String toString(){
		return "GameButton: "+"Lane: " +lane+" Time: "+spawnTime;
	}
	public boolean isDrawn(){
		return isDrawn;
	}
}
