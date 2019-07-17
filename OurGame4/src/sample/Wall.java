package sample;

import javafx.scene.shape.Rectangle;

public class Wall {
    private Rectangle boundary;
    private Coordinate Position;
    private Dimension Size;

    public Wall(double x, double y, double width, double height){
        boundary = new Rectangle(x, y, width, height);
        Position = new Coordinate((int) Math.round(x), (int) Math.round(y));
        Size = new Dimension((int) Math.round(width), (int) Math.round(height));
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    public void setBoundary(Rectangle boundary) {
        this.boundary = boundary;
    }

    public Coordinate getPosition() {
        return Position;
    }

    public void setPosition(Coordinate position) {
        Position = position;
    }

    public Dimension getSize() {
        return Size;
    }

    public void setSize(Dimension size) {
        Size = size;
    }
}
