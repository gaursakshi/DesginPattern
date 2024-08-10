package ParkingSystem.APIS;

import ParkingSystem.data.ParkingSpot;

public class VacateParkingSpotAPI {

    public void vacateParkingSpot(ParkingSpot parkingSpot) {
        if(parkingSpot == null) {
            System.out.println("Parking Spot is null");
            throw new IllegalArgumentException("Parking Spot is null");
        }


    }

}
