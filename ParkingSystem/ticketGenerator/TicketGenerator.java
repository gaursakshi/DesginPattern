package ParkingSystem.ticketGenerator;

import ParkingSystem.data.ParkingSpot;
import ParkingSystem.data.Ticket;
import ParkingSystem.data.Vechile;

import java.time.LocalDateTime;
import java.util.UUID;

public class TicketGenerator {

    public synchronized Ticket generateTicket(Vechile vechile, ParkingSpot parkingSpot) {
        int ticketId = getTicketRefernce();

        // Create a new Ticket object with the given vehicle, parking spot, issue time, and ticket ID
        //make a cll to the database as if the  spot is still available or not
        //there is a possibilty that in beetween the spot would have taken by someone

        // Record the current time as the ticket issue time
        LocalDateTime issueTime = LocalDateTime.now();

        if (parkingSpot.isFree()) {

            return new Ticket(ticketId, vechile, issueTime, parkingSpot);
        } else {
            throw new RuntimeException("Parking spot is not available");
        }
    }

    private int getTicketRefernce() {
        return Integer.parseInt(UUID.randomUUID().toString());
    }
}
