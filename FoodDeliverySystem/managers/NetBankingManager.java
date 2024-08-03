package FoodDeliverySystem.managers;

import FoodDeliverySystem.data.PaymentResponse;

public class NetBankingManager implements PaymentManager{

    private final String bankName;

    private final String cardHolderName;

    private final double payment;

    private final String passWord;
    private final String pin;

    public NetBankingManager(String bankName, String cardHolderName, double payment, String passWord, String pin) {
        this.bankName = bankName;
        this.cardHolderName = cardHolderName;
        this.payment = payment;
        this.passWord = passWord;
        this.pin = pin;
    }
    @Override
    public PaymentResponse executePayment() {
        return null;
    }
}
