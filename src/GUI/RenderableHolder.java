package GUI;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;


public class RenderableHolder {
	private List<IRenderable> entities;
	public static Image[] menuScreen;
	public static Image[] note;
	final static RenderableHolder instance = new RenderableHolder();
	public RenderableHolder(){
		entities = new ArrayList<>();
		menuScreen = new Image[4];
	}
	
	static{
		loadResource();
	}
	
	public synchronized void add(IRenderable entity){
		entities.add(entity);
	}
	
	private static void loadResource(){
		menuScreen[0] = new Image(ClassLoader.getSystemResource("Menu.jpg").toString());
		menuScreen[1] = new Image(ClassLoader.getSystemResource("Prog-Music-2.png").toString());

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
