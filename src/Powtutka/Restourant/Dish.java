package Powtutka.Restourant;

public class Dish {
    private String name;

    private int price;

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Pizza extends Dish {

    public Pizza(String name, int price) {
        super(name, price);
    }
}

class Salad extends Dish{
    public Salad(String name, int price) {
        super(name, price);
    }
}

class Beverage extends Dish{
    private boolean hotBeverage;
    public Beverage(String name, int price, boolean hotBeverage) {
        super(name, price);
        this.hotBeverage = hotBeverage;
    }
}
