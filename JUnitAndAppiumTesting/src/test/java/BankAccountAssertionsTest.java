import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")  // this one doesn't seem to be working
public class BankAccountAssertionsTest {
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

    @Test
    @DisplayName("Test balance can go negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount account = new BankAccount(500, -1000);
        account.withdraw(800);
        assertNotEquals(0, account.getBalance());
    }

    @Test
    @DisplayName("Test account is active once created")
    public void testActive() {
        BankAccount account = new BankAccount(400, 0);
        assertTrue(account.isActive());
    }

    @Test
    public void testHolderName() {
        BankAccount account = new BankAccount(400, 0);
        assertNull(account.getHolderName());
        account.setHolderName("Micah");
        assertNotNull(account.getHolderName());
    }

    @Test
    @DisplayName("Test assert is thrown when withdraw below minimum")
    public void testNoWithdrawBelowMinimum() {
        BankAccount account = new BankAccount(400, 0);
        assertThrows(RuntimeException.class, () -> account.withdraw(401));  // this funny () -> means to pass an executable
    }

    @Test
    @DisplayName("Test no exceptions are thrown for executables given")
    public void testWithdrawAndDepositWithoutExceptions() {
        BankAccount account = new BankAccount(400, 0);
        // verifies NO exceptions are thrown for given executables
        assertAll(() -> account.deposit(200), () -> account.withdraw(250));
    }

    @Test
    public void testDepositTimeout() {
        BankAccount account = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(1), () -> account.deposit(100), "Test took too long to execute.");
    }


}
