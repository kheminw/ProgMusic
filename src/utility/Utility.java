package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

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
	 * @param s
	 *            the s
	 * @return the string[]
	 */
	public static String[] pySplit(String s) {
		s = s.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
		if (s.isEmpty())
			return EMPTY;
		return s.split("\\s+");
	}

	public static void writeScore(int highScore, String name) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(name+"highscore"+".txt"))) {

			String content = Integer.toString(highScore);

			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	public static int readScore(String name){
//		final InputStream L = ClassLoader.getSystemResourceAsStream("Lhighscore.txt");
//		final InputStream ANiMA = ClassLoader.getSystemResourceAsStream("ANiMAhighscore.txt");
//		int highscore = 0;
//		if(name.equals("L")){
//			try(BufferedReader br = new BufferedReader(new InputStreamReader(L))){
//				String currentLine;
//				while((currentLine = br.readLine()) != null){
//					highscore = Integer.parseInt(currentLine);
//				}
//			}
//			catch (IndexOutOfBoundsException e1){
//				System.out.println("Error while reading note: L");
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		else if(name.equals("ANiMA")){
//			try(BufferedReader br = new BufferedReader(new InputStreamReader(ANiMA))){
//				String currentLine;
//				while((currentLine = br.readLine()) != null){
//					highscore = Integer.parseInt(currentLine);
//				}
//			}
//			catch (IndexOutOfBoundsException e1){
//				System.out.println("Error while reading note: L");
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		final String L = "Lhighscore.txt";
		final String ANiMA = "ANiMAhighscore.txt";
		int highScore = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(name+"highscore"+".txt"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				highScore = Integer.parseInt(sCurrentLine);
			}


			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return highScore;
	}
}
