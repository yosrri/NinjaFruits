package wtvr;

import javafx.scene.image.Image;


public class Apple extends Fruits implements IDrops  {
@Override
public Image getImage(){
	Image img = new Image("fruit"+1+".png");
	return img;
}
}
