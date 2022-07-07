import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This makes the test class instance only created once, not before each test, I think.
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {
    static BankAccount account;

    @BeforeAll
    public static void prepSuite() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void prepTest() {
        System.out.println("BeforeEach");
        account = new BankAccount(500, 0);
    }

    @AfterEach
    public void endTest() {
        System.out.println("AfterEach");
    }

    @AfterAll
    public static void suiteTeardown() {
        System.out.println("AfterAll");
    }

    @Test
    @DisplayName("Withdraw 500 successfully")  // changes the test names in the report
    public void testWithdraw() {
        account.withdraw(300);
        assertEquals(200, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit() {
        BankAccount account = new BankAccount(400, 0);
        account.deposit(500);
        assertEquals(900, account.getBalance());
    }
}
