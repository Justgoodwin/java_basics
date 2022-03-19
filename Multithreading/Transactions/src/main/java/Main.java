import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        HashMap<String, Account> accountHashMap = new HashMap<>();
        Account account1 = new Account("one", 500000);
        Account account2 = new Account("two", 500000);
        Account account3 = new Account("three", 1000000);
        Account account4 = new Account("four", 1000000);

        accountHashMap.put(account1.getAccNumber(), account1);
        accountHashMap.put(account2.getAccNumber(), account2);
        accountHashMap.put(account3.getAccNumber(), account3);
        accountHashMap.put(account4.getAccNumber(), account4);

        bank.setAccounts(accountHashMap);

        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int i = 0; i < 150; i++) {
            synchronized (bank) {
                threadArrayList.add(new Thread(() ->  bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 10000)));
                threadArrayList.add(new Thread(() ->  bank.transfer(account2.getAccNumber(), account3.getAccNumber(), 10000)));
                threadArrayList.add(new Thread(() ->  bank.transfer(account3.getAccNumber(), account4.getAccNumber(), 10000)));
                threadArrayList.add(new Thread(() ->  bank.transfer(account4.getAccNumber(), account1.getAccNumber(), 10000)));
            }

        }

        threadArrayList.forEach(Thread::start);
        synchronized (bank) {
            System.out.println("one: " + bank.getBalance("one") + " статус: " + account1.getIsBlocked());
            System.out.println("two: " + bank.getBalance("two") + " статус: " + account2.getIsBlocked());
            System.out.println("three: " + bank.getBalance("three") + " статус: " + account3.getIsBlocked());
            System.out.println("four: " + bank.getBalance("four") + " статус: " + account4.getIsBlocked());
        }

    }
}
