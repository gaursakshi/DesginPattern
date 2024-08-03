package FoodDeliverySystem.searchers;

import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.Restaurant;
import FoodDeliverySystem.database.DataAccesor;
import FoodDeliverySystem.database.DataAccessObjectConverter;
import FoodDeliverySystem.database.DataAccessResult;
import FoodDeliverySystem.filters.RestaurantFilter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcher {

    public List<Restaurant> searchRestaurantByName(String restaurantName, List<RestaurantFilter> restaurantFilters) {
        if (restaurantName == null || restaurantName.isEmpty() || restaurantFilters == null || restaurantFilters.isEmpty()) {
            throw new IllegalArgumentException("Missing parameters");
        }
        DataAccessResult restaurantData = DataAccesor.getReastrauntWithName(restaurantName);

        List<Restaurant> restaurantList = DataAccessObjectConverter.convertToRestaurantList(restaurantData);

        for (RestaurantFilter restaurantFilter : restaurantFilters) {
            List<Restaurant> filteredRestaurants = new ArrayList<>();
            for (Restaurant restaurant : restaurantList) {
                if (restaurantFilter.filterRestaurant(restaurant)) {
                    filteredRestaurants.add(restaurant);
                }
            }
            restaurantList = filteredRestaurants;
        }
        return restaurantList;
    }


    public Restaurant searchById(int id) {
        DataAccessResult dataAccessResult = DataAccesor.getReastrauntWithId(id);
        Restaurant restaurant = DataAccessObjectConverter.convertToRestaurant(dataAccessResult);
       return restaurant;
    }

}
