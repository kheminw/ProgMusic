package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.Main;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import logic.MainLogic;

public class SelectSongScreen extends Pane {

	private Canvas canvas;
	private GraphicsContext gc;
	private Font song = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 40);
	private Font f = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 16);
	private Font r = Font.loadFont(new FileInputStream(new File("./res/SanFranciscoText-Regular.otf")), 20);
	private static int currentSong = 1;

	public SelectSongScreen() throws FileNotFoundException {
		currentSong = 1;
		Image image = RenderableHolder.bg[4];
		// new BackgroundSize(width, height, widthAsPercentage,
		// heightAsPercentage, contain, cover)
		BackgroundSize backgroundSize = new BackgroundSize(800, 470, true, true, true, true);
		// new BackgroundImage(image, repeatX, repeatY, position, size)
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		// new Background(images...)
		Background background = new Background(backgroundImage);
		this.setBackground(background);

		this.canvas = new Canvas(800, 470);
		gc = canvas.getGraphicsContext2D();
		Rectangle open = new Rectangle(800, 470, Color.BLACK);
		DropShadow ds = new DropShadow();
		ds.setOffsetX(2.0f);
		ds.setOffsetY(2.0f);
		ds.setColor(Color.YELLOW);
		
		
		FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), open);
		fadeTransition.setFromValue(1.0f);
		fadeTransition.setToValue(0.3f);
		fadeTransition.play();

		Line splitW = new Line(-200, 0, 200, 0);
		splitW.setLayoutX(400);
		splitW.setLayoutY(235);
		splitW.setRotate(90);
		splitW.setStroke(Color.WHITE);
		FadeTransition fadeTransitionLine1 = new FadeTransition(Duration.millis(3000), splitW);
		fadeTransitionLine1.setFromValue(0f);
		fadeTransitionLine1.setToValue(1f);
		fadeTransitionLine1.play();

		Line split = new Line(-100, 0, 200, 0);
		split.setLayoutX(150);
		split.setLayoutY(200);
		split.setStroke(Color.WHITE);
		FadeTransition fadeTransitionLine2 = new FadeTransition(Duration.millis(3000), split);
		fadeTransitionLine2.setFromValue(0f);
		fadeTransitionLine2.setToValue(1f);
		fadeTransitionLine2.play();

		Text firstSong = new Text(190, 75, "L");
		firstSong.setFont(song);
		firstSong.setFill(Color.WHITE);
		firstSong.setEffect(ds);
		FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(3000), firstSong);
		fadeTransition1.setFromValue(0f);
		fadeTransition1.setToValue(1f);
		fadeTransition1.play();

		Text secondSong = new Text(140, 150, "ANiMA");
		secondSong.setFont(song);
		secondSong.setFill(Color.WHITE);
		FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(3000), secondSong);
		fadeTransition2.setFromValue(0f);
		fadeTransition2.setToValue(1f);
		fadeTransition2.play();

		Text scoreLabel = new Text(180, 240, "Score");
		scoreLabel.setFont(f);
		scoreLabel.setFill(Color.WHITE);
		FadeTransition ftscoreLabel = new FadeTransition(Duration.millis(3000), scoreLabel);
		ftscoreLabel.setFromValue(0f);
		ftscoreLabel.setToValue(1f);
		ftscoreLabel.play();

		Text score = new Text(115, 300, "0000000");
		score.setFont(song);
		score.setFill(Color.WHITE);
		FadeTransition fadeTransitionScore = new FadeTransition(Duration.millis(3000), score);
		fadeTransitionScore.setFromValue(0f);
		fadeTransitionScore.setToValue(1f);
		fadeTransitionScore.play();

		Text scorePercent = new Text(175, 340, "00.00%");
		scorePercent.setFont(f);
		scorePercent.setFill(Color.WHITE);
		FadeTransition ftscorePercent = new FadeTransition(Duration.millis(3000), scorePercent);
		ftscorePercent.setFromValue(0f);
		ftscorePercent.setToValue(1f);
		ftscorePercent.play();

		Text perfect = new Text(70, 390, "Perfect");
		perfect.setFont(f);
		perfect.setFill(Color.LIME);
		FadeTransition ftperfect = new FadeTransition(Duration.millis(3000), perfect);
		ftperfect.setFromValue(0f);
		ftperfect.setToValue(1f);
		ftperfect.play();

		Text perfectNote = new Text(80, 430, "000");
		perfectNote.setFont(f);
		perfectNote.setFill(Color.LIME);
		FadeTransition ftperfectNote = new FadeTransition(Duration.millis(3000), perfectNote);
		ftperfectNote.setFromValue(0f);
		ftperfectNote.setToValue(1f);
		ftperfectNote.play();

		Text good = new Text(180, 390, "Good");
		good.setFont(f);
		good.setFill(Color.YELLOW);
		FadeTransition ftgood = new FadeTransition(Duration.millis(3000), good);
		ftgood.setFromValue(0f);
		ftgood.setToValue(1f);
		ftgood.play();
		Text goodNote = new Text(185, 430, "000");
		goodNote.setFont(f);
		goodNote.setFill(Color.YELLOW);
		FadeTransition ftgoodNote = new FadeTransition(Duration.millis(3000), goodNote);
		ftgoodNote.setFromValue(0f);
		ftgoodNote.setToValue(1f);
		ftgoodNote.play();

		Text miss = new Text(270, 390, "Miss");
		miss.setFont(f);
		miss.setFill(Color.RED);
		FadeTransition ftmiss = new FadeTransition(Duration.millis(3000), miss);
		ftmiss.setFromValue(0f);
		ftmiss.setToValue(1f);
		ftmiss.play();

		Text missNote = new Text(272, 430, "000");
		missNote.setFont(f);
		missNote.setFill(Color.RED);
		FadeTransition ftmissNote = new FadeTransition(Duration.millis(3000), missNote);
		ftmissNote.setFromValue(0f);
		ftmissNote.setToValue(1f);
		ftmissNote.play();

		Text bpm = new Text(500, 230, "BPM : 155");
		bpm.setFont(r);
		bpm.setFill(Color.WHITE);
		FadeTransition ftbpm = new FadeTransition(Duration.millis(3000), bpm);
		ftbpm.setFromValue(0f);
		ftbpm.setToValue(1f);
		ftbpm.play();

		Text artist = new Text(540, 290, "Artist : Ice");
		artist.setFont(r);
		artist.setFill(Color.WHITE);
		FadeTransition ftscore = new FadeTransition(Duration.millis(3000), artist);
		ftscore.setFromValue(0f);
		ftscore.setToValue(1f);
		ftscore.play();

		Text totalNote = new Text(600, 350, "Total Note : 2000");
		totalNote.setFont(r);
		totalNote.setFill(Color.WHITE);
		FadeTransition ftnote = new FadeTransition(Duration.millis(3000), totalNote);
		ftnote.setFromValue(0f);
		ftnote.setToValue(1f);
		ftnote.play();
		
		ImageView next = new ImageView(RenderableHolder.bg[5]);
		next.setLayoutX(700);
		next.setLayoutY(400);
		next.setFitWidth(50);
		next.setFitHeight(50);
		FadeTransition ftnext = new FadeTransition(Duration.millis(3000), next);
		ftnext.setFromValue(0f);
		ftnext.setToValue(1f);
		ftnext.play();
		ImageView back = new ImageView(RenderableHolder.bg[6]);
		back.setLayoutX(450);
		back.setLayoutY(400);
		back.setFitWidth(50);
		back.setFitHeight(50);
		FadeTransition ftback = new FadeTransition(Duration.millis(3000), back);
		ftback.setFromValue(0f);
		ftback.setToValue(1f);
		ftback.play();
		DropShadow dsAlbum = new DropShadow(BlurType.THREE_PASS_BOX	, Color.BLACK, 10, 0, 0, 0);
		ds.setWidth(21);
		ds.setHeight(21);
		ImageView albumArt = new ImageView(RenderableHolder.albumArt[0]);
		albumArt.setLayoutX(500);
		albumArt.setLayoutY(40);
		albumArt.setFitWidth(200);
		albumArt.setFitHeight(150);
		albumArt.setEffect(dsAlbum);
		FadeTransition ftalbumArt = new FadeTransition(Duration.millis(3000), albumArt);
		ftalbumArt.setFromValue(0f);
		ftalbumArt.setToValue(1f);
		ftalbumArt.play();
		
		next.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				MainLogic.instance.switchScreen("GameScreen");
			}
		});
		
		back.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				MainLogic.instance.switchScreen("MenuScreen");
				
			}
		});
		firstSong.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				firstSong.setEffect(ds);
			}
		});

		firstSong.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if (currentSong == 1) {
					firstSong.setEffect(ds);
				} else {
					firstSong.setEffect(null);
				}
			}
		});

		firstSong.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				firstSong.setEffect(ds);
				secondSong.setEffect(null);
				
				if(currentSong == 2){
					ParallelTransition out = new ParallelTransition();
					
					FadeTransition ftAlbum = new FadeTransition(Duration.millis(1500), albumArt);
					ftAlbum.setFromValue(1.0f);
					ftAlbum.setToValue(0f);
					ftAlbum.setAutoReverse(true);
					
					FadeTransition ftbpmOut = new FadeTransition(Duration.millis(1500), bpm);
					ftbpmOut.setFromValue(1.0f);
					ftbpmOut.setToValue(0f);
					ftbpmOut.setAutoReverse(true);
					TranslateTransition ttbpmOut = new TranslateTransition(Duration.millis(1000), bpm);
					ttbpmOut.setFromX(0);
					ttbpmOut.setToX(350);
					ttbpmOut.setAutoReverse(true);

					FadeTransition ftartistOut = new FadeTransition(Duration.millis(1500), artist);
					ftartistOut.setFromValue(1.0f);
					ftartistOut.setToValue(0f);
					TranslateTransition ttartistOut = new TranslateTransition(Duration.millis(1000), artist);
					ttartistOut.setFromX(0);
					ttartistOut.setToX(300);
					
					FadeTransition fttotalNoteOut = new FadeTransition(Duration.millis(1500), totalNote);
					fttotalNoteOut.setFromValue(1.0f);
					fttotalNoteOut.setToValue(0f);
					fttotalNoteOut.setAutoReverse(true);
					TranslateTransition tttotalNoteOut = new TranslateTransition(Duration.millis(1000), totalNote);
					tttotalNoteOut.setFromX(0);
					tttotalNoteOut.setToX(250);
					tttotalNoteOut.setAutoReverse(true);
					out.getChildren().addAll(ftbpmOut,ttbpmOut,ftartistOut,ttartistOut,fttotalNoteOut,tttotalNoteOut,ftAlbum);
					
					ParallelTransition in = new ParallelTransition();
					
					FadeTransition ftAlbumIn = new FadeTransition(Duration.millis(1500), albumArt);
					ftAlbumIn.setFromValue(0f);
					ftAlbumIn.setToValue(1f);
					ftAlbumIn.setAutoReverse(true);
					
					FadeTransition ftbpmIn = new FadeTransition(Duration.millis(1500), bpm);
					ftbpmIn.setFromValue(0f);
					ftbpmIn.setToValue(1f);
					ftbpmIn.setAutoReverse(true);
					TranslateTransition ttbpmIn = new TranslateTransition(Duration.millis(1000), bpm);
					ttbpmIn.setFromX(350);
					ttbpmIn.setToX(0);
					ttbpmIn.setAutoReverse(true);

					FadeTransition ftartistIn = new FadeTransition(Duration.millis(1500), artist);
					ftartistIn.setFromValue(0f);
					ftartistIn.setToValue(1f);
					ftartistIn.setAutoReverse(true);
					TranslateTransition ttartistIn = new TranslateTransition(Duration.millis(1000), artist);
					ttartistIn.setFromX(300);
					ttartistIn.setToX(0);
					ttartistIn.setAutoReverse(true);

					FadeTransition fttotalNoteIn = new FadeTransition(Duration.millis(1500), totalNote);
					fttotalNoteIn.setFromValue(0f);
					fttotalNoteIn.setToValue(1f);
					fttotalNoteIn.setAutoReverse(true);
					TranslateTransition tttotalNoteIn = new TranslateTransition(Duration.millis(1000), totalNote);
					tttotalNoteIn.setFromX(250);
					tttotalNoteIn.setToX(0);
					tttotalNoteIn.setAutoReverse(true);
					in.getChildren().addAll(ftbpmIn,ttbpmIn,ftartistIn,ttartistIn,fttotalNoteIn,tttotalNoteIn,ftAlbumIn);
					SequentialTransition seqT = new SequentialTransition (out,in);
				    out.setOnFinished(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							bpm.setText("BPM : 155");
							artist.setText("Artist : Ice");
							totalNote.setText("Total Note: 2000");
							albumArt.setImage(RenderableHolder.albumArt[0]);
						}
					});
					seqT.play();
					
				}
				MainLogic.instance.getMp().stop();
				MainLogic.instance.setMedia(RenderableHolder.previewSong[0]);
				MainLogic.instance.setSong(MainLogic.instance.getMedia());
				MainLogic.instance.getMp().play();
				MainLogic.instance.getMp().setVolume(MainLogic.instance.getVolume());
				MainLogic.instance.getMp().setCycleCount(MediaPlayer.INDEFINITE);
				currentSong = 1;
			}
		});

		secondSong.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				secondSong.setEffect(ds);
			}
		});

		secondSong.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
				if (currentSong == 2) {
					secondSong.setEffect(ds);
				} else {
					secondSong.setEffect(null);
				}
			}
		});

		secondSong.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				secondSong.setEffect(ds);
				firstSong.setEffect(null);
				if(currentSong == 1){
					ParallelTransition out = new ParallelTransition();
					
					FadeTransition ftAlbumOut = new FadeTransition(Duration.millis(1500), albumArt);
					ftAlbumOut.setFromValue(1.0f);
					ftAlbumOut.setToValue(0f);
					ftAlbumOut.setAutoReverse(true);
					
					FadeTransition ftbpmOut = new FadeTransition(Duration.millis(1500), bpm);
					ftbpmOut.setFromValue(1.0f);
					ftbpmOut.setToValue(0f);
					ftbpmOut.setAutoReverse(true);
					TranslateTransition ttbpmOut = new TranslateTransition(Duration.millis(1000), bpm);
					ttbpmOut.setFromX(0);
					ttbpmOut.setToX(350);
					ttbpmOut.setAutoReverse(true);

					ParallelTransition ptartistOut = new ParallelTransition();
					FadeTransition ftartistOut = new FadeTransition(Duration.millis(1500), artist);
					ftartistOut.setFromValue(1.0f);
					ftartistOut.setToValue(0f);
					TranslateTransition ttartistOut = new TranslateTransition(Duration.millis(1000), artist);
					ttartistOut.setFromX(0);
					ttartistOut.setToX(300);
					
					ParallelTransition pttotalNoteOut = new ParallelTransition();
					FadeTransition fttotalNoteOut = new FadeTransition(Duration.millis(1500), totalNote);
					fttotalNoteOut.setFromValue(1.0f);
					fttotalNoteOut.setToValue(0f);
					fttotalNoteOut.setAutoReverse(true);
					TranslateTransition tttotalNoteOut = new TranslateTransition(Duration.millis(1000), totalNote);
					tttotalNoteOut.setFromX(0);
					tttotalNoteOut.setToX(250);
					tttotalNoteOut.setAutoReverse(true);
					out.getChildren().addAll(ftbpmOut,ttbpmOut,ftartistOut,ttartistOut,fttotalNoteOut,tttotalNoteOut,ftAlbumOut);
					
					ParallelTransition in = new ParallelTransition();
					
					FadeTransition ftAlbumIn = new FadeTransition(Duration.millis(1500), albumArt);
					ftAlbumIn.setFromValue(0f);
					ftAlbumIn.setToValue(1f);
					ftAlbumIn.setAutoReverse(true);

					FadeTransition ftbpmIn = new FadeTransition(Duration.millis(1500), bpm);
					ftbpmIn.setFromValue(0f);
					ftbpmIn.setToValue(1f);
					ftbpmIn.setAutoReverse(true);
					TranslateTransition ttbpmIn = new TranslateTransition(Duration.millis(1000), bpm);
					ttbpmIn.setFromX(350);
					ttbpmIn.setToX(0);
					ttbpmIn.setAutoReverse(true);

					FadeTransition ftartistIn = new FadeTransition(Duration.millis(1500), artist);
					ftartistIn.setFromValue(0f);
					ftartistIn.setToValue(1f);
					ftartistIn.setAutoReverse(true);
					TranslateTransition ttartistIn = new TranslateTransition(Duration.millis(1000), artist);
					ttartistIn.setFromX(300);
					ttartistIn.setToX(0);
					ttartistIn.setAutoReverse(true);

					FadeTransition fttotalNoteIn = new FadeTransition(Duration.millis(1500), totalNote);
					fttotalNoteIn.setFromValue(0f);
					fttotalNoteIn.setToValue(1f);
					fttotalNoteIn.setAutoReverse(true);
					TranslateTransition tttotalNoteIn = new TranslateTransition(Duration.millis(1000), totalNote);
					tttotalNoteIn.setFromX(250);
					tttotalNoteIn.setToX(0);
					tttotalNoteIn.setAutoReverse(true);
					in.getChildren().addAll(ftbpmIn,ttbpmIn,ftartistIn,ttartistIn,fttotalNoteIn,tttotalNoteIn,ftAlbumIn);
					SequentialTransition seqT = new SequentialTransition (out,in);
				    out.setOnFinished(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							bpm.setText("BPM : 200");
							artist.setText("Artist : Xi");
							totalNote.setText("Total Note: 2000");
							albumArt.setImage(RenderableHolder.albumArt[1]);
							MainLogic.instance.getMp().stop();
							MainLogic.instance.setMedia(RenderableHolder.previewSong[1]);
							MainLogic.instance.setSong(MainLogic.instance.getMedia());
							MainLogic.instance.getMp().play();
							MainLogic.instance.getMp().setVolume(MainLogic.instance.getVolume());
							MainLogic.instance.getMp().setCycleCount(MediaPlayer.INDEFINITE);
						}
					});
					seqT.play();
					
				}
				
				currentSong = 2;
			}
		});

		this.getChildren().addAll(canvas, open, splitW, split, firstSong, secondSong, scorePercent, score, scoreLabel,
				perfect, good, miss, perfectNote, goodNote, missNote, bpm, artist, totalNote,albumArt,next,back);

	}
	public static int getCurrentSong(){
		return currentSong-1;
	}
}
