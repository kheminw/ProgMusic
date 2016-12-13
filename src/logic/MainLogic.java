package logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import GUI.GameScreen;
import GUI.MenuScreen;
import GUI.RenderableHolder;
import GUI.SelectSongScreen;
import GUI.SettingScreen;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainLogic {
	public final static MainLogic instance = new MainLogic();
	private MenuScreen menu;
	private GameScreen game;
	private SettingScreen setting;
	private SelectSongScreen select;
	private Scene main;
	private List<Song> songSet = new ArrayList<Song>();
	private Media media;
	private MediaPlayer mp;
	private int i;
	private double volume;
	private double opacity;
	private Song L;
	private Song ANiMA;
	public MainLogic() {
		Random r = new Random();
		i = r.nextInt(2);
		media = RenderableHolder.song[i];
		mp = new MediaPlayer(media);
		mp.play();
		mp.setCycleCount(MediaPlayer.INDEFINITE);
			try {
				menu = new MenuScreen();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		main = new Scene(menu, 800, 470);
		MediaPlayer song0LengthFinder = new MediaPlayer(RenderableHolder.song[0]);
		song0LengthFinder.setOnReady(new Runnable(){
			@Override
			public void run(){
				L = new Song((long) RenderableHolder.song[0].getDuration().toMillis(), "L", "Ice",
						RenderableHolder.albumArt[0], RenderableHolder.song[0]);
				Map<Long, List<GameButton>> notes = new HashMap<Long, List<GameButton>>();
				utility.NoteReader.parseNote("L", notes);
				L.setNotes(notes);
				songSet.add(L);
			}
		});
		MediaPlayer song1LengthFinder = new MediaPlayer(RenderableHolder.song[1]);
		song1LengthFinder.setOnReady(new Runnable(){
			@Override
			public void run(){
				ANiMA = new Song((long) RenderableHolder.song[1].getDuration().toMillis(), "ANiMA", "xi",
						RenderableHolder.albumArt[1], RenderableHolder.song[1]);
				Map<Long, List<GameButton>> notes = new HashMap<Long, List<GameButton>>();
				utility.NoteReader.parseNote("ANiMA", notes);
				ANiMA.setNotes(notes);
				songSet.add(ANiMA);
			}
		});
		try {
			setting = new SettingScreen();
			select = new SelectSongScreen();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		volume = setting.getSoundBar().getValue()/100;
		opacity = setting.getOpacityBar().getValue()/100;
	}


	public Scene getCurrentScreen() {
		return main;
	}

	public void switchScreen(String screenName) {
		this.mp.stop();
		volume = setting.getSoundBar().getValue()/100;

		opacity = setting.getOpacityBar().getValue()/100;
		this.mp.setVolume(volume);
		if (screenName.equals("MenuScreen")) {
			try {
				menu = new MenuScreen();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menu.setOpacity(opacity);
			main.setRoot(menu);
			media = RenderableHolder.song[i];
			mp = new MediaPlayer(media);
			this.mp.play();
			mp.setVolume(volume);
		} else if (screenName.equals("SettingScreen")) {
			try {
				setting = new SettingScreen();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(opacity);
			setting.setOpacity(opacity);
			main.setRoot(setting);
			media = RenderableHolder.song[i];
			mp = new MediaPlayer(media);
			//mp.setCycleCount(MediaPlayer.INDEFINITE);
			this.mp.play();
			mp.setVolume(volume);


		} else if (screenName.equals("SelectSongScreen")) {
			try {
				select = new SelectSongScreen();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			select.setOpacity(opacity);
			main.setRoot(select);
			this.media = RenderableHolder.previewSong[0];
			mp = new MediaPlayer(media);
			mp.play();
			mp.setVolume(volume);


		} else if (screenName.equals("GameScreen")) {
			this.mp.stop();
			game = new GameScreen();
			game.setOpacity(opacity);
			main.setRoot(game);
			media = RenderableHolder.song[SelectSongScreen.getCurrentSong()];
			mp = new MediaPlayer(media);
			this.mp.play();
			mp.setVolume(volume);			
			GameManager.drawService.start();
			GameManager.hitService.start();
			GameManager.timer.start();

		}
	}
	public GameScreen getGameScreen(){
		return game;
	}
	public SettingScreen getSetting(){
		return setting;
	}
	public double getOpacity(){
		return opacity;
	}
	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public MediaPlayer getMp() {
		return mp;
	}

	public void setSong(Media m) {
		this.mp = new MediaPlayer(m);
	}
	public double getVolume(){
		return volume;
	}
	public void setVolume(double volume){
		this.volume = volume;
	}
	public void setOpacity(double opacity){
		this.opacity = opacity;
	}
	public List<Song> getSongSet(){
		return songSet;
	}
}
