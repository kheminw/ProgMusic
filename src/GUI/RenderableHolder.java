package GUI;

import java.util.ArrayList;
import java.util.List;


import javafx.scene.image.Image;


public class RenderableHolder {
	private List<IRenderable> entities;
	public static Image[] bg;
	public static Image[] note;
	final static RenderableHolder instance = new RenderableHolder();
	public RenderableHolder(){
		entities = new ArrayList<>();
		bg = new Image[4];
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
