package ParkingSystem.Manager;


import ParkingSystem.data.VechileType;

public class VehicleTypeManagerFactory {

    private VehicleTypeManagerFactory(){}

    public static VehicleTypeManager getVehicleTypeManager(VechileType vechileType) {
        VehicleTypeManager vehicleTypeManager = null;

        if (vechileType == VechileType.FOUR_WHEELER) {
            vehicleTypeManager = new FourWheelManager();
        } else if (vechileType == VechileType.HEAVY) {
            vehicleTypeManager = new HeavyWheelManager();
        } else if (vechileType == VechileType.TWO_WHEELER) {
            vehicleTypeManager = new TwoWheelManager();
        }
        return vehicleTypeManager;

    }
}
