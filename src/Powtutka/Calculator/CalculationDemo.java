package Powtutka.Calculator;

class Calculator {
    public double performOperation(double operand1, double operand2) {
        return 0.0;
    }
}

class AditionOperation extends Calculator {
    @Override
    public double performOperation(double operand1, double operand2) {
        return operand1 + operand2;
    }
}

class SubtractionOperation extends Calculator {
    @Override
    public double performOperation(double operand1, double operand2) {
        return operand1 - operand2;
    }
}

class MultiplicationOperation extends Calculator {
    @Override
    public double performOperation(double operand1, double operand2) {
        return operand1 * operand2;
    }
}

class DivisionOperation extends Calculator {
    @Override
    public double performOperation(double operand1, double operand2) {
        if (operand2 == 0) {
            System.out.println("ERROR DIVISION WITH 0 !!!!!!");
            return Double.NaN;
        }
        return operand1 / operand2;
    }
}

public class CalculationDemo {
    public static void main(String[] args) {

        Calculator additionCalculator = new AditionOperation();
        Calculator subtractionCalculator = new SubtractionOperation();
        Calculator multiplicationCalculator = new MultiplicationOperation();
        Calculator divisionCalculator = new DivisionOperation();

        // Выполните операции с использованием полиморфизма
        double result1 = additionCalculator.performOperation(10.0, 5.0);
        double result2 = subtractionCalculator.performOperation(10.0, 5.0);
        double result3 = multiplicationCalculator.performOperation(10.0, 5.0);
        double result4 = divisionCalculator.performOperation(10.0, -10.0);

        System.out.println("Сложение: " + result1);
        System.out.println("Вычитание: " + result2);
        System.out.println("Умножение: " + result3);
        System.out.println("Деление: " + result4);

    }
}
