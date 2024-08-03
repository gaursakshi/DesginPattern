package FoodDeliverySystem.filters;

import FoodDeliverySystem.data.FoodItem;

public interface FoodItemFilter {

    boolean filter(FoodItem foodItem);
}
