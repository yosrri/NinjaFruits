package Sounds;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Track2 {
 private static Track2 alert;
 public static Track2 getInstance() {
	 if(alert==null)	alert= new Track2();
	 return alert;
 }
 private MediaPlayer mediaPlayer;
	public MediaPlayer getMediaPlayer() {
	return mediaPlayer;
}
	public Track2() {
	 String path = "/Users/ahmedtharwatwagdy/Documents/java/workspace/Fruit Ninja/src/track1.m4a";
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
//		mediaPlayer.setAutoPlay(true);
 }
}
