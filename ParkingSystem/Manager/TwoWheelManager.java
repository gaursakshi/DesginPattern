package ParkingSystem.Manager;

import ParkingSystem.data.ParkingSpot;

import java.util.List;

public class TwoWheelManager  implements VehicleTypeManager {

    private final int parkinngCost = 100;
    @Override
    public List<ParkingSpot> getParkingSpots() {
        //make the database call and check which spot are empty
        return null;
    }

    @Override
    public double getParkingFees(double durationInHours) {
        return parkinngCost * durationInHours;
    }
}
