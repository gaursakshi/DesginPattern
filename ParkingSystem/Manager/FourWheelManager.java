package ParkingSystem.Manager;


import ParkingSystem.data.ParkingSpot;

import java.util.List;

public class FourWheelManager  implements VehicleTypeManager {

    private final int parkinngCost = 100;

    @Override
    public List<ParkingSpot> getParkingSpots() {
        return null;
    }

    @Override
    public double getParkingFees(double durationInHours) {
        return parkinngCost * durationInHours;
    }
}
