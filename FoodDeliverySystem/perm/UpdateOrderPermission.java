package FoodDeliverySystem.perm;

import FoodDeliverySystem.data.Order;
import FoodDeliverySystem.data.OrderStatus;
import FoodDeliverySystem.data.User;

public class UpdateOrderPermission implements Permission{
    private final User user;
    private final Order order;
    private final OrderStatus orderStatus;

    public UpdateOrderPermission(User user, Order order, OrderStatus orderStatus) {
        this.user = user;
        this.order = order;
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
