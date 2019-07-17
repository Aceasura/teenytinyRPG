package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

import static javafx.scene.input.KeyCode.K;

public class Sprite {

    private Coordinate Position;
    private Dimension Size;
    private Rectangle boundary;
    private int dx;
    private int dy;
    private Image image;
    private Image imageF;
    private Image imageB;
    private Image imageL;
    private Image imageR;

    public Sprite(String f, String b, String l, String r) {
        imageF = new Image(f);
        imageB = new Image(b);
        imageL = new Image(l);
        imageR = new Image(r);
        image = imageF;
        Position = new Coordinate(0,0);
        Size = new Dimension(image);
        boundary = new Rectangle(Position.getX(), Position.getY(), Size.getWidth(), Size.getHeight());
    }

    public Sprite(String f, String b, String l, String r, Coordinate Position) {
        imageF = new Image(f);
        imageB = new Image(b);
        imageL = new Image(l);
        imageR = new Image(r);
        image = imageF;
        this.Position = Position;
        Size = new Dimension(image);
        boundary = new Rectangle(Position.getX(), Position.getY(), Size.getWidth(), Size.getHeight());

    }

    public Sprite(String f, String b, String l, String r, int x, int y) {
        imageF = new Image(f);
        imageB = new Image(b);
        imageL = new Image(l);
        imageR = new Image(r);
        image = imageF;
        Position = new Coordinate(x,y);
        Size = new Dimension(image);
        boundary = new Rectangle(Position.getX(), Position.getY(), Size.getWidth(), Size.getHeight());

    }

    public void move() {
        int x = Position.getX() + dx;
        int y = Position.getY() + dy;

        Position.setX(x);
        Position.setY(y);
        boundary.setX(x);
        boundary.setY(y);
    }

    public Coordinate getPosition() {
        return Position;
    }

    public void setPosition(Coordinate coordinate) {
        this.Position = coordinate;
    }

    public Dimension getSize() {
        return Size;
    }

    public void setSize(Dimension dimension) {
        this.Size = dimension;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Image getImageF() {
        return imageF;
    }

    public void setImageF(Image imageF) {
        this.imageF = imageF;
    }

    public Image getImageB() {
        return imageB;
    }

    public void setImageB(Image imageB) {
        this.imageB = imageB;
    }

    public Image getImageL() {
        return imageL;
    }

    public void setImageL(Image imageL) {
        this.imageL = imageL;
    }

    public Image getImageR() {
        return imageR;
    }

    public void setImageR(Image imageR) {
        this.imageR = imageR;
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    public void setBoundary(Rectangle boundary) {
        this.boundary = boundary;
    }

    public void keyPressed(KeyCode key) {

        if (key == KeyCode.LEFT) {
            dx = -4;
            dy = 0;
            image = imageL;
        }

        if (key == KeyCode.RIGHT) {
            dx = 4;
            dy = 0;
            image = imageR;
        }

        if (key == KeyCode.UP) {
            dx = 0;
            dy = -4;
            image = imageB;
        }

        if (key == KeyCode.DOWN) {
            dx= 0;
            dy = 4;
            image = imageF;
        }
    }

    public void stopMove(KeyCode key) {

        if (key == KeyCode.LEFT) {
            dx = 0;
        }

        if (key == KeyCode.RIGHT) {
            dx = 0;
        }

        if (key == KeyCode.UP) {
            dy = 0;
        }

        if (key == KeyCode.DOWN) {
            dy = 0;
        }
    }

    public void drawSprite(GraphicsContext gc) {
        gc.drawImage(image, Position.getX(), Position.getY());
    }

    public void drawBoundary(GraphicsContext gc) {
        gc.strokeRect(this.getPosition().getX(), this.getPosition().getY(), this.getBoundary().getWidth(), this.getBoundary().getHeight());
    }

    public boolean checkCollision(Rectangle r, KeyCode key){
        if(key == KeyCode.UP){
            if (r.intersects(this.boundary.getBoundsInLocal())){
                this.setPosition(new Coordinate((int) this.getBoundary().getX(),(int) this.getBoundary().getY() + 4));
                return true;
            }

        }
        if(key == KeyCode.DOWN){
            if (r.intersects(this.boundary.getBoundsInLocal())){
                this.setPosition(new Coordinate((int) this.getBoundary().getX(),(int) this.getBoundary().getY() - 4));
                return true;
            }
        }
        if(key == KeyCode.LEFT){
            if (r.intersects(this.boundary.getBoundsInLocal())){
                this.setPosition(new Coordinate((int) this.getBoundary().getX() + 4,(int) this.getBoundary().getY()));
                return true;
            }
        }
        if(key == KeyCode.RIGHT){
            if (r.intersects(this.boundary.getBoundsInLocal())){
                this.setPosition(new Coordinate((int) this.getBoundary().getX() - 4,(int) this.getBoundary().getY()));
                return true;
            }
        }
            return false;
    }
}