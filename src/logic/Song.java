package logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Song {
	
	private Map<Long, List<GameButton>> notes = new HashMap<Long, List<GameButton>>();
	private long totalTime;
	private String title;
	private String artist;
	private Image albumArt;
	private Media song;
	private int highScore = 0;
	
	public Song() {
		//default constructor
		//setters should be used to set values (especially notes)
		this.totalTime = 0;
		this.title = "";
		this.artist = "";
		this.albumArt = null;
		this.song = null;
	}
	
	public Song(long totalTime, String title, String artist, Image albumArt, Media song){
		this.totalTime = totalTime;
		this.title = title;
		this.artist = artist;
		this.albumArt = albumArt;
		this.song = song;
	}

	public int getTotalNotes(){
		return notes.size();
	}
	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Image getAlbumArt() {
		return albumArt;
	}

	public void setAlbumArt(Image albumArt) {
		this.albumArt = albumArt;
	}

	public Media getSong() {
		return song;
	}

	public void setSong(Media song) {
		this.song = song;
	}
	
	public void addNotes(long time, List<GameButton> notes){
		this.notes.put(time, notes);
	}
	
	public void setNotes(Map<Long, List<GameButton>> notes){
		this.notes = notes;
	}
	
	public void setHighScore(int highScore){
		this.highScore = highScore;
	}
	public int getHighScore(){
		return this.highScore;
	}
	public void play(){
		//TODO throws NullNotesException, NoMusicException, ImageErrorException
		MediaPlayer player = new MediaPlayer(song);
		player.play();
		//TODO draw notes
	}
}
