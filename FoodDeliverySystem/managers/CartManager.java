package FoodDeliverySystem.managers;


import FoodDeliverySystem.data.CartItem;
import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.User;
import FoodDeliverySystem.database.DataAccesor;
import FoodDeliverySystem.database.DataAccessObjectConverter;
import FoodDeliverySystem.database.DataAccessResult;
import FoodDeliverySystem.factory.PermissionFactory;

import FoodDeliverySystem.perm.Permission;

import java.nio.file.AccessDeniedException;
import java.util.List;

public class CartManager {

    public List<CartItem> getUserCart(User user) {
        DataAccessResult cartList = DataAccesor.getCart(user);
        return DataAccessObjectConverter.convertToCartItems(cartList);

    }

    public void addToCart(User user, FoodItem foodItem) throws AccessDeniedException {
        //  Permission permission = new AddToCartPermission(user,foodItem); /// this is violating dependency inversion problem as its depending upon concrete classes
        //so use of abstract factory

        Permission permission = PermissionFactory.getAddToCartPermission(user, foodItem);
        if (!permission.isPermitted()) {
            throw new AccessDeniedException("Access denied Exception");
        }
        //check  food item is present in the same reastraunt
        if (!isFoodItemFromSameRestaurant(user, foodItem)) {
            throw new RuntimeException("Your cart contains items from diff restaurant");
        }
        //add
        DataAccesor.addItemToCart(user, foodItem);
    }


    public void deleteItemFromCart(User user, FoodItem foodItem) throws AccessDeniedException {

        Permission permission = PermissionFactory.getDeleteFromCartPermission(user, foodItem);
        if (!permission.isPermitted()) {
            throw new AccessDeniedException("Access denied Exception");
        }
        if (!isFoodItemPresentInCart(user, foodItem)) {
            throw new RuntimeException("your item is not present in the cart");
        }
        DataAccesor.deleteItemFromCart(user, foodItem);
    }


    public void checkOutUserCart(User user) {
        Permission permission = PermissionFactory.getCheckoutCartPermission(user);
        if (!permission.isPermitted()) {
            throw new RuntimeException("Access denied Exception");
        }
        //check if cart is empty
        if (isCartEmpty(user))
            throw new RuntimeException("Cart empty");
        DataAccesor.checkOutCart(user);
    }

    private boolean isCartEmpty(User user) {
        List<CartItem> cartItems = getUserCart(user);
        return cartItems.isEmpty();

    }

    private boolean isFoodItemFromSameRestaurant(User user, FoodItem foodItem) {
        List<CartItem> cartItems = getUserCart(user);
        return cartItems.isEmpty() || cartItems.get(0).getFoodItem().getReasutrantId() != foodItem.getReasutrantId();
    }

    private boolean isFoodItemPresentInCart(User user, FoodItem foodItem) {
        List<CartItem> cartItems = getUserCart(user);
        if (cartItems.isEmpty()) {
            return false;
        }

        for (CartItem cartItem : cartItems) {
            if (cartItem.getFoodItem().getId() == foodItem.getId()) {
                return true;
            }
        }
        return false;
    }

}
