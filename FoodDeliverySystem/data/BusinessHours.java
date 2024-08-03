package FoodDeliverySystem.data;

import java.time.LocalDateTime;

public class BusinessHours {

    private final LocalDateTime openingTime;

    private final LocalDateTime closingTime;

    public BusinessHours(LocalDateTime startTime, LocalDateTime endTime) {
        this.closingTime = endTime;
        this.openingTime = startTime;
    }

    public LocalDateTime getOpeningTime() {
        return this.openingTime;
    }

    public LocalDateTime getClosingTime() {
        return this.closingTime;
    }

}
