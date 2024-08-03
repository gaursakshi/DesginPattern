package FoodDeliverySystem.apis;

import FoodDeliverySystem.data.Order;
import FoodDeliverySystem.data.PaymentResponse;
import FoodDeliverySystem.data.PaymentStatus;
import FoodDeliverySystem.data.User;
import FoodDeliverySystem.factory.PaymentManagerFactory;
import FoodDeliverySystem.managers.OrderManager;
import FoodDeliverySystem.managers.PaymentManager;
import FoodDeliverySystem.managers.UserManager;

import java.nio.file.AccessDeniedException;
import java.util.Map;

public class PlaceOrderAPI {

    private final UserManager userManager = new
            UserManager();

//    String UserToken : this will Give the complete information about the User and Cart.
//
//    Map<String,String> paymentInfo : This Map will contain details about the Payment Info based on payment Mode . Example if Payment Mode is card based Payment then it will contain card number as a key and actual number as value.
//
//    Similarly if it is a netBanking based payment then it will contain otp as key and number as value etc.
//
//    String PaymentMode : This will be the mode of payment whether it is Card Based Payment or UPI based or NetBanking Based etc.

    public Order placeOrder(String userToken, Map<String, String> paymentInfo, String paymentMode) throws AccessDeniedException {

        if (userToken == null || paymentInfo == null || paymentMode == null) {

            throw new IllegalArgumentException("userToken and paymentInfo and paymentMode are null");
        }

        User user = userManager.getUserByToken(userToken);
        if (user == null) {
            throw new IllegalArgumentException("user not found");
        }

        PaymentManager paymentManager = PaymentManagerFactory.getPaymentManager(paymentInfo, paymentMode);
        PaymentResponse paymentResponse = paymentManager.executePayment();
        if (paymentResponse == null || paymentResponse.getPaymentStatus() == null || paymentResponse.getPaymentStatus().equals(PaymentStatus.FAILED)){
            throw new RuntimeException("payment failed...");
        }
        Order order = new OrderManager().placeOrder(user);
        return order;

    }
}
