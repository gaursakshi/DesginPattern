package ParkingSystem.Manager;

import ParkingSystem.data.ParkingSpot;

import java.util.List;

public class HeavyWheelManager  implements VehicleTypeManager{

    private final int parkinngCost = 100;
    @Override
    public List<ParkingSpot> getParkingSpots() {
        List<ParkingSpot> o = null;
       return null;
    }

    @Override
    public double getParkingFees(double durationInHours) {
        return parkinngCost * durationInHours;
    }
}
