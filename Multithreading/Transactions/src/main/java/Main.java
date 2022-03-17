import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        HashMap<String, Account> accountHashMap = new HashMap<>();
        Account account1 = new Account("one", 500000);
        Account account2 = new Account("two", 500000);
        Account account3 = new Account("tree", 1000000);
        Account account4 = new Account("four", 0L);

        accountHashMap.put(account1.getAccNumber(), account1);
        accountHashMap.put(account2.getAccNumber(), account2);
        accountHashMap.put(account3.getAccNumber(), account3);
        accountHashMap.put(account4.getAccNumber(), account4);

//        accountHashMap.forEach((s, acc) -> System.out.println(s + ": " + acc));

        bank.setAccounts(accountHashMap);

        ArrayList<Thread> threadArrayList = new ArrayList<>();

        threadArrayList.add(new Thread(() -> {
            for (int i = 0; i <= 8; i++) {
                bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 10000 + 10000 * i);
            }
            for (int i = 0; i < 10; i++) {
                bank.transfer(account3.getAccNumber(), account4.getAccNumber(), 5000 * i);
            }
            for (int i = 0; i < 100; i++) {
                bank.transfer(account2.getAccNumber(), account4.getAccNumber(), 1000);
            }
        }));

        threadArrayList.forEach(Thread::start);

        try {
            Thread.sleep(4000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("one: " + bank.getBalance("one") + " статус: " + !account1.getIsBlocked());
//        System.out.println("two: " + bank.getBalance("two") + " статус: " + !account2.getIsBlocked());
//        System.out.println("three: " + bank.getBalance("three") + " статус: " + !account3.getIsBlocked());
//        System.out.println("four: " + bank.getBalance("four") + " статус: " + !account4.getIsBlocked());
    }
}
