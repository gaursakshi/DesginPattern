package FoodDeliverySystem.data;

public class PaymentResponse {

    final int paymentId;
    final double amount;

    final PaymentStatus paymentStatus;

    public PaymentResponse(int paymentId,double amount, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentId = paymentId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
