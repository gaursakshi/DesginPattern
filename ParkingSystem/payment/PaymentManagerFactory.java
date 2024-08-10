package ParkingSystem.payment;

public class PaymentManagerFactory {

    private PaymentManagerFactory() {

    }

    public static PaymentProcessor getCardBasedPaymentProcessor(CardDetail cardDetail, double amount) {
        return new CardProcessor(amount, cardDetail);
    }

    public static  PaymentProcessor getCashBasedPaymentProcessor(double cashAmount) {
        return new CashProcessor(cashAmount);

    }
}
