package sample;

import javafx.scene.image.Image;

public class Dimension {

    private int width;
    private int height;

    public Dimension(int w, int h) {
        width = w;
        height = h;
    }

    public Dimension(Image img) {
        width = (int) Math.round(img.getWidth());
        height = (int) Math.round(img.getHeight());
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
