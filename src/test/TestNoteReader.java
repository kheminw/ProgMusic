package test;

import utility.NoteReader;
import utility.Utility;

public class TestNoteReader {

	public TestNoteReader() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		utility.NoteReader.readNote("ANiMA");
		for(String[] result: NoteReader.noteCollection){
			System.out.println("Result: " + result[0] + " " + result[1]);
		}
	}
}
