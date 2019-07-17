package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Room {

    private Item itemGroup[];
    private Sprite sprites[];
    private Wall walls[];
    private int RoomNo;
    private Dimension Size;
    private Coordinate Position;
    private int fcount = 0;
    private int scount = 0;
    private int wcount = 0;
    private Image image;

    public Room(int num, String img){
        RoomNo = num;
        itemGroup = new Item[3];
        sprites = new Sprite[1];
        walls = new Wall[4];
        image = new Image(img);
        Position = new Coordinate(0,0);
        Size = new Dimension(400,450);

    }

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int roomNo) {
        RoomNo = roomNo;
    }

    public Dimension getSize() {
        return Size;
    }

    public void setSize(Dimension size) {
        Size = size;
    }

    public Coordinate getPosition() {
        return Position;
    }

    public void setPosition(Coordinate position) {
        Position = position;
    }

    public int getFcount() {
        return fcount;
    }

    public int getScount() {
        return scount;
    }

    public int getWcount() {
        return wcount;
    }

    public void addFurniture(Item i){
        itemGroup[fcount++] = i;
    }

    public void addSprite(Sprite s){
        sprites[scount++] = s;
    }

    public void addWall(Wall w) {
        walls[wcount++] = w;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Rectangle[] getBounds(){
        Rectangle bounds[] = new Rectangle[7];
        int rcount = 0;
        for(Item i: itemGroup){
            bounds[rcount++] = i.getBoundary();
        }
        for(Wall w: walls) {
            bounds[rcount++] = w.getBoundary();
        }
        return bounds;
    }

    public void drawRoom(GraphicsContext gc) {
        gc.drawImage(this.getImage(), this.getPosition().getX(),this.getPosition().getY(), this.getSize().getWidth(),this.getSize().getHeight());
        for (Item i: itemGroup) {
            i.drawItem(gc);
        }
        for (Sprite s: sprites){
            s.drawSprite(gc);
        }
    }
}
