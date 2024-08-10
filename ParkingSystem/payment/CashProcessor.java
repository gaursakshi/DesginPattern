package ParkingSystem.payment;

public class CashProcessor implements PaymentProcessor {

    private final double amount;

    public CashProcessor(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean executePayment() {
        // Since it's a cash payment, we assume the payment is made successfully
        System.out.println("Cash payment of " + amount + " received.");
        return true;

    }

    @Override
    public double getAmount() {
        return this.amount;
    }


}
