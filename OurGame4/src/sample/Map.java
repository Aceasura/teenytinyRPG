package sample;

import javafx.scene.canvas.GraphicsContext;

public class Map {

    private Room RoomGroup[];
    private int rcount = 0;

    public Map(Room room) {
        RoomGroup = new Room[1];
        AddRoom(room);
    }

    public void AddRoom(Room room) {
        RoomGroup[rcount++] = room;
    }

    public Room getRoom(int i){
        return RoomGroup[i];
    }

    public Room searchRoom(int num) {
        for (Room r : RoomGroup) {
            System.out.println(r.getRoomNo());
            if (r.getRoomNo() == num) {
                return r;
            }

        }
        return null;
    }

    public void drawMap(GraphicsContext gc, int i) {
        RoomGroup[i].drawRoom(gc);
    }
}
