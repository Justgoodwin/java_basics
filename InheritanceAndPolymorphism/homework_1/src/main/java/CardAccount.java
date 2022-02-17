public class CardAccount extends BankAccount {
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);

    @Override
    public void take(double amountToTake) {
        if (amountToTake > moneyAmount) {
            moneyAmount -= 0;
        }
        else {
            moneyAmount -= amountToTake + (amountToTake * 0.01);
        }
    }
}
