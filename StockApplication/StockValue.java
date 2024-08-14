package StockApplication;

public class StockValue {

    private final Currency currency;

    private final int version;

    private final double amount;

    public StockValue(Currency currency, int version, double amount) {
        this.currency = currency;
        this.version = version;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getVersion() {
        return version;
    }

    public double getAmount() {
        return amount;
    }
}
