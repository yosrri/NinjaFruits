package Sounds;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Track3 {
	private static Track3 alert;
	 public static Track3 getInstance() {
		 if(alert==null)	alert= new Track3();
		 return alert;
	 }
	 private MediaPlayer mediaPlayer;
		public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
		public Track3() {
		 String path = "/Users/ahmedtharwatwagdy/Documents/java/workspace/Fruit Ninja/src/track3.m4a";
			Media media = new Media(new File(path).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
//			mediaPlayer.setAutoPlay(true);
	 }
}
