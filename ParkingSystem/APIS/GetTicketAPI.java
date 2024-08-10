package ParkingSystem.APIS;

import ParkingSystem.data.ParkingSpot;
import ParkingSystem.data.Ticket;
import ParkingSystem.data.Vechile;
import ParkingSystem.ticketGenerator.TicketGenerator;
public class GetTicketAPI {

    public Ticket getTicket(Vechile vechile, ParkingSpot parkingSpot) {
        if (vechile == null || parkingSpot == null) {
            throw new IllegalArgumentException("Vehicle and ParkingSpot cannot be null");
        }
        return new TicketGenerator().generateTicket(vechile, parkingSpot);
    }
}
