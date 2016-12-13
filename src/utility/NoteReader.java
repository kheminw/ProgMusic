package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logic.GameButton;
import logic.HoldButton;
import logic.TapButton;

public class NoteReader {
	public static final InputStream L_NOTE = ClassLoader.getSystemResourceAsStream("L.txt");
	public static final InputStream ANiMA_NOTE = ClassLoader.getSystemResourceAsStream("ANiMA.txt");
	public static final InputStream L_LONG_NOTE = ClassLoader.getSystemResourceAsStream("Llong.txt");
	public static final InputStream ANiMA_LONG_NOTE = ClassLoader.getSystemResourceAsStream("ANiMAlong.txt");
	public static List<long[]> noteCollection = new ArrayList<long[]>();
	public static List<long[]> longNoteCollection = new ArrayList<long[]>();
	public NoteReader() {
		// TODO Auto-generated constructor stub
	}
	public static List<long[]> readNote(String songName){
		noteCollection.clear();
		longNoteCollection.clear();
		if(songName.equals("L")){
			try(BufferedReader br = new BufferedReader(new InputStreamReader(L_NOTE))){
				String currentLine;
				while((currentLine = br.readLine()) != null){
					if(currentLine.isEmpty()) continue;
					String[] splitStr = new String[2];
					splitStr = Utility.pySplit(currentLine);
					long[] splitLong = new long[2];
					splitLong = Arrays.stream(splitStr).mapToLong(a ->Long.parseLong(a)).toArray();
					noteCollection.add(splitLong);
				}
			}
			catch (IndexOutOfBoundsException e1){
				System.out.println("Error while reading note: L");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try(BufferedReader br = new BufferedReader(new InputStreamReader(L_LONG_NOTE))){
				String currentLine;
				while((currentLine = br.readLine()) != null){
					if(currentLine.isEmpty()) continue;
					String[] splitStr = new String[3];
					splitStr = Utility.pySplit(currentLine);
					long[] splitLong = new long[3];
					splitLong = Arrays.stream(splitStr).mapToLong(a ->Long.parseLong(a)).toArray();
					longNoteCollection.add(splitLong);
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
					long[] splitLong = new long[2];
					splitLong = Arrays.stream(splitStr).mapToLong(a ->Long.parseLong(a)).toArray();
					noteCollection.add(splitLong);
				}
			}
			catch (IndexOutOfBoundsException e1){
				System.out.println("Error while reading note: ANiMA");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try(BufferedReader br = new BufferedReader(new InputStreamReader(ANiMA_LONG_NOTE))){
				String currentLine;
				while((currentLine = br.readLine()) != null){
					if(currentLine.isEmpty()) continue;
					String[] splitStr = new String[3];
					splitStr = Utility.pySplit(currentLine);
					long[] splitLong = new long[3];
					splitLong = Arrays.stream(splitStr).mapToLong(a ->Long.parseLong(a)).toArray();
					longNoteCollection.add(splitLong);
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
		return noteCollection;
	}
	public static void parseNote(String songName, Map<Long, List<GameButton>> notes){
		utility.NoteReader.readNote(songName);
		for (long[] result : NoteReader.noteCollection) {
			if (!notes.containsKey(result[0])) {
				notes.put(result[0], new ArrayList<GameButton>() {
					{
						add(new TapButton((int) result[0], (int) result[1]));
					}
				});
			}
			else if (notes.containsKey(result[0])) {
				List<GameButton> current = notes.get(result[0]);
				current.add(new TapButton((int) result[0], (int) result[1]));
				notes.put(result[0], current);
			}
		}
		for (long[] result : NoteReader.longNoteCollection) {
			if (!notes.containsKey(result[0])) {
				notes.put(result[0], new ArrayList<GameButton>() {
					{
						add(new HoldButton((int) result[0], (int) result[1], (int) result[2]));
					}
				});
			}
			else if (notes.containsKey(result[0])) {
				List<GameButton> current = notes.get(result[0]);
				current.add(new HoldButton((int) result[0], (int) result[1], (int) result[2]));
				notes.put(result[0], current);
			}
		}
		for(long key: notes.keySet()){
			System.out.println(notes.get(key));
		}
	}
}
