package GUI;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

// TODO: Auto-generated Javadoc
/**
 * The Class RenderableHolder.
 */
public class RenderableHolder {
	
	/** The entities. */
	private List<IRenderable> entities;
	
	/** The bg. */
	public static Image[] bg;
	
	/** The note. */
	public static Image[] note;
	
	/** The album art. */
	public static Image[] albumArt;
	
	/** The song. */
	public static Media[] song;
	
	/** The preview song. */
	public static Media[] previewSong;
	
	/** The Constant instance. */
	final static RenderableHolder instance = new RenderableHolder();
	
	/**
	 * Instantiates a new renderable holder.
	 */
	public RenderableHolder(){
		entities = new ArrayList<>();
		bg = new Image[7];
		albumArt = new Image[2];
		song = new Media[2];
		previewSong = new Media[2];
	}
	
	static{
		loadResource();
	}
	
	/**
	 * Adds the.
	 *
	 * @param entity the entity
	 */
	public synchronized void add(IRenderable entity){
		entities.add(entity);
	}
	
	/**
	 * Load resource.
	 */
	private static void loadResource(){
		bg[0] = new Image(ClassLoader.getSystemResource("Menu.jpg").toString());
		bg[1] = new Image(ClassLoader.getSystemResource("Prog-Music-2.png").toString());
		bg[2] = new Image(ClassLoader.getSystemResource("option-wallpaper.jpg").toString());
		bg[3] = new Image(ClassLoader.getSystemResource("GameScreen.jpeg").toString());
		bg[4] = new Image(ClassLoader.getSystemResource("SelectSong.jpg").toString());
		bg[5] = new Image(ClassLoader.getSystemResource("next.png").toString());
		bg[6] = new Image(ClassLoader.getSystemResource("back.png").toString());
		albumArt[0] = new Image(ClassLoader.getSystemResource("L.jpg").toString());
		albumArt[1] = new Image(ClassLoader.getSystemResource("ANiMA.jpg").toString());
		song[0] = new Media(ClassLoader.getSystemResource("L.mp3").toString());
		song[1] = new Media(ClassLoader.getSystemResource("ANiMA.mp3").toString());
		previewSong[0] = new Media(ClassLoader.getSystemResource("Lpreview.mp3").toString());
		previewSong[1] = new Media(ClassLoader.getSystemResource("ANiMApreview.mp3").toString());
	}
	
	/**
	 * Removes the.
	 *
	 * @param index the index
	 */
	public synchronized void remove(int index){
		instance.entities.remove(index);
		
	}

	/**
	 * Gets the single instance of RenderableHolder.
	 *
	 * @return single instance of RenderableHolder
	 */
	public synchronized static RenderableHolder getInstance() {
		return instance;
	}

	/**
	 * Gets the entities.
	 *
	 * @return the entities
	 */
	public synchronized List<IRenderable> getEntities() {
		return entities;
	}
}
