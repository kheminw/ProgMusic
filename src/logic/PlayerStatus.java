package logic;

public class PlayerStatus {
	private static int score = 0;
	private static int hp = 100;
	private static int fever = 0;
	private static boolean isGameOver = false;
	private static boolean isInFever = false;
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
	public static void initialize(){
		score = 0;
		fever = 0;
		hp = 0;
		isGameOver = false;
		isInFever = false;
	}
}