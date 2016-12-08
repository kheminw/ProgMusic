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
<<<<<<< HEAD
		if(score >= 1000000) score = 1000000;
=======
		if(PlayerStatus.score >= 1000000) PlayerStatus.score = 1000000;
>>>>>>> master
	}
	public static int getHp() {
		return hp;
	}
	public static void setHp(int hp) {
		PlayerStatus.hp += hp;
<<<<<<< HEAD
		if(hp > 100) hp = 100;
		else if(hp <= 0){
			hp = 0;
=======
		if(PlayerStatus.hp > 100) PlayerStatus.hp = 100;
		else if(PlayerStatus.hp <= 0){
			PlayerStatus.hp = 0;
>>>>>>> master
			isGameOver = true;
		}
	}
	public static int getFever() {
		return fever;
	}
	public static void setFever(int fever) {
		PlayerStatus.fever += fever;
<<<<<<< HEAD
		if(fever >= 100){
			fever = 100;
=======
		if(PlayerStatus.fever >= 100){
			PlayerStatus.fever = 100;
			isInFever = true;
		}
		else if(PlayerStatus.fever <= 0){
			PlayerStatus.fever = 0;
			isInFever = false;
>>>>>>> master
		}
	}
	public static void toggleFever(){
		isInFever = !isInFever;
	}
<<<<<<< HEAD
	public static boolean getInFever(){
=======
	public static boolean isInFever(){
>>>>>>> master
		return isInFever;
	}
	public static boolean isGameOver(){
		return isGameOver;
	}
<<<<<<< HEAD
}
=======
	public static void initialize(){
		score = 0;
		fever = 0;
		hp = 0;
		isGameOver = false;
		isInFever = false;
	}
}
>>>>>>> master
