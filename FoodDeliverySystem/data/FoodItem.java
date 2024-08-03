package FoodDeliverySystem.data;

public class FoodItem {
    //BuilderPattern can be used

    private final int id;

    private final String name;

    private final String description;

    private  final double priceINR;

    private final MealType mealType;

    private final CuisinieType cuisinieType;

    private final StarRating starRating;

    private final int restaurantId;

    private  final boolean isAvailable;

    public FoodItem(int id, String name, String description, double priceINR, MealType mealType, CuisinieType cuisinieType, StarRating starRating, int reasutrantId, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceINR = priceINR;
        this.mealType = mealType;
        this.cuisinieType = cuisinieType;
        this.starRating = starRating;
        this.restaurantId= reasutrantId;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }



    public double getPriceINR() {
        return priceINR;
    }


    public MealType getMealType() {
        return mealType;
    }



    public CuisinieType getCuisinieType() {
        return cuisinieType;
    }



    public StarRating getStarRating() {
        return starRating;
    }



    public int getReasutrantId() {
        return restaurantId;
    }



    public boolean isAvailable() {
        return isAvailable;
    }


}
