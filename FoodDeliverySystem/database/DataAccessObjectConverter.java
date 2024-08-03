package FoodDeliverySystem.database;

import FoodDeliverySystem.data.CartItem;
import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class DataAccessObjectConverter {

   private DataAccessObjectConverter(){

   }

    public static List<CartItem> convertToCartItems(DataAccessResult dataAccessResult){
       return new ArrayList<>();
    }

    public static List<FoodItem>convertToFoodItems(DataAccessResult dataAccessResult){
       return new ArrayList<>();
    }

    public static FoodItem convertToFoodItem(DataAccessResult dataAccessResult){
        return null;
    }

    public static Restaurant convertToRestaurant(DataAccessResult dataAccessResult) {
       return null;
    }

    public static List<Restaurant> convertToRestaurantList(DataAccessResult restaurantData) {
       return null;
    }


}
