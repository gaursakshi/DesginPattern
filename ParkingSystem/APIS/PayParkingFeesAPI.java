package ParkingSystem.APIS;

import ParkingSystem.data.Ticket;
import ParkingSystem.payment.*;

import java.time.LocalDateTime;
import java.util.Map;

public class PayParkingFeesAPI {

    public boolean payParkingFee(Map<String,String> paymentDetails, Ticket ticket, PaymentMode paymentMode){
        PaymentProcessor paymentProcessor = null;
        if(ticket == null || paymentMode == null || paymentDetails == null){
            throw  new IllegalArgumentException("Ticket and PaymentMode and paymentDetails are required");
        }
        if(paymentMode == PaymentMode.CARD){
            String name = paymentDetails.get("name");
            int pin = Integer.parseInt(paymentDetails.get("pin"));
            String cardNumber  = paymentDetails.get("cardNumber");
            LocalDateTime expiryDate = LocalDateTime.parse(paymentDetails.get("expiryDate"));
            CardDetail  cardDetail = new CardDetail(name,pin,cardNumber,expiryDate);
            double amount = Double.parseDouble(paymentDetails.get("amount"));
           paymentProcessor = PaymentManagerFactory.getCardBasedPaymentProcessor(cardDetail,amount);
        }
        else if(paymentMode == PaymentMode.CASH){
            double amount = Double.parseDouble(paymentDetails.get("amount"));
             paymentProcessor = PaymentManagerFactory.getCashBasedPaymentProcessor(amount);
        }
        else{
            throw new IllegalArgumentException("Unsupported payment mode");
        }

        return new ParkingFeeProcessor().processFees(ticket,paymentProcessor);
    }
}
