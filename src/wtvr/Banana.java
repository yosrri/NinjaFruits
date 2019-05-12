package wtvr;

import javafx.scene.image.Image;


public class Banana implements IDrops{

	@Override
	public Image getImage(){
		Image img = new Image("fruit"+0+".png");
		return img;
	}

}
