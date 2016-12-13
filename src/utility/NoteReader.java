package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NoteReader {
	public static final InputStream L_NOTE = ClassLoader.getSystemResourceAsStream("L.txt");
	public static final InputStream ANiMA_NOTE = ClassLoader.getSystemResourceAsStream("ANiMA.txt");
	public static List<String[]> noteCollection = new ArrayList<String[]>();
	public NoteReader() {
		// TODO Auto-generated constructor stub
	}
	public static void readNote(String songName){
		noteCollection.clear();
		if(songName.equals("L")){
			try(BufferedReader br = new BufferedReader(new InputStreamReader(L_NOTE))){
				String currentLine;
				while((currentLine = br.readLine()) != null){
					if(currentLine.isEmpty()) continue;
					String[] splitStr = new String[2];
					splitStr = Utility.pySplit(currentLine);
					noteCollection.add(splitStr);
				}
			}
			catch (IndexOutOfBoundsException e1){
				System.out.println("Error while reading note: L");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(songName.equals("ANiMA")){
			try(BufferedReader br = new BufferedReader(new InputStreamReader(ANiMA_NOTE))){
				String currentLine;
				while((currentLine = br.readLine()) != null){
					if(currentLine.isEmpty()) continue;
					String[] splitStr = new String[2];
					splitStr = Utility.pySplit(currentLine);
					noteCollection.add(splitStr);
				}
			}
			catch (IndexOutOfBoundsException e1){
				System.out.println("Error while reading note: ANiMA");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
