package wtvr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;


public class Bomb  implements IDrops{

	public   BufferedImage getImage()   {


		BufferedImage img = null;

		File file =  new File("C:\\Users\\OMAR\\Desktop\\Images\\bomb0.png");
	try {
			img = ImageIO.read(file);
		} catch (IIOException e) {
			e.printStackTrace();
		}catch(IOException e) {
			
		}
		return img;

	}
}
