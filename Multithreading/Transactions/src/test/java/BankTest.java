import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class BankTest {

    private  static Bank bank;
    private  static Account account1;
    private  static Account account2;
    private  static Account account3;
    private  static Account account4;

    @BeforeAll
    static void setUp() {
        bank = new Bank();
        HashMap<String, Account> accountHashMap = new HashMap<>();
        account1 = new Account("one", 500000);
        account2 = new Account("two", 500000);
        account3 = new Account("tree", 1000000);
        account4 = new Account("four", 0);

        accountHashMap.put(account1.getAccNumber(), account1);
        accountHashMap.put(account2.getAccNumber(), account2);
        accountHashMap.put(account3.getAccNumber(), account3);
        accountHashMap.put(account4.getAccNumber(), account4);

        bank.setAccounts(accountHashMap);
    }

    @Test
    @DisplayName("Transfer method")
    void transferTest () {
        bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 10000 + 10000);
        assertTrue(bank.getTransactionStatus());
    }

    @Test
    @DisplayName("Increase money method")
    void increaseMoneyTest() {
        bank.increaseMoney(account4,500000);
        assertEquals(500000,account4.getMoney());
    }

    @Test
    @DisplayName("Decrease money method")
    void decreaseMoneyTest() {
        bank.decreaseMoney(account4,200000);
        assertEquals(300000,account4.getMoney());
    }

    @Test
    @DisplayName("Get balance")
    void getBalanceTest() {
        bank.getBalance(account4.getAccNumber());
        assertEquals(500000, account4.getMoney());
    }

    @Test
    @DisplayName("Get sum balance of all account")
    void getSumBalanceTest() {
        assertEquals(2500000, bank.getSumAllAccounts());
    }

    @Test
    @DisplayName("block or not")
    void checkTest() {
        assertTrue(bank.check(account1,account2,100000));
        //not enough money
        assertFalse(bank.check(account1,account2,0));
        //one are blocked
        account3.setBlocked(BlockStatus.TRUE);
        assertFalse(bank.check(account1,account3,250000));
    }
}
