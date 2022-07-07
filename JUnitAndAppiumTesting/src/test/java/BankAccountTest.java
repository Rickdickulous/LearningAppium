import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")  // this one doesn't seem to be working
public class BankAccountTest {
    @Test
    @DisplayName("Withdraw 500 successfully")  // changes the test names in the report
    public void testWithdraw() {
        BankAccount account = new BankAccount(500, -1000);
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
