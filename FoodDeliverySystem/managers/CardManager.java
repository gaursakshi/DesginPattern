package FoodDeliverySystem.managers;

import FoodDeliverySystem.data.CardType;
import FoodDeliverySystem.data.PaymentResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CardManager implements PaymentManager {

    private final String bankName;

    private final int cvv;

    private final String cardNumber;

    private final String cardHolderName;

    private final LocalDate expiryDate;

    private final CardType cardType;

    private final double amount;

    public CardManager(String bankName, int cvv, String cardNumber, String cardHolderName,LocalDate expiryDate,CardType cardType,Double amount) {
        this.bankName = bankName;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cardType = cardType;
        this.amount  = amount;
    }

    @Override
    public PaymentResponse executePayment() {
        return null;
    }
}
