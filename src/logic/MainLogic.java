package logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import GUI.GameScreen;
import GUI.MenuScreen;
import GUI.RenderableHolder;
import GUI.SelectSongScreen;
import GUI.SettingScreen;
import javafx.scene.Scene;

public class MainLogic {
	public final static MainLogic instance = new MainLogic();
	private MenuScreen menu;
	private GameScreen game;
	private SettingScreen setting;
	private SelectSongScreen select;
	private Scene main;
	private List<Song> songSet;
	public MainLogic() {
		// TODO Auto-generated constructor stub
		
		try {
			menu = new MenuScreen();
			setting = new SettingScreen();
			select = new SelectSongScreen();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game = new GameScreen();
		main = new Scene(menu, 800, 470);
		Song L = new Song((long)RenderableHolder.song[0].getDuration().toMillis(), "L", "Ice", 
				RenderableHolder.albumArt[0], RenderableHolder.song[0]);
		Song ANiMA = new Song((long)RenderableHolder.song[1].getDuration().toMillis(), "ANiMA", "xi", 
				RenderableHolder.albumArt[1], RenderableHolder.song[1]);
		songSet = new ArrayList<Song>();
		songSet.add(L);
		songSet.add(ANiMA);
	}
	public Scene getCurrentScreen(){
		return main;
	}
	public void switchScreen(String screenName){
		if(screenName.equals("MenuScreen")){
			main.setRoot(menu);
		}
		else if(screenName.equals("SettingScreen")){
			main.setRoot(setting);
		}
		else if(screenName.equals("SelectSongScreen")){
			main.setRoot(select);
		}
		else if(screenName.equals("GameScreen")){
			main.setRoot(game);
		}
	}
}
