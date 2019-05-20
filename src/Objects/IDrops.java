package Objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public interface IDrops {
    public ImageView getImage();
    public ImageView getHalfImage();
    public ImageView getSecHalfImage();
    public boolean isSlice();
    public void setSlice(boolean slice);
    public void setX(int x);
    public void setY(int y);
    public int setX();
    public int setY();
}
