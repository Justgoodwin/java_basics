package ru.skillbox;

public class ArithmeticCalculator {

    private int firstNumber;
    private int secondNumber;

    public ArithmeticCalculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int makeCalculation(Enum operation) {
        if (Operation.ADD.equals(operation)) {
            return firstNumber + secondNumber;
        }
        else if (Operation.SUBTRACT.equals(operation)) {
            return firstNumber - secondNumber;
        }
        else if (Operation.MULTIPLY.equals(operation)) {
            return firstNumber * secondNumber;
        }
        else if (Operation.DIVIDE.equals(operation)) {
            if (firstNumber !=0 && secondNumber != 0) {
                return firstNumber / secondNumber;
            }
            else {
                System.out.println("Одноиз значений равно нулю!");
            }
        }
        return 0;
    }
}
