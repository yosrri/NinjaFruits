package Objects;

import java.awt.image.BufferedImage;

public class Fruits implements GameObject {


    @Override
    public Enum getObjectType() {
        return null;
    }

    @Override
    public int getXlocation() {
        return 0;
    }

    @Override
    public int getYlocation() {
        return 0;
    }

    @Override
    public Boolean isSliced() {
        return null;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return null;
    }

    @Override
    public void slice() {

    }

    @Override
    public void move(double time) {

    }

    @Override
    public BufferedImage[] getBufferedImages() {
        return new BufferedImage[0];
    }
}
