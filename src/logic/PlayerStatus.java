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
		if(score >= 1000000) score = 1000000;
	}
	public static int getHp() {
		return hp;
	}
	public static void setHp(int hp) {
		PlayerStatus.hp += hp;
		if(hp > 100) hp = 100;
		else if(hp <= 0){
			hp = 0;
			isGameOver = true;
		}
	}
	public static int getFever() {
		return fever;
	}
	public static void setFever(int fever) {
		PlayerStatus.fever += fever;
		if(fever >= 100){
			fever = 100;
		}
	}
	public static void toggleFever(){
		isInFever = !isInFever;
	}
	public static boolean getInFever(){
		return isInFever;
	}
	public static boolean isGameOver(){
		return isGameOver;
	}
}
