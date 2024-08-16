package Decorator;

public class Tester {
    public static void main(String[] args) {
        Pizza  pizza = new Mushroom(new WheatBase());
        System.out.println(pizza.getName() + " " + pizza.getCost());    }
}
