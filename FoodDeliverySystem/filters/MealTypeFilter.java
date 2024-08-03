package FoodDeliverySystem.filters;

import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.MealType;
import FoodDeliverySystem.data.Restaurant;

public class MealTypeFilter implements FoodItemFilter, RestaurantFilter {

    //in order to filter based on mealtype - it should also know the mealType

    private MealType mealType;

    public MealTypeFilter(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getMealType().equals(mealType);
    }

    @Override
    public boolean filterRestaurant(Restaurant restaurant) {
        return restaurant.getMealType().equals(mealType);
    }
}
