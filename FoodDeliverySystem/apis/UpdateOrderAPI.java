package FoodDeliverySystem.apis;

import FoodDeliverySystem.data.Order;
import FoodDeliverySystem.data.OrderStatus;
import FoodDeliverySystem.data.User;
import FoodDeliverySystem.managers.OrderManager;
import FoodDeliverySystem.managers.UserManager;
import VendingMachine.Exception.ItemNotFoundException;

import java.nio.file.AccessDeniedException;

public class UpdateOrderAPI {

    private final OrderManager orderManager = new OrderManager();
    private final UserManager userManager = new UserManager();

    public void updateOrder(String userToken, int orderId, OrderStatus orderStatus) throws ItemNotFoundException, AccessDeniedException {

        if(userToken == null || orderId <= 0) {
            throw new IllegalArgumentException("Ivalid parameters");
        }
        User user = userManager.getUserByToken(userToken);
        if(user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Order order = orderManager.getOrder(user);
        if(order == null) {
            throw new ItemNotFoundException("Order not found");
        }
        if(orderStatus.equals(OrderStatus.ORDER_PLACED)){
            orderManager.setOrderToCooking(order,orderStatus,user);
        }
    }
}
