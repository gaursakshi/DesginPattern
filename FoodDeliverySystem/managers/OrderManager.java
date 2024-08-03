package FoodDeliverySystem.managers;

import FoodDeliverySystem.data.CartItem;
import FoodDeliverySystem.data.Order;
import FoodDeliverySystem.data.OrderStatus;
import FoodDeliverySystem.data.User;
import FoodDeliverySystem.database.DataAccesor;
import FoodDeliverySystem.factory.PermissionFactory;
import FoodDeliverySystem.perm.Permission;

import java.nio.file.AccessDeniedException;
import java.util.List;

public class OrderManager {

    private CartManager cartManager = new CartManager();

    public Order placeOrder(User user) throws AccessDeniedException {
        Permission permission = PermissionFactory.getPlaceOrderPermission(user);
        if (!permission.isPermitted()) {
            throw new AccessDeniedException("Permission Denied");
        }
        //gett the card item list
        List<CartItem> cartItemList = cartManager.getUserCart(user);
        //create a new order
        int orderId = DataAccesor.createOrder(user, cartItemList);

        //checkout the cart
        cartManager.checkOutUserCart(user);
        return new Order(orderId, OrderStatus.ORDER_PLACED, cartItemList, user.getId());
    }

    //it will have the order realted methods
    //let say I want all the order of userid
    public List<Order> getOrderList(User user) {
        return null;
    }

    public Order getOrder(User user) {
        return null;
    }


    public void setOrderToCooking(Order order, OrderStatus orderStatus, User user) throws AccessDeniedException {
        Permission permission = PermissionFactory.getUpdateOrderPermission(user, order, orderStatus);
        if (!permission.isPermitted()) {
            throw new AccessDeniedException(" Permission Denied");
        }
        if (orderStatus.equals(OrderStatus.ORDER_PLACED)) {
            throw new RuntimeException("Only ORDER_PLACED status can move to COOKING");
        }
        DataAccesor.updateOrder(order, orderStatus, user);
    }

    public void setOrderToReadyForDelivery(User user, Order order,OrderStatus status) throws AccessDeniedException {
        Permission permission = PermissionFactory.getUpdateOrderPermission(user, order, status);
        if (!permission.isPermitted()) {
            throw new AccessDeniedException(" Permission Denied");
        }

        if (!order.equals(OrderStatus.COOKING))
            throw new RuntimeException("Only COOKING status can move to DELIVERY");
        //....

        DataAccesor.updateOrder(order, status, user);
    }


    public void setOrderToOutForDelivery(User user, Order order,OrderStatus status) throws AccessDeniedException {
        Permission permission = PermissionFactory.getUpdateOrderPermission(user, order, status);
        if (!permission.isPermitted()) {
            throw new AccessDeniedException(" Permission Denied");
        }
        if (!order.getOrderStatus().equals(OrderStatus.READY_FOR_DELIVERY))
            throw new RuntimeException("Not ready for delivery");
        //....

        DataAccesor.updateOrder(order,order.getOrderStatus(), user);
    }

    public void setOrderToOutForDelivered(User user, Order order) {
        if (!order.getOrderStatus().equals(OrderStatus.OUT_FOR_DELIVERY))
            throw new RuntimeException("Not ready for delivery");
        //....
        DataAccesor.updateOrder(order,order.getOrderStatus(), user);
    }

    public void setOrderToCanceled(User user, Order order) {
        if (!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED))
            throw new RuntimeException("Order is not placed ,hence not cancled");
        //....
        DataAccesor.updateOrder(order,order.getOrderStatus(), user);
    }
}

