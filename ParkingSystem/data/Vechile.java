package ParkingSystem.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vechile {

    private  final int vechileNumber;

    private  final VechileType vechileType;

    private  final String model;

    private final LocalDateTime entryTime;

    public Vechile(int vechileNumber, VechileType vechileType, String model) {
        this.vechileNumber = vechileNumber;
        this.vechileType = vechileType;
        this.model = model;
        this.entryTime = LocalDateTime.now();
    }

    public int getVechileNumber() {
        return vechileNumber;
    }

    public VechileType getVechileType() {
        return vechileType;
    }

    public String getModel() {
        return model;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
