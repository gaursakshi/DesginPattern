package FoodDeliverySystem.data;

import java.util.List;

public class Order {

    private int orderId;
    private OrderStatus orderStatus;
   private List<CartItem> cartItems;
   private final  int userId;

    public Order(int orderId,OrderStatus orderStatus,List<CartItem> cartItems,int userId) {

        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.cartItems = cartItems;
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public int getUserId() {
        return userId;
    }
}
