package Powtutka.Restourant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Dish> dishes;

    public Order() {
        dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for(Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public void dispalyOrder() {
        System.out.println("Your Order: ");
        for (Dish dish : dishes) {
            System.out.println(dish.getName() + " - " + dish.getPrice() + "$");
        }
        System.out.println("Total price of your order: " + calculateTotalPrice() + "$");
    }
}
