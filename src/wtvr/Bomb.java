package wtvr;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Bomb implements IDrops {
    private static  Bomb INSTANCE ;
    private boolean slice = false;

    private Bomb() {}


    public static Bomb getInstance() {
        if(INSTANCE==null)
            INSTANCE=new Bomb();
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

        File file = new File("/Users/ahmedtharwatwagdy/Documents/java/workspace/Fruit Ninja/src/bomb0.png");
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
        dropImg.setLayoutX(rand(0, 900));
        return dropImg;
    }
    public ImageView getHalfImage() {
        BufferedImage img = null;

        File file = new File("/Users/ahmedtharwatwagdy/Documents/java/workspace/Fruit Ninja/src/fruit1S.png");
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
        dropImg.setLayoutX(rand(0, 700));
        return dropImg;

    }
}
