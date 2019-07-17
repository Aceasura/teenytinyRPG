package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item {

    private String Name;
    public enum Type{
        FURNITURE, ITEM, NPC;
    };
    private Type type;
    private Coordinate Position;
    private Dimension Size;
    private boolean Passability;
    private Rectangle boundary;
    private Image image;
    private Text texts[];
    private int tcount;

    public Item(String n, Type t, int x, int y, int x1, int y1, int w, int h, String img, int tx) {
        Name = n;
        type = t;
        Position = new Coordinate(x, y);
        image = new Image(img);
        Size = new Dimension((int) Math.round(image.getWidth()), (int) Math.round(image.getHeight()));
        boundary = new Rectangle(x1, y1, w, h);
        Passability = false;
        texts = new Text[tx];
    }
    public Item(String n, Type t, int x, int y, int w1, int h1, int x1, int y1, int w, int h, String img, int tx) {
        Name = n;
        type = t;
        Position = new Coordinate(x, y);
        image = new Image(img);
        Size = new Dimension(w1, h1);
        boundary = new Rectangle(x1, y1, w, h);
        Passability = false;
        texts = new Text[tx];
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Coordinate getPosition() {
        return Position;
    }

    public void setPosition(Coordinate position) {
        Position = position;
    }

    public boolean getPassability() {
        return Passability;
    }

    public void setPassability(boolean passability) {
        Passability = passability;
    }

    public Dimension getSize(){
        return Size;
    }

    public void setSize(Dimension d){
        this.Size = d;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    public void setBoundary(Rectangle boundary) {
        this.boundary = boundary;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void addText(Text t) {
        texts[tcount++] = t;
    }

    public void drawItem(GraphicsContext gc) {
        gc.drawImage(this.getImage(), this.getPosition().getX(), this.getPosition().getY(), this.getSize().getWidth(), this.getSize().getHeight());
    }

    public void drawBoundary(GraphicsContext gc) {
        gc.setStroke(Color.RED);
        gc.strokeRect(this.getBoundary().getX(), this.getBoundary().getY(), this.getBoundary().getWidth(), this.getBoundary().getHeight());
    }
}
