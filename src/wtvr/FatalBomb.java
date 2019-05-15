package wtvr;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FatalBomb implements  IDrops{
    @Override
    public BufferedImage getImage() {
        BufferedImage img = null;


        File file =  new File("C:\\Users\\OMAR\\Desktop\\Images\\bomb1.png");
        try {
            img = ImageIO.read(file);
        } catch (IIOException e) {
            e.printStackTrace();
        }catch(IOException e) {

        }
        return img;
    }
}
