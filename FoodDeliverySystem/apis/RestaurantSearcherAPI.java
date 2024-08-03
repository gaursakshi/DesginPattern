package FoodDeliverySystem.apis;

import FoodDeliverySystem.data.CuisinieType;
import FoodDeliverySystem.data.MealType;
import FoodDeliverySystem.data.Restaurant;
import FoodDeliverySystem.data.StarRating;
import FoodDeliverySystem.filters.CuisineTypeFilter;
import FoodDeliverySystem.filters.MealTypeFilter;
import FoodDeliverySystem.filters.RestaurantFilter;
import FoodDeliverySystem.filters.StarRatingFilter;
import FoodDeliverySystem.searchers.RestaurantSearcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RestaurantSearcherAPI {

    RestaurantSearcher restaurantSearcher;

    List<Restaurant> searchRestaurant(String restaurantName, MealType mealType, List<CuisinieType> cuisineTypes, StarRating rating) {

        List<RestaurantFilter> restaurantFilters = new ArrayList<RestaurantFilter>();
        if (Objects.nonNull(mealType)) {
            restaurantFilters.add(new MealTypeFilter(mealType));
        }
        if (Objects.nonNull(cuisineTypes)) {
            restaurantFilters.add(new CuisineTypeFilter(cuisineTypes));
        }
        if (Objects.nonNull(rating)) {
            restaurantFilters.add(new StarRatingFilter(rating));
        }
        return new RestaurantSearcher().searchRestaurantByName(restaurantName, restaurantFilters);


    }
}
