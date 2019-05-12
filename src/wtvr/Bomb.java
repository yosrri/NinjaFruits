package wtvr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;


public class Bomb {
	public   BufferedImage[] getImage()   {
		BufferedImage[] arr = new BufferedImage[5];

		BufferedImage img = null;
		for(int i=0;i<2;i++) {			
		File file =  new File("C:\\Java Programs\\Yosri\\src\\bomb"+(i)+".png");
	try {
			img = ImageIO.read(file);
		} catch (IIOException e) {
			e.printStackTrace();
		}catch(IOException e) {
			
		}

		arr[i] = img;
}
		return arr;
	
	}


}
