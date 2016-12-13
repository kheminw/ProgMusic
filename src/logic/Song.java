package logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// TODO: Auto-generated Javadoc
/**
 * The Class Song.
 */
public class Song {
	
	/** The notes. */
	private Map<Long, List<GameButton>> notes = new HashMap<Long, List<GameButton>>();
	
	/** The total time. */
	private long totalTime;
	
	/** The title. */
	private String title;
	
	/** The artist. */
	private String artist;
	
	/** The album art. */
	private Image albumArt;
	
	/** The song. */
	private Media song;
	
	/** The high score. */
	private int highScore = 0;
	
	/**
	 * Instantiates a new song.
	 */
	public Song() {
		//default constructor
		//setters should be used to set values (especially notes)
		this.totalTime = 0;
		this.title = "";
		this.artist = "";
		this.albumArt = null;
		this.song = null;
	}
	
	/**
	 * Instantiates a new song.
	 *
	 * @param totalTime the total time
	 * @param title the title
	 * @param artist the artist
	 * @param albumArt the album art
	 * @param song the song
	 */
	public Song(long totalTime, String title, String artist, Image albumArt, Media song){
		this.totalTime = totalTime;
		this.title = title;
		this.artist = artist;
		this.albumArt = albumArt;
		this.song = song;
	}

	/**
	 * Gets the total notes.
	 *
	 * @return the total notes
	 */
	public int getTotalNotes(){
		return notes.size();
	}
	
	/**
	 * Gets the total time.
	 *
	 * @return the total time
	 */
	public long getTotalTime() {
		return totalTime;
	}

	/**
	 * Sets the total time.
	 *
	 * @param totalTime the new total time
	 */
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the artist.
	 *
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sets the artist.
	 *
	 * @param artist the new artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Gets the album art.
	 *
	 * @return the album art
	 */
	public Image getAlbumArt() {
		return albumArt;
	}

	/**
	 * Sets the album art.
	 *
	 * @param albumArt the new album art
	 */
	public void setAlbumArt(Image albumArt) {
		this.albumArt = albumArt;
	}

	/**
	 * Gets the song.
	 *
	 * @return the song
	 */
	public Media getSong() {
		return song;
	}

	/**
	 * Sets the song.
	 *
	 * @param song the new song
	 */
	public void setSong(Media song) {
		this.song = song;
	}
	
	/**
	 * Adds the notes.
	 *
	 * @param note the note
	 */
	public void addNotes(long time, List<GameButton> notes){
		this.notes.put(time, notes);
	}
	
	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(Map<Long, List<GameButton>> notes){
		this.notes = notes;
	}
	
	public Map<Long, List<GameButton>> getNotes(){
		return notes;
	}
	/**
	 * Sets the high score.
	 *
	 * @param highScore the new high score
	 */
	public void setHighScore(int highScore){
		this.highScore = highScore;
	}
	
	/**
	 * Gets the high score.
	 *
	 * @return the high score
	 */
	public int getHighScore(){
		return this.highScore;
	}
	
	/**
	 * Play.
	 */
	public void play(){
		//TODO throws NullNotesException, NoMusicException, ImageErrorException
		MediaPlayer player = new MediaPlayer(song);
		player.play();
		//TODO draw notes
	}
}
