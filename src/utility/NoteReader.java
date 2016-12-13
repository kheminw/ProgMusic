package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NoteReader {
	public static final String L_NOTE = ClassLoader.getSystemResource("song1.txt").toString();
	public static final String ANiMA_NOTE = ClassLoader.getSystemResource("song2.txt").toString();
	public NoteReader() {
		// TODO Auto-generated constructor stub
	}
	public void readNote(String songName){
		
		if(songName.equals("L")){
			try(BufferedReader br = new BufferedReader(new FileReader(L_NOTE))){
				String currentLine;
				while((currentLine = br.readLine()) != null){
					String[] splitStr = new String[2];
					splitStr = Utility.pySplit(currentLine);
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
			try(BufferedReader br = new BufferedReader(new FileReader(ANiMA_NOTE))){
				String currentLine;
				while((currentLine = br.readLine()) != null){
					String[] splitStr = new String[2];
					splitStr = Utility.pySplit(currentLine);
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
