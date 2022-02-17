import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1) {
            moneyAmount += 0;
        }
        else {
            moneyAmount += amountToPut;
            lastIncome = LocalDate.now();
        }
    }
    @Override
    public void take(double amountToTake) {
        if (amountToTake < moneyAmount && LocalDate.now().isAfter(lastIncome)) {
            moneyAmount -= amountToTake;
        }
        else {
            moneyAmount -= 0;
        }

    }

}
