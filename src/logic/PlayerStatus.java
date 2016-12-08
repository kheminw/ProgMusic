package logic;

public class PlayerStatus {
	private static int score = 0;
	private static int hp = 100;
	private static int fever = 0;
	private static boolean isGameOver = false;
	private static boolean isInFever = false;
	private static boolean isPause = false;
	private static int combo = 0;
	private static int maxCombo = 0;
	public PlayerStatus() {
		// TODO Auto-generated constructor stub
	}
	public static int getScore() {
		return score;
	}
	public static void setScore(int score) {
		PlayerStatus.score += score;
		if(PlayerStatus.score >= 1000000) PlayerStatus.score = 1000000;
	}
	public static int getHp() {
		return hp;
	}
	public static void setHp(int hp) {
		PlayerStatus.hp += hp;
		if(PlayerStatus.hp > 100) PlayerStatus.hp = 100;
		else if(PlayerStatus.hp <= 0){
			PlayerStatus.hp = 0;
			isGameOver = true;
		}
	}
	public static int getFever() {
		return fever;
	}
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
	public static void toggleFever(){
		isInFever = !isInFever;
	}
	public static boolean isInFever(){
		return isInFever;
	}
	public static boolean isGameOver(){
		return isGameOver;
	}
	public static boolean isPause(){
		return isPause;
	}
	public static void togglePause(){
		isPause = !isPause;
	}
	public static int getCombo(){
		return combo;
	}
	public static int getMaxCombo(){
		return maxCombo;
	}
	public static void incrementCombo(){
		combo++;
		if(combo > maxCombo) maxCombo = combo;
	}
	public static void resetCombo(){
		combo = 0;
	}
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