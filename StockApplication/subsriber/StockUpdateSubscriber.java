package StockApplication.subsriber;

import StockApplication.StockName;
import StockApplication.StockValue;
import StockApplication.publisher.StockPublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockUpdateSubscriber implements StockSubscriber {
    private String  name;
    List<StockPublisher> stockPublisher;
    Map<StockName, StockValue> stockUpdates;

    public StockUpdateSubscriber(String name) {
        this.name = name;
        this.stockUpdates = new HashMap<StockName, StockValue>();
        this.stockPublisher = new ArrayList<StockPublisher>();
    }
    @Override
    public void update(StockName stockName, StockValue stockValue) {
        System.out.println("Name of the subscriber: " + this.name);
        System.out.println("Received stock update: " + stockName + " " +
                stockValue.getAmount() + " " + stockValue.getCurrency());

        // Check if the stock has been updated before and compare versions
        if (stockUpdates.containsKey(stockName)) {
            StockValue existingStockValue = stockUpdates.get(stockName);
            if (existingStockValue.getVersion() < stockValue.getVersion()) {
                stockUpdates.put(stockName, stockValue);
                System.out.println("Updated stock: " + stockName + " to new value: " +
                        stockValue.getAmount() + " " + stockValue.getCurrency());
            } else {
                System.out.println("Ignored stock update for " + stockName + " due to older version.");
            }
        } else {
            stockUpdates.put(stockName, stockValue);
            System.out.println("Added new stock: " + stockName + " with value: " +
                    stockValue.getAmount() + " " + stockValue.getCurrency());
        }
    }


}
