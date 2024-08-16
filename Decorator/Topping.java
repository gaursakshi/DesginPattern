package Decorator;

public abstract class Topping extends Pizza {

    private final Pizza pizza;


    protected Topping(String name, double cost,Pizza pizza) {
        super(name, cost);
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return super.getCost() + pizza.getCost();
    }

    @Override
    public String getName() {
        return  super.getName() + pizza.getName();

    }


}
