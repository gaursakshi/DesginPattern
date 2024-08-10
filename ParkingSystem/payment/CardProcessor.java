package ParkingSystem.payment;

import java.time.LocalDateTime;

public class CardProcessor  implements PaymentProcessor {

    private final double amount;

    private final CardDetail cardDetail;

    public CardProcessor(double amount, CardDetail cardDetail) {
        this.amount = amount;
        this.cardDetail = cardDetail;
    }

    @Override
    public boolean executePayment() {

        if (isCardValid(cardDetail)) {
            // Simulate payment processing (e.g., call to a payment gateway)
            System.out.println("Processing payment of " + amount + " using card " + cardDetail.getCardNumber());
            return true; // Assume payment is successful
        } else {
            return false; // Payment failed
        }
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    private boolean isCardValid(CardDetail cardDetail) {
        // Simple validation check for card details (e.g., check if card is expired)
        // This is a mock validation. You can expand it as needed.
        return cardDetail != null && cardDetail.getExpiryDate().isAfter(LocalDateTime.now());
    }
}



