import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountDisabledTest {

    @Test
    @Disabled("This test is disabled and here is why...")
    @DisplayName("Deposit 400 successfully")
    public void testDeposit() {
        BankAccount account = new BankAccount(400, 0);
        account.deposit(500);
        assertEquals(900, account.getBalance());
    }
}
