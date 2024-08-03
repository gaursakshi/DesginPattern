package FoodDeliverySystem.filters;

import FoodDeliverySystem.data.CuisinieType;
import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.Restaurant;

import java.util.List;

public class CuisineTypeFilter implements FoodItemFilter, RestaurantFilter {

    List<CuisinieType> cuisinieTypeList;

    public CuisineTypeFilter(List<CuisinieType> cuisinieTypeList) {
        this.cuisinieTypeList = cuisinieTypeList;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisinieTypeList.contains(foodItem.getCuisinieType());
    }

    @Override
    public boolean filterRestaurant(Restaurant restaurant) {
      //atleast one of the cusiuinse user is asking is supported in reastrunt
        List<CuisinieType>restaurantCuisingList = restaurant.getCuisinieType();
        for(CuisinieType cuisinieType : cuisinieTypeList) {
            if(restaurantCuisingList.contains(cuisinieType)){
                return true;
            }
        }
        return false;
    }
}
