package FoodDeliverySystem.database;

import FoodDeliverySystem.data.*;

import java.util.List;

public class DataAccesor {
  //  This DataAccessor class will contain all the members and functions which will execute the queries of the dataBase side and also the fetchers.

    //this function will make a call to database and get the database object for this
    //


    //constructor is private as method  is static
    private DataAccesor(){

    }

    public static DataAccessResult getFoodItemsWithName(String foodItemName) {
        return null;
    }

    public static DataAccessResult getReastrauntWithName(String restaurantName) {
        //make a call to the database object and return ReastrauntList based on name
        return null;
    }

    public static DataAccessResult getFoodItemsWithId(int id){
        //return food corresponding to given id
        return null;
    }

    public static DataAccessResult getReastrauntWithId(int id){
        //return reastraunt with following reastraunt id
        return null;
    }


    public static void addItemToCart(User user, FoodItem foodItem) {
        //make a call to the database object and add the things
        System.out.println("Food item added to cart.");
    }

    public static DataAccessResult getCart(User user) {return null;}


   public static void deleteItemFromCart(User user, FoodItem foodItem) {
       System.out.println("Food item deleted from cart.");
   }

   public static void checkOutCart(User user) {
       System.out.println("Cart is checkout.");
   }

    public static int createOrder(User user, List<CartItem> cartItemList) {
        return 1;
    }

    public static void updateOrder(Order order, OrderStatus orderStatus, User user) {
        //ching one row to update the status

        System.out.println("Update the order with new status");
    }
}
