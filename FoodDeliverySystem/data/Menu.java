package FoodDeliverySystem.data;

import java.util.List;

public class Menu {

    private final List<FoodItem> foodItemList;

    public Menu(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }
}
