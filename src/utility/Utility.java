package utility;

public class Utility {

	public Utility() {
		// TODO Auto-generated constructor stub
	}
	private static final String[] EMPTY = {};

    public static String[] pySplit(String s) {
        s = s.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
        if (s.isEmpty()) return EMPTY;
        return s.split("\\s+");
    }
}
