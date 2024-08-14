package StockApplication.subsriber;

import StockApplication.StockName;
import StockApplication.StockValue;

public interface StockSubscriber {

    public  void update(StockName stockName, StockValue stockValue);
}
