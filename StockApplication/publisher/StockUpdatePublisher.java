package StockApplication.publisher;

import StockApplication.StockName;
import StockApplication.StockValue;
import StockApplication.subsriber.StockSubscriber;

import java.util.ArrayList;
import java.util.List;

public class StockUpdatePublisher implements StockPublisher {

    private final String name; //because all publisher will look same

    private List<StockSubscriber> stockSubscriber; //list of subscriber

    public StockUpdatePublisher(String name) {
        this.name = name;
        this.stockSubscriber = new ArrayList<>();
    }

    @Override
    public void subscibe(StockSubscriber stockSubscriber) {

        this.stockSubscriber.add(stockSubscriber);

    }

    @Override
    public void unsubscribe(StockSubscriber stockSubscriber) {
        this.stockSubscriber.remove(stockSubscriber);


    }
    //it will have a loop over all subscriber to send the update to the subscribers

    @Override
    public void notifyAll(StockName stockName, StockValue stockValue) {
        for (StockSubscriber stockSubscriber : stockSubscriber) {
            stockSubscriber.update(stockName, stockValue);
        }


    }
}
