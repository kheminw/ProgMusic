package logic;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerStatus.
 */
public class PlayerStatus {
	
	/** The score. */
	private static int score = 0;
	
	/** The hp. */
	private static int hp = 100;
	
	/** The fever. */
	private static int fever = 0;
	
	/** The is game over. */
	private static boolean isGameOver = false;
	
	/** The is in fever. */
	private static boolean isInFever = false;
	
	/** The is pause. */
	private static boolean isPause = false;
	
	/** The combo. */
	private static int combo = 0;
	
	/** The max combo. */
	private static int maxCombo = 0;
	
	/** The current mode. */
	private static int currentMode = 2;
	
	/**
	 * Instantiates a new player status.
	 */
	public PlayerStatus() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public static int getScore() {
		return score;
	}
	
	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public static void setScore(int score) {
		PlayerStatus.score += score;
		if(PlayerStatus.score >= 1000000) PlayerStatus.score = 1000000;
	}
	
	/**
	 * Gets the hp.
	 *
	 * @return the hp
	 */
	public static int getHp() {
		return hp;
	}
	
	/**
	 * Sets the hp.
	 *
	 * @param hp the new hp
	 */
	public static void setHp(int hp) {
		PlayerStatus.hp += hp;
		if(PlayerStatus.hp > 100) PlayerStatus.hp = 100;
		else if(PlayerStatus.hp <= 0){
			PlayerStatus.hp = 0;
			isGameOver = true;
		}
	}
	
	/**
	 * Gets the fever.
	 *
	 * @return the fever
	 */
	public static int getFever() {
		return fever;
	}
	
	/**
	 * Sets the fever.
	 *
	 * @param fever the new fever
	 */
	public static void setFever(int fever) {
		PlayerStatus.fever += fever;
		if(PlayerStatus.fever >= 100){
			PlayerStatus.fever = 100;
			isInFever = true;
		}
		else if(PlayerStatus.fever <= 0){
			PlayerStatus.fever = 0;
			isInFever = false;
		}
	}
	
	/**
	 * Toggle fever.
	 */
	public static void toggleFever(){
		isInFever = !isInFever;
	}
	
	/**
	 * Checks if is in fever.
	 *
	 * @return true, if is in fever
	 */
	public static boolean isInFever(){
		return isInFever;
	}
	
	/**
	 * Checks if is game over.
	 *
	 * @return true, if is game over
	 */
	public static boolean isGameOver(){
		return isGameOver;
	}
	
	/**
	 * Checks if is pause.
	 *
	 * @return true, if is pause
	 */
	public static boolean isPause(){
		return isPause;
	}
	
	/**
	 * Toggle pause.
	 */
	public static void togglePause(){
		isPause = !isPause;
	}
	
	/**
	 * Gets the combo.
	 *
	 * @return the combo
	 */
	public static int getCombo(){
		return combo;
	}
	
	/**
	 * Gets the max combo.
	 *
	 * @return the max combo
	 */
	public static int getMaxCombo(){
		return maxCombo;
	}
	
	/**
	 * Increment combo.
	 */
	public static void incrementCombo(){
		combo++;
		if(combo > maxCombo) maxCombo = combo;
	}
	
	/**
	 * Reset combo.
	 */
	public static void resetCombo(){
		combo = 0;
	}
	
	/**
	 * Sets the mode.
	 *
	 * @param mode the new mode
	 */
	public static void setMode(int mode){
		currentMode = mode;
		if(mode < 1 || mode > 3) currentMode = 2;
	}
	
	/**
	 * Gets the mode.
	 *
	 * @return the mode
	 */
	public static float getMode(){
		switch(currentMode){
		case 1:
			return GameManager.easyModifier;
		case 2: 
			return 1f;
		case 3:
			return GameManager.hardModifier;
		default:
			setMode(2);
			return 1f;
		}
	}
	
	/**
	 * Initialize.
	 */
	public static void initialize(){
		score = 0;
		fever = 0;
		hp = 0;
		isGameOver = false;
		isInFever = false;
		resetCombo();
		maxCombo = 0;
		isPause = false;
	}
}