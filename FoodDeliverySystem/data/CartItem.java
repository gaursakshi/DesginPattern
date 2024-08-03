package FoodDeliverySystem.data;

public class CartItem {

   private final FoodItem foodItem;

   private final int quantity;


   CartItem(FoodItem foodItem, int quantity) {
       this.foodItem = foodItem;
       this.quantity = quantity;
   }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }
}
