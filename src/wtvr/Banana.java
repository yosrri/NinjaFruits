package wtvr;

import javafx.scene.image.Image;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Banana implements IDrops{

	@Override
	public BufferedImage getImage(){
		BufferedImage img = null;


			File file =  new File("E:\\Fruitnin\\src\\fruit0.png");
			try {
				img = ImageIO.read(file);
			} catch (IIOException e) {
				e.printStackTrace();
			}catch(IOException e) {

			}

			return img;
	}

}
