package wtvr;
import javafx.scene.image.Image;

public class Watermelon implements IDrops{
public Image getImage(){
	Image img = new Image("fruit"+2+".png");
	return img;
}
}
