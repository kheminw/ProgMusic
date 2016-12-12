package utility;

public class InvalidLengthException extends Exception {

	private static final long serialVersionUID = 8128853755987882986L;

	public InvalidLengthException() {
		// TODO Auto-generated constructor stub
		System.out.println("Length Exception: length must be 2000, 1000 or 500");
	}

}
