package FoodDeliverySystem.apis;

import FoodDeliverySystem.data.Restaurant;
import FoodDeliverySystem.searchers.RestaurantSearcher;

public class GetRestrauntByIdAPI {

    public Restaurant getRestrauntById(int id) {
        if(id<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
        return  new RestaurantSearcher().searchById(id);
    }
}
