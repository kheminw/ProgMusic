package logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
	private List<Song> songSet;
	private Media media;
	private MediaPlayer mp;
	private int i;


	public MainLogic() {
		// TODO Auto-generated constructor stub
		
		try {
			Random r = new Random();
			i = r.nextInt(2);
			media = RenderableHolder.song[i];
			mp = new MediaPlayer(media);
			mp.setCycleCount(MediaPlayer.INDEFINITE);
			mp.play();
			menu = new MenuScreen();
			setting = new SettingScreen();
			select = new SelectSongScreen();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		game = new GameScreen();
		main = new Scene(menu, 800, 470);
		Song L = new Song((long) RenderableHolder.song[0].getDuration().toMillis(), "L", "Ice",
				RenderableHolder.albumArt[0], RenderableHolder.song[0]);
		Song ANiMA = new Song((long) RenderableHolder.song[1].getDuration().toMillis(), "ANiMA", "xi",
				RenderableHolder.albumArt[1], RenderableHolder.song[1]);
		songSet = new ArrayList<Song>();
		songSet.add(L);
		songSet.add(ANiMA);
	}


	public Scene getCurrentScreen() {
		return main;
	}

	public void switchScreen(String screenName) {
		this.mp.stop();
		if (screenName.equals("MenuScreen")) {
			main.setRoot(menu);
			media = RenderableHolder.song[i];
			mp = new MediaPlayer(media);
			this.mp.play();
		} else if (screenName.equals("SettingScreen")) {
			main.setRoot(setting);
			media = RenderableHolder.song[i];
			mp = new MediaPlayer(media);
			//mp.setCycleCount(MediaPlayer.INDEFINITE);

			this.mp.play();
		} else if (screenName.equals("SelectSongScreen")) {
			main.setRoot(select);
			this.media = RenderableHolder.getInstance().previewSong[0];
			mp = new MediaPlayer(media);
			mp.play();
		} else if (screenName.equals("GameScreen")) {
			main.setRoot(game);
			media = RenderableHolder.song[i];
			mp = new MediaPlayer(media);
			this.mp.play();
		}
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
}
