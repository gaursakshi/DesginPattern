package ParkingSystem.payment;

import java.time.LocalDateTime;

public  class CardDetail {

    private final  String nameOnCard;
    private final  int pin;
    private final String cardNumber;
    private  final LocalDateTime expiryDate;

    public CardDetail(String nameOnCard, int pin, String cardNumber, LocalDateTime expiryDate) {
        this.nameOnCard = nameOnCard;
        this.pin = pin;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public int getPin() {
        return pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }
}