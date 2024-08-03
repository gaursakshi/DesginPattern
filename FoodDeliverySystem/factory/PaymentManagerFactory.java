package FoodDeliverySystem.factory;

import FoodDeliverySystem.data.CardType;
import FoodDeliverySystem.managers.CardManager;
import FoodDeliverySystem.managers.NetBankingManager;
import FoodDeliverySystem.managers.PaymentManager;

import java.time.LocalDate;
import java.util.Map;

public class PaymentManagerFactory {

    private PaymentManagerFactory() {

    }

    public static PaymentManager getPaymentManager(Map<String, String> paymentInfo, String paymentMode) {
        switch (paymentMode) {
            case "CARD":
                return getPaymentByCard(paymentInfo);
            case "NETBANK":
                return getPaymentByNetBanking(paymentInfo);
            default:
                throw new IllegalArgumentException("Invalid payment mode");
        }
    }

    public static PaymentManager getPaymentByCard(Map<String, String> paymentInfo) {
        String bankName = paymentInfo.get("bankName");
        String cardNumber = paymentInfo.get("cardNumber");
        CardType cardType = CardType.valueOf(paymentInfo.get("cardType"));
        LocalDate expiryDate = LocalDate.parse(paymentInfo.get("expiryMonth"));
        String cardHolderName = paymentInfo.get("cardHolderName");
        int cvv = Integer.parseInt(paymentInfo.get("cvv"));
        double amount = Double.parseDouble(paymentInfo.get("amount"));
        return new CardManager(bankName, cvv, cardNumber, cardHolderName, expiryDate, cardType, amount);
    }

    public static PaymentManager getPaymentByNetBanking(Map<String, String> paymentInfo) {
        String bankName = paymentInfo.get("bankName");
        String cardHolderName = paymentInfo.get("cardHolderName");
        String pin = paymentInfo.get("pin");
        double amount = Double.parseDouble(paymentInfo.get("amount"));
        String passWord = paymentInfo.get("passWord");
        return new NetBankingManager(bankName, cardHolderName, amount, passWord, pin);
    }
}
