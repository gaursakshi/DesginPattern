package splitwise_stategry.strategyPattern;

import splitwise_stategry.data.Expense;
import splitwise_stategry.data.User;

import java.util.Map;

public interface SplittingStrategy {

    void splitExpense(Expense expense, Map<User,Double> userShares);

}
