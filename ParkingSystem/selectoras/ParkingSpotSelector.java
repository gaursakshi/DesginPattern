package ParkingSystem.selectoras;
import ParkingSystem.data.ParkingSpot;

import  java.util.List;

public interface ParkingSpotSelector {

    ParkingSpot selectSpot(List<ParkingSpot>availableParkingSpotList);
}
