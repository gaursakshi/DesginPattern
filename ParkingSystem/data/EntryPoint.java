package ParkingSystem.data;

public class EntryPoint {

    private final String name;

    private final boolean isOpen;

    private final  int entranceX;
    private final int entranceY;



    EntryPoint(String name, boolean isOpen, int entranceX, int entranceY) {
        this.name = name;
        this.isOpen = isOpen;
        this.entranceX = entranceX;
        this.entranceY = entranceY;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public int getEntranceX() {
        return entranceX;
    }

    public int getEntranceY() {
        return entranceY;
    }
}
