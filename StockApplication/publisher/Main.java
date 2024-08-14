package StockApplication.publisher;

import StockApplication.Currency;
import StockApplication.StockName;
import StockApplication.StockValue;
import StockApplication.subsriber.StockUpdateSubscriber;

public class Main {
    public static void main(String[] args) {
        StockUpdatePublisher bsestockUpdatePublisher = new StockUpdatePublisher("BSE");
        StockUpdatePublisher nsestockUpdatePublisher = new StockUpdatePublisher("NSE");

        StockUpdateSubscriber stockUpdateSubscriber1 = new StockUpdateSubscriber("subsriber1");
        StockUpdateSubscriber stockUpdateSubscribe2 = new StockUpdateSubscriber("subsriber2");
        StockUpdateSubscriber stockUpdateSubscribe3 = new StockUpdateSubscriber("subsriber3");


        nsestockUpdatePublisher.subscibe(stockUpdateSubscriber1);
        nsestockUpdatePublisher.subscibe(stockUpdateSubscribe2);
        bsestockUpdatePublisher.subscibe(stockUpdateSubscribe3);
        bsestockUpdatePublisher.subscibe(stockUpdateSubscribe2);



        nsestockUpdatePublisher.notifyAll(StockName.AMAZON,
                new StockValue( Currency.INR,1,100));
       nsestockUpdatePublisher.notifyAll(StockName.AMAZON,
                new StockValue( Currency.INR,2, 200));
        bsestockUpdatePublisher.notifyAll(StockName.AMAZON,
                new StockValue( Currency.INR,1, 100));
        bsestockUpdatePublisher.notifyAll(StockName.HCL,
                new StockValue(Currency.INR,1,300));

    }
}
