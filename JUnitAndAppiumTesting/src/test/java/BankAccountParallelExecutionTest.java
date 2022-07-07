import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class BankAccountParallelExecutionTest {
    @Test
    @DisplayName("Withdraw 500 successfully")  // changes the test names in the report
    public void testWithdraw() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        BankAccount account = new BankAccount(500, -1000);
        account.withdraw(300);
        assertEquals(200, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit() {
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        BankAccount account = new BankAccount(400, 0);
        account.deposit(500);
        assertEquals(900, account.getBalance());
    }

    @Test
    @DisplayName("Withdraw 500 successfully")  // changes the test names in the report
    public void testWithdraw2() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        BankAccount account = new BankAccount(500, -1000);
        account.withdraw(300);
        assertEquals(200, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit2() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        BankAccount account = new BankAccount(400, 0);
        account.deposit(500);
        assertEquals(900, account.getBalance());
    }
}
