package splitwise_stategry;

import splitwise_stategry.data.Expense;
import splitwise_stategry.data.User;
import splitwise_stategry.splistwiseFactory.SplittingStrategyFactory;
import splitwise_stategry.strategyPattern.SplittingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplitWiseController {
    private List<User> users = new ArrayList<>();
    private List<Expense> expenses = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void splitExpense(String description, double amount, String strategyType, Map<User, Double> userShares) {
        SplittingStrategy strategy = SplittingStrategyFactory.getSplittingStrategy(strategyType);
        Expense expense = new Expense(description, amount, strategy);
        strategy.splitExpense(expense, userShares);
        expenses.add(expense);
    }

    public void showExpenses() {
        for (Expense expense : expenses) {
            System.out.println("Expense: " + expense.getDescription() + ", Amount: " + expense.getAmount());
        }
    }

    public void showExpensesForUser(User user) {
        Map<Expense, Double> userExpenses = user.getExpenses();
        for (Map.Entry<Expense, Double> entry : userExpenses.entrySet()) {
            System.out.println("Expense: " + entry.getKey().getDescription() + ", Amount: " + entry.getValue());
        }
    }
}

