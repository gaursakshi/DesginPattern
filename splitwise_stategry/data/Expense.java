package splitwise_stategry.data;

import splitwise_stategry.strategyPattern.SplittingStrategy;

public class Expense {

    private final String description;
    private  final double amount;
    private  final SplittingStrategy splittingStrategy;

    public Expense(String description, double amount, SplittingStrategy splittingStrategy) {
        this.description = description;
        this.amount = amount;
        this.splittingStrategy = splittingStrategy;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public SplittingStrategy getSplittingStrategy() {
        return splittingStrategy;
    }
}
