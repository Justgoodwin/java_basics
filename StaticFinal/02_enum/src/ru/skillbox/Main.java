package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(15,5);

        System.out.println("сложение: " + arithmeticCalculator.makeCalculation(Operation.ADD));
        System.out.println("вычитание: " + arithmeticCalculator.makeCalculation(Operation.SUBTRACT));
        System.out.println("умножение: " + arithmeticCalculator.makeCalculation(Operation.MULTIPLY));
        System.out.println("деление: " + arithmeticCalculator.makeCalculation(Operation.DIVIDE));
    }
}
