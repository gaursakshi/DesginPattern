package ParkingSystem.APIS;


import ParkingSystem.Manager.VehicleTypeManager;
import ParkingSystem.Manager.VehicleTypeManagerFactory;
import ParkingSystem.data.Ticket;
import ParkingSystem.payment.ParkingFeeProcessor;

public class GetParkingFeeAPI {

    public double getParkingFee(Ticket ticket){
        if(ticket == null ){
            throw new NullPointerException("Ticket is null");
        }
        return new ParkingFeeProcessor().getParkingAmount(ticket);
    }
}
