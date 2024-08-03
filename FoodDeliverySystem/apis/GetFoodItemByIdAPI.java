package FoodDeliverySystem.apis;

import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.searchers.FoodItemSearcher;

public class GetFoodItemByIdAPI {

    public FoodItem getFoodItemById(int id) {
        if(id<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
        return new FoodItemSearcher().searchById(id);
    }
}
