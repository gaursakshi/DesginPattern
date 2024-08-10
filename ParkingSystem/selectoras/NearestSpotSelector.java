package ParkingSystem.selectoras;

import ParkingSystem.data.ParkingSpot;

import java.util.List;

public class NearestSpotSelector implements ParkingSpotSelector {
    private int entranceX;
    private int entranceY;

    public NearestSpotSelector(int entranceX, int entranceY) {
        this.entranceX = entranceX;
        this.entranceY = entranceY;
    }

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> availableParkingSpotList) {

        if (availableParkingSpotList == null || availableParkingSpotList.isEmpty()) {
            throw new IllegalArgumentException("No parking spots available");
        }

        ParkingSpot nearestSpot = null;
        double minDistance = Double.MAX_VALUE;
        for (ParkingSpot p : availableParkingSpotList) {
            double distance = calculateDistance(p.getPositionY(), p.getPositionY());
            if (distance < minDistance) {
                minDistance = distance;
                nearestSpot = p;
            }
        }
        return nearestSpot;
    }

    private double calculateDistance(int x, int y) {
        // Euclidean distance formula
        return Math.sqrt(Math.pow(x - entranceX, 2) + Math.pow(y - entranceY, 2));
    }
}
