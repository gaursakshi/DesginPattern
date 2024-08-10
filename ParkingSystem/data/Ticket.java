package ParkingSystem.data;

import java.time.LocalDateTime;

public class Ticket {

    private final int id;

    private final LocalDateTime ticketGeneratedTime;

    private final Vechile vechile;

    private final ParkingSpot parkingSpot;


    public Ticket(int id, Vechile vechile, LocalDateTime ticketGeneratedTime, ParkingSpot parkingSpot) {
        this.id = id;
        this.vechile = vechile;
        this.ticketGeneratedTime = ticketGeneratedTime;
        this.parkingSpot = parkingSpot;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTicketGeneratedTime() {
        return ticketGeneratedTime;
    }

    public Vechile getVechile() {
        return vechile;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
