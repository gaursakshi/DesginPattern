package FoodDeliverySystem.perm;

import FoodDeliverySystem.data.CartItem;
import FoodDeliverySystem.data.User;

public class CheckoutCartPermission implements Permission{
    User user;

    public CheckoutCartPermission(User user) {
        this.user = user;
    }
    @Override
    public boolean isPermitted() {
        return false;
    }
}
