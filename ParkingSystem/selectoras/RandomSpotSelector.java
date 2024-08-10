package ParkingSystem.selectoras;

import ParkingSystem.data.ParkingSpot;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomSpotSelector implements ParkingSpotSelector {
    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> availableParkingSpotList) {
        if (Objects.isNull(availableParkingSpotList) || availableParkingSpotList.isEmpty()) {
            throw new IllegalArgumentException("No spots available");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(availableParkingSpotList.size());
        return availableParkingSpotList.get(randomIndex);
    }
}
