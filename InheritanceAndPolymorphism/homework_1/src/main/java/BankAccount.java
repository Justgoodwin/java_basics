public class BankAccount {
  protected double moneyAmount = 0;
  public double getAmount() {
    return moneyAmount;
  }

  public void put(double amountToPut) {
    if (amountToPut < 1) {
      moneyAmount += 0;
    }
    else {
      moneyAmount += amountToPut;
    }
  }

  public void take(double amountToTake) {
    if (amountToTake > moneyAmount) {
      moneyAmount -= 0;
    }
    else {
      moneyAmount -= amountToTake;
    }
  }
}
