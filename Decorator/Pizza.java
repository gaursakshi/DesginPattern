package Decorator;

public  abstract class Pizza {

    private final String name;

    private final double cost;

    protected Pizza( String name,double cost) {
        this.cost = cost;
        this.name = name;
    }

    public String getName() {
        return  this.name;
    }

    public double getCost() {
        return this.cost;
    }
}


