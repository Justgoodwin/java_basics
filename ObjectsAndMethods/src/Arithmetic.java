public class Arithmetic {
    private int firstNumber;
    private int secondNumber;

    public Arithmetic(int first,int second){
        this.firstNumber = first;
        this.secondNumber = second;
    }

    public int adder(){
        return firstNumber + secondNumber;
    }
    public int multiplier(){
        return firstNumber * secondNumber;
    }
    public int maxBetweenBoth(){
        if (firstNumber > secondNumber){
            return firstNumber;
        }else {
            return secondNumber;
        }
    }
    public int minBetweenBoth(){
        if (firstNumber < secondNumber){
            return firstNumber;
        }else {
            return secondNumber;
        }
    }
}
