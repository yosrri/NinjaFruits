package wtvr;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Apple extends Fruits implements IDrops {


    private static Apple INSTANCE ;
    private boolean slice = false;

    private Apple() {

    }

    public static Apple getInstance() {
        if(INSTANCE==null)
            INSTANCE=new Apple();
        return INSTANCE;
    }

    @Override
    public boolean isSlice() {
        return slice;
    }

    public void setSlice(boolean slice) {
        this.slice = slice;
    }

    public int rand(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    @Override
    public ImageView getImage() {
        BufferedImage img = null;

        File file = new File("E:\\Fruitnin\\src\\fruit0.png");
        try {
            img = ImageIO.read(file);
        } catch (IIOException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
        ImageView dropImg = new ImageView(SwingFXUtils.toFXImage(
                img, null));
        dropImg.setFitHeight(70);
        dropImg.setFitWidth(70);
        dropImg.setLayoutX(rand(0, 400));
        return dropImg;

    }
}
