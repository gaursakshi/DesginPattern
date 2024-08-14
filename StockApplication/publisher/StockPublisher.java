package StockApplication.publisher;

import StockApplication.StockName;
import StockApplication.StockValue;
import StockApplication.subsriber.StockSubscriber;

public interface StockPublisher {

    public void subscibe(StockSubscriber stockSubscriber);

    public void unsubscribe(StockSubscriber stockSubscriber);

    public void notifyAll(StockName stockName, StockValue stockValue);

}
