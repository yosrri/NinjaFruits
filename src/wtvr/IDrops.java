package wtvr;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public interface IDrops {
    public ImageView getImage();
    public boolean isSlice();
    public void setSlice(boolean slice);
}
