import java.util.HashMap;
import java.util.Random;

public class Bank implements Runnable{

    private HashMap<String, Account> accounts;
    private final Random random = new Random();
    private long sumAllAccounts = 0L;
    private boolean transactionStatus = false;

    public HashMap<String, Account> getAccount() {
        return accounts;
    }

    private Account from;
    private Account to;
    private long amount;

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }




    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        from = accounts.get(fromAccountNum);
        to = accounts.get(toAccountNum);
        this.amount = amount;
        run();
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */

    public boolean check(Account from, Account to, long value) {
        if (from.getIsBlocked() || to.getIsBlocked()) {
            System.out.println("One of account are blocked");
            return false;
        }
        else if (!(from.getMoney() >= value && value > 0)) {
            System.out.println("Invalid amount or not enough money");
            return false;
        }
        return true;
    }
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        accounts.forEach((s, account) -> sumAllAccounts += account.getMoney());
        return sumAllAccounts;
    }

    public void increaseMoney(Account account, long amount) {
        account.setMoney(account.getMoney() + amount);
    }

    public void decreaseMoney(Account account, long amount) {
        account.setMoney(account.getMoney() - amount);
    }

    public boolean getTransactionStatus() {
        return transactionStatus;
    }

    @Override
    public void run() {
        if (!check(from,to,amount)) {
            return;
        }
        try {
            if (amount > 50000 && isFraud(from.getAccNumber(), to.getAccNumber(), amount)) {
                from.setBlocked(BlockStatus.TRUE);
                to.setBlocked(BlockStatus.TRUE);
                System.out.println("Transfer failed \n Account are blocked by Security service" +
                        "\s" + from.getAccNumber() +
                        "\s" + to.getAccNumber());
                transactionStatus = false;
            }
            else {
                synchronized (from) { //Java умный он сам в блоке synchronized захватывает монитор переданного обьекта, в конце блока освобождает
                    synchronized (to) {
                        decreaseMoney(from, amount);
                        increaseMoney(to, amount);
                    }
                }

                System.out.println("Transfer successful");
                transactionStatus = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
