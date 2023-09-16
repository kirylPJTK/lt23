package Powtutka.Restourant;

public class Restaurant {
    public static void main(String[] args) {
        Dish pizza = new Pizza("Pizza Peperoni", 12);
        Dish salad = new Salad("Olivje Nachuj", 32);
        Dish beverage = new Beverage("Tea", 2, true);


        Order order = new Order();
        order.addDish(pizza);
        order.addDish(salad);
        order.addDish(beverage);

        order.dispalyOrder();
    }
}
