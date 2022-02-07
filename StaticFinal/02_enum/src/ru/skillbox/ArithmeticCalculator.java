package ru.skillbox;

public class ArithmeticCalculator {

    private static int firstNumber = 0;
    private static int secondNumber = 0;

    public ArithmeticCalculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public static int makeCalculation(Operation operation) {

        switch (operation) {
            case ADD:
                return firstNumber + secondNumber;

            case SUBTRACT:
                return firstNumber - secondNumber;

            case MULTIPLY:
                return firstNumber * secondNumber;

            case DIVIDE : {
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                }
                else {
                    System.out.println("Нельзя делить на ноль!");
                }
                break;
            }
            default:
                return 0;
//         if (Operation.ADD.equals(operation)) {
//            return firstNumber + secondNumber;
//
//        }
//        else if (Operation.SUBTRACT.equals(operation)) {
//            return firstNumber - secondNumber;
//        }
//        else if (Operation.MULTIPLY.equals(operation)) {
//            return firstNumber * secondNumber;
//        }
//        else if (Operation.DIVIDE.equals(operation)) {
//            if (secondNumber != 0) {
//                return firstNumber / secondNumber;
//            }
//            else {
//                System.out.println("Нельзя делить на ноль!");
//            }

        }
        return 0;
    }

}