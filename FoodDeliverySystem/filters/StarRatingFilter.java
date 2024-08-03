package FoodDeliverySystem.filters;

import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.Restaurant;
import FoodDeliverySystem.data.StarRating;

public class StarRatingFilter implements FoodItemFilter, RestaurantFilter {

    private StarRating starRating;

    public StarRatingFilter(StarRating starRating) {
        this.starRating = starRating;

    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal() >= starRating.getVal();
    }

    @Override
    public boolean filterRestaurant(Restaurant restaurant) {
        return restaurant.getStarRating().getVal() >= starRating.getVal();
    }
}
