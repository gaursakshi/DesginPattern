package ParkingSystem.APIS;


import ParkingSystem.Manager.VehicleTypeManager;
import ParkingSystem.Manager.VehicleTypeManagerFactory;
import ParkingSystem.data.EntryPoint;
import ParkingSystem.data.ParkingSpot;
import ParkingSystem.data.SpotSelection;
import ParkingSystem.data.VechileType;
import ParkingSystem.finder.ParkingSpotFinder;
import ParkingSystem.selectoras.ParkingSpotSelector;
import ParkingSystem.selectoras.SpotSelectionFactory;


public class FindParkingSpotAPI {

    public ParkingSpot findParkingSpot(EntryPoint entryPoint, VechileType vehicleType, SpotSelection spotSelection) {

        VehicleTypeManager vehicleTypeManager = VehicleTypeManagerFactory.getVehicleTypeManager(vehicleType);

        ParkingSpotSelector parkingSpotSelector = SpotSelectionFactory.getSpotSelection(spotSelection,entryPoint);

        return new ParkingSpotFinder(parkingSpotSelector, vehicleTypeManager).findParkingSpot();
    }
}
