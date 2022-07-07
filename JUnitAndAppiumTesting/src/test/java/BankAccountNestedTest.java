import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountNestedTest {
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

    // These are nested tests. They are only run when the parent class gets run.
    // They're like a sub-test? I don't really understand the value in these either.
    @Nested
    class WhenBalanceEqualsZero {
        @Test
        public void testWithdrawMinimumBalanceIs0() {
            BankAccount account = new BankAccount(500, 0);
            assertThrows(RuntimeException.class, () ->  account.withdraw(500));
        }

        @Test
        public void testWithdrawMinimumBalance1000() {
            BankAccount account = new BankAccount(0, -1000);
            account.withdraw(500);
            assertEquals(-500, account.getBalance());
        }
    }
}
