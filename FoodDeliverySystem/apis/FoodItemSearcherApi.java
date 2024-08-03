package FoodDeliverySystem.apis;

import FoodDeliverySystem.searchers.FoodItemSearcher;
import FoodDeliverySystem.data.CuisinieType;
import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.MealType;
import FoodDeliverySystem.data.StarRating;
import FoodDeliverySystem.filters.CuisineTypeFilter;
import FoodDeliverySystem.filters.FoodItemFilter;
import FoodDeliverySystem.filters.MealTypeFilter;
import FoodDeliverySystem.filters.StarRatingFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcherApi {


    public List<FoodItem> searchFoodItems(String foodItemName, StarRating starRating, MealType mealType, List<CuisinieType> cuisineTypeList) throws Exception {
        try {

            List<FoodItemFilter> foodItemFilterList = new ArrayList<>();
            foodItemFilterList.add(new CuisineTypeFilter(cuisineTypeList));
            foodItemFilterList.add(new StarRatingFilter(starRating));
            foodItemFilterList.add(new MealTypeFilter(mealType));

            List<FoodItem> foodItemsList = new FoodItemSearcher().search(foodItemName, foodItemFilterList);
            return foodItemsList;
        } catch (IllegalArgumentException e) {
            throw new Exception("Error in fetchhing the search food");

        }
    }

    //Searcher class
    //this searcher should be generic seacher
    //this will  have the buisness logic
    //  . This searcher should be generic ,
    //  This will work something like “ Get only those food items whose (name matches foodItemName ) AND (meal Type is mealType) AND (ct is CuisineType) AND (r>rating) .
}
