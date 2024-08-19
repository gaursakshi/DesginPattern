package splitwise_stategry.strategyPattern;

import splitwise_stategry.data.Expense;
import splitwise_stategry.data.User;

import java.util.Map;

public class EqualStrategy  implements SplittingStrategy{
    @Override
    public void splitExpense(Expense expense, Map<User, Double> userShares) {
        double amountPerUser = expense.getAmount() / userShares.size();
        for (User user : userShares.keySet()) {
           user.addExpense(expense,amountPerUser);
        }

    }
}
