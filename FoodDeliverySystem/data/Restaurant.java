package FoodDeliverySystem.data;

import java.util.List;

public class Restaurant {

    private final int restaurantId;

    private final String name;

    private final String description;

    private final Address address;

    private final MealType mealType;

    private List<CuisinieType> cuisinieType;

    private StarRating starRating;

    private Menu menu;

    //opening and closing hours
    private final BusinessHours businessHours;


    //bulky constructor can be avoided using builder pattern

    public Restaurant(int restaurantId, String name, String description,Address address, MealType mealType, List<CuisinieType> cuisinieType, StarRating starRating, Menu menu, BusinessHours businessHours) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.address = address;
        this.mealType = mealType;
        this.cuisinieType = cuisinieType;
        this.starRating = starRating;
        this.menu = menu;
        this.businessHours = businessHours;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }

    public MealType getMealType() {
        return mealType;
    }

    public List<CuisinieType> getCuisinieType() {
        return cuisinieType;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public Menu getMenu() {
        return menu;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
