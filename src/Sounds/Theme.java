package Sounds;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Theme {
private static Theme theme;
public static Theme getInstance() {
	if(theme==null)
		theme=new Theme();
	return theme;
};
private MediaPlayer mediaPlayer;
	public MediaPlayer getMediaPlayer() {
	return mediaPlayer;
}

	public Theme() {
	String path = "/Users/ahmedtharwatwagdy/Documents/java/workspace/Fruit Ninja/src/theme.mp3";
	Media media = new Media(new File(path).toURI().toString());
	mediaPlayer = new MediaPlayer(media);
//	mediaPlayer.setAutoPlay(true);	
}
}
