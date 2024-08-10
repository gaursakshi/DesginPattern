package ParkingSystem.payment;

import ParkingSystem.Manager.VehicleTypeManager;
import ParkingSystem.Manager.VehicleTypeManagerFactory;
import ParkingSystem.data.Ticket;

import java.time.LocalDateTime;

public class ParkingFeeProcessor {



    public double getParkingAmount(Ticket ticket) {
        VehicleTypeManager vehicleTypeManager = VehicleTypeManagerFactory.getVehicleTypeManager(ticket.getVechile().getVechileType());
        LocalDateTime localDateTime = LocalDateTime.now();
        int currentTime = localDateTime.getHour();
        int totalDurationSpentByTheVechile = ticket.getVechile().getEntryTime().getHour();
       return vehicleTypeManager.getParkingFees(totalDurationSpentByTheVechile - currentTime);
    }

    public boolean processFees(Ticket ticket,PaymentProcessor paymentProcessor) {
        if(getParkingAmount(ticket)!= paymentProcessor.getAmount()){
            //if the fees doesn't match
            throw new RuntimeException("parking fees does not match");
        }
        return paymentProcessor.executePayment();
    }


}
