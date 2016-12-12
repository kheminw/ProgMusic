package GUI;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

public class RenderableHolder {
	private List<IRenderable> entities;
	public static Image[] bg;
	public static Image[] note;
	public static Image[] albumArt;
	public static Media[] song;
	final static RenderableHolder instance = new RenderableHolder();
	public RenderableHolder(){
		entities = new ArrayList<>();
		bg = new Image[5];
		albumArt = new Image[2];
		song = new Media[2];
	}
	
	static{
		loadResource();
	}
	
	public synchronized void add(IRenderable entity){
		entities.add(entity);
	}
	
	private static void loadResource(){
		bg[0] = new Image(ClassLoader.getSystemResource("Menu.jpg").toString());
		bg[1] = new Image(ClassLoader.getSystemResource("Prog-Music-2.png").toString());
		bg[2] = new Image(ClassLoader.getSystemResource("option-wallpaper.jpg").toString());
		bg[3] = new Image(ClassLoader.getSystemResource("GameScreen.jpeg").toString());
		bg[4] = new Image(ClassLoader.getSystemResource("SelectSong.jpg").toString());
		albumArt[0] = new Image(ClassLoader.getSystemResource("L.jpg").toString());
		albumArt[1] = new Image(ClassLoader.getSystemResource("ANiMA.jpg").toString());
		song[0] = new Media(ClassLoader.getSystemResource("L.mp3").toString());
		song[1] = new Media(ClassLoader.getSystemResource("ANiMA.mp3").toString());
	}
	
	public synchronized void remove(int index){
		instance.entities.remove(index);
		
	}

	public synchronized static RenderableHolder getInstance() {
		return instance;
	}

	public synchronized List<IRenderable> getEntities() {
		return entities;
	}
}
