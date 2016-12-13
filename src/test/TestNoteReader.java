package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logic.GameButton;
import logic.HoldButton;
import logic.TapButton;
import utility.NoteReader;
import utility.Utility;

public class TestNoteReader {

	public TestNoteReader() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Map<Long, List<GameButton>> notes = new HashMap<Long, List<GameButton>>();
		NoteReader.parseNote("L", notes);
	}
}
