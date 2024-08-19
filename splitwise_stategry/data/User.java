package splitwise_stategry.data;

import java.util.HashMap;
import java.util.Map;

public class User {

    private  final String userName;

    private  final Map<Expense,Double> expenses  = new HashMap<>();



   public User(final String userName) {
        this.userName = userName;


    }

    public String getUserName() {
        return userName;
    }

    public Map<Expense, Double> getExpenses() {
        return expenses;
    }


    public void addExpense(Expense expense, double amount) {
        expenses.put(expense, amount);
    }
}
