package splitwise_stategry.strategyPattern;

import splitwise_stategry.data.Expense;
import splitwise_stategry.data.User;

import java.util.Map;

public class PercentageStrategy implements SplittingStrategy{
    @Override
    public void splitExpense(Expense expense, Map<User, Double> userShares) {
        for (Map.Entry<User, Double> entry : userShares.entrySet()) {
            User user = entry.getKey();
            double percentage = entry.getValue();
            double amount = expense.getAmount() * (percentage / 100);
            user.addExpense(expense, amount);
        }
    }
}
