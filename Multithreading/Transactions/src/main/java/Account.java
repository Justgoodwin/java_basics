
public class Account {

    private Long money;
    private String accNumber;
    private boolean isBlocked;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
        isBlocked = false;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setBlocked(BlockStatus blocked) {
        if (blocked.equals(BlockStatus.TRUE)) {
            this.isBlocked = true;
        }
    }

    public boolean getIsBlocked() {
        return isBlocked;
    }

    @Override
    public String toString() {
        return "Account number\s" + accNumber + ",\s" + "money = " + money;
    }
}