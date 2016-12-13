package utility;

// TODO: Auto-generated Javadoc
/**
 * The Class Utility.
 */
public class Utility {

	/**
	 * Instantiates a new utility.
	 */
	public Utility() {
		// TODO Auto-generated constructor stub
	}
	
	/** The Constant EMPTY. */
	private static final String[] EMPTY = {};

    /**
     * Py split.
     *
     * @param s the s
     * @return the string[]
     */
    public static String[] pySplit(String s) {
        s = s.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
        if (s.isEmpty()) return EMPTY;
        return s.split("\\s+");
    }
}
