package utility;

public class InvalidDirectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3096303096854777977L;

	public InvalidDirectionException() {
		// TODO Auto-generated constructor stub
		System.out.println("Invalid note direction: Directions must be 1-3 only");
	}


}
