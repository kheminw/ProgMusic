package logic;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Song {
	
	private ArrayList<GameButton> notes = new ArrayList<GameButton>();
	private long totalTime;
	private int stars;
	private String title;
	private String artist;
	private Image albumArt;
	private AudioClip song;
	private int highScore = 0;
	
	public Song() {
		//default constructor
		//setters should be used to set values (especially notes)
		this.totalTime = 0;
		this.stars = 0;
		this.title = "";
		this.artist = "";
		this.albumArt = null;
		this.song = null;
	}
	
	public Song(long totalTime, int stars, String title, String artist, Image albumArt, AudioClip song){
		this.totalTime = totalTime;
		this.stars = stars;
		this.title = title;
		this.artist = artist;
		this.albumArt = albumArt;
		this.song = song;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
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

	public AudioClip getSong() {
		return song;
	}

	public void setSong(AudioClip song) {
		this.song = song;
	}
	
	public void addNotes(GameButton note){
		this.notes.add(note);
	}
	
	public void setNotes(ArrayList<GameButton> notes){
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
		this.song.play();
		//TODO draw notes
	}
}
