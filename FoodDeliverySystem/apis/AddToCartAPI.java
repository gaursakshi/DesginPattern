package FoodDeliverySystem.apis;

import FoodDeliverySystem.data.CartItem;
import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.User;
import FoodDeliverySystem.managers.CartManager;
import FoodDeliverySystem.managers.UserManager;
import FoodDeliverySystem.searchers.FoodItemSearcher;

import java.util.Objects;

public class AddToCartAPI {

    //it is void , because its write operation
    //Since add to cart is a write operation , we need to carefully implement it and have to check multiple layer authentication.

    private final UserManager userManager = new UserManager();

    private final FoodItemSearcher foodItemSearcher = new FoodItemSearcher();

    private final CartManager cartManager = new CartManager();

    public void addToCart(String userToken, int foodItemId) throws Exception {

        if (userToken == null || userToken.isEmpty() || foodItemId <= 0) {
            throw new IllegalArgumentException("userToken and foodItemId cannot be null");
        }

        //

        //get the user from the userToken
        User user = userManager.getUserByToken(userToken);
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("User not found");
        }

        FoodItem newFoodNeedToAdd = foodItemSearcher.searchById(foodItemId);
        if (Objects.isNull(newFoodNeedToAdd)) {
            throw new Exception("food with the following is not present");
        }

        CartManager cartManager = new CartManager();
        cartManager.addToCart(user, newFoodNeedToAdd);


    }
}
