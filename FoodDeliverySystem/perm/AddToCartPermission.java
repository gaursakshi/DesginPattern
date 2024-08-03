package FoodDeliverySystem.perm;

import FoodDeliverySystem.data.FoodItem;
import FoodDeliverySystem.data.Restaurant;
import FoodDeliverySystem.data.User;
import FoodDeliverySystem.managers.DeliveryManager;
import FoodDeliverySystem.searchers.RestaurantSearcher;

public class AddToCartPermission  implements Permission{
    private final User user;
    private final FoodItem foodItem;
    private final DeliveryManager deliveryManager;

   public AddToCartPermission(User user , FoodItem foodItem){
       this.user = user;
       this.foodItem = foodItem;
       this.deliveryManager = new DeliveryManager();
   }

    @Override
    public boolean isPermitted() {
       if(!foodItem.isAvailable()){
           return false;
       }
       //now  if the food is available now we have to check if the food can be deliver or not
        Restaurant restaurant  = new RestaurantSearcher().searchById(foodItem.getReasutrantId());
      return deliveryManager.isDeliveryPossible(restaurant.getAddress(),user.getAddress());
    }
}
