package splitwise_stategry;

import splitwise_stategry.data.User;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        SplitWiseController splitwise = new SplitWiseController();
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        splitwise.addUser(alice);
        splitwise.addUser(bob);
        splitwise.addUser(charlie);

        Map<User, Double> userShares = new HashMap<>();
        userShares.put(alice, 33.33);
        userShares.put(bob, 33.33);
        userShares.put(charlie, 33.34);

        splitwise.splitExpense("Dinner", 200, "EQUAL", userShares);

        splitwise.showExpenses();
        splitwise.showExpensesForUser(alice);

    }
}
