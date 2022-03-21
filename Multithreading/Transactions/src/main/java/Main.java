import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        for (Map.Entry<String, Account> entry : accountHashMap.entrySet()) {
            System.out.println("name:\s" + entry.getKey() +
                    "\smoney:\s" + bank.getBalance(entry.getKey()) +
                    "\sstatus:\s" + entry.getValue().getIsBlocked());
        }

        for (int i = 0; i < 10; i++) {
            threadArrayList.add(new Thread(() ->  bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 10000)));
            threadArrayList.add(new Thread(() ->  bank.transfer(account2.getAccNumber(), account1.getAccNumber(), 5000)));
            threadArrayList.add(new Thread(() ->  bank.transfer(account3.getAccNumber(), account4.getAccNumber(), 10000)));
            threadArrayList.add(new Thread(() ->  bank.transfer(account4.getAccNumber(), account3.getAccNumber(), 5000)));
        }

        threadArrayList.forEach(Thread::start);
        for (Map.Entry<String, Account> entry : accountHashMap.entrySet()) {
            System.out.println("name:\s" + entry.getKey() +
                    "\smoney:\s" + bank.getBalance(entry.getKey()) +
                    "\sstatus:\s" + entry.getValue().getIsBlocked());
        }

    }
}
