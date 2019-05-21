package Sounds;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Track1 {
private static Track1 slice;
public static Track1 getInstance() {
	if(slice==null)	slice= new Track1();
	return slice;
}
private MediaPlayer mediaPlayer;
public MediaPlayer getMediaPlayer() {
return mediaPlayer;
}
	public Track1() {
	String path = "C:/Users/OMAR/Desktop/Images/track2.m4a";
	Media media = new Media(new File(path).toURI().toString());
	mediaPlayer = new MediaPlayer(media);
//	mediaPlayer.setAutoPlay(true);
}
}
