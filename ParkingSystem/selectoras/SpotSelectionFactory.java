package ParkingSystem.selectoras;

import ParkingSystem.data.EntryPoint;
import ParkingSystem.data.SpotSelection;

public class SpotSelectionFactory {

    private SpotSelectionFactory() {

    }

    public static ParkingSpotSelector getSpotSelection(SpotSelection spotSelection, EntryPoint entryPoint) {
        ParkingSpotSelector parkingSpotSelector = null;
        if (spotSelection == SpotSelection.RANDOM) {
            parkingSpotSelector = new RandomSpotSelector();
        } else if (spotSelection == SpotSelection.NEAREST) {
            parkingSpotSelector = new NearestSpotSelector(entryPoint.getEntranceX(), entryPoint.getEntranceY());
        }
        return parkingSpotSelector;
    }
}
