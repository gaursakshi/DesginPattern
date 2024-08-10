package ParkingSystem.finder;

import ParkingSystem.Manager.VehicleTypeManager;
import ParkingSystem.data.ParkingSpot;
import ParkingSystem.selectoras.ParkingSpotSelector;

import java.util.List;

public class ParkingSpotFinder {
    private final ParkingSpotSelector parkingSpotSelector;
    private final VehicleTypeManager vehicleTypeManager;

    public ParkingSpotFinder(ParkingSpotSelector parkingSpotSelector, VehicleTypeManager vehicleTypeManager) {
        this.parkingSpotSelector = parkingSpotSelector;
        this.vehicleTypeManager = vehicleTypeManager;
    }

    public ParkingSpot findParkingSpot() {
        List<ParkingSpot> parkingSpotList = this.vehicleTypeManager.getParkingSpots();
        return this.parkingSpotSelector.selectSpot(parkingSpotList);

    }
}
