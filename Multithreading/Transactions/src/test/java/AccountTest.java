import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    private  static Account account1;
    private  static Account account2;
    private  static Account account3;
    private  static Account account4;
    @BeforeAll
    static void setUp() {
        account1 = new Account("1", 1236);
        account2 = new Account("2", 7412);
        account3 = new Account("3", 7896);
        account4= new Account("4", 3657);
        account1.setBlocked(BlockStatus.TRUE);
        account3.setBlocked(BlockStatus.TRUE);
    }

    @Test
    @DisplayName("Get money")
    void getAccountMoneyTest () {
        assertTrue(account1.getMoney() == 1236);
        assertTrue(account2.getMoney() == 7412);
        assertTrue(account3.getMoney() == 7896);
        assertTrue(account4.getMoney() == 3657);
    }

    @Test
    @DisplayName("Get account number")
    void getAccNumberTest() {
        assertTrue(account1.getAccNumber() == "1");
        assertTrue(account2.getAccNumber() == "2");
        assertTrue(account3.getAccNumber() == "3");
        assertTrue(account4.getAccNumber() == "4");
    }

    @Test
    @DisplayName("Get block status")
    void getBlockStatusTest() {
        assertTrue(account1.getIsBlocked() == true);
        assertTrue(account2.getIsBlocked() == false);
        assertTrue(account3.getIsBlocked() == true);
        assertTrue(account4.getIsBlocked() == false);
    }

}
