package Powtutka.Figure;

abstract class Figure {
    abstract double squareCount();
}

class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double squareCount() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Triangle extends Figure {
    private double side;
    private double high;

    public Triangle(double side, double high) {
        this.side = side;
        this.high = high;
    }

    @Override
    double squareCount() {
        return (side * high)/2;
    }
}

class Rectangle extends Figure {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }
    @Override
    double squareCount() {
        return side1*side2;
    }
}

public class FigureCount {
    public static void main(String[] args) {
        Figure circle = new Circle(3);
        Figure triangle = new Triangle(6, 4);
        Figure rectangle = new Rectangle(5, 7);

        double squer1 = circle.squareCount();
        double squer2 = triangle.squareCount();
        double squer3 = rectangle.squareCount();

        System.out.println("Squer of Circle = " + squer1);
        System.out.println("Squer of Triangle = " + squer2);
        System.out.println("Squer of Rectangle = " + squer3);
    }
}
