package ParkingSystem.data;

import CarRentalSystem.enums.VechileType;

public class ParkingSpot {

    private  final int floor;

    private  final String name;

    private final VechileType vechileType;

    private final boolean isFree;

    private final int postionX;

    private  final int positionY;

    public ParkingSpot(int floor, String name, VechileType vechileType, boolean isFree, int positionY, int postionX) {
        this.floor = floor;
        this.name = name;
        this.vechileType = vechileType;
        this.isFree = isFree;
        this.positionY = positionY;
        this.postionX = postionX;
    }

    public int getFloor() {
        return floor;
    }

    public String getName() {
        return name;
    }

    public VechileType getVechileType() {
        return vechileType;
    }

    public int getPostionX() {
        return postionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean isFree() {
        return isFree;
    }

}
