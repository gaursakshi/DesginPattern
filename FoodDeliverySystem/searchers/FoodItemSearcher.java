package FoodDeliverySystem.searchers;

import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.database.DataAccesor;
import FoodDeliverySystem.database.DataAccessObjectConverter;
import FoodDeliverySystem.database.DataAccessResult;
import FoodDeliverySystem.filters.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//buisness class
//this is closed as you can add more filter adn the logic won't change
//following open closed filtert
public class FoodItemSearcher {

    public List<FoodItem> search(String foodItemName, List<FoodItemFilter> foodItemFilterList) throws IllegalArgumentException {
        //adding validations
        if (foodItemName == null || Objects.isNull(foodItemFilterList) || foodItemFilterList.isEmpty()) {
            throw new IllegalArgumentException("Missing parameters");
        }

        //for every food item that we got  - we need to check filter and return the foold
        DataAccessResult dataAccessResult = DataAccesor.getFoodItemsWithName(foodItemName);

        //convert the dataaccessresult into the object that we want
        List<FoodItem> foodItemsList = DataAccessObjectConverter.convertToFoodItems(dataAccessResult);


        for (FoodItemFilter foodItemFilter : foodItemFilterList) {
            List<FoodItem> filteredFoodItems = new ArrayList<>();
            for (FoodItem foodItem : foodItemsList) {
                if (foodItemFilter.filter(foodItem)) {
                    filteredFoodItems.add(foodItem);
                }

            }
            foodItemsList = filteredFoodItems;

            //why this happened
            // one filter will come and then it will get applied on next set of filter
        }

        return foodItemsList;
    }


    public FoodItem searchById(int foodId) {
        DataAccessResult dataAccessResult = DataAccesor.getFoodItemsWithId(foodId);
       FoodItem foodItem = DataAccessObjectConverter.convertToFoodItem(dataAccessResult);
        return foodItem;
    }
}
