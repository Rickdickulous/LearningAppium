import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Test is aborted due to assumption failing")
    public void testActive() {
        BankAccount account = new BankAccount(500, 5);
        assumeTrue(account == null, "Account is null");
        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Test passes even if assumption fails. Just don't use this, it's stupid.")
    public void testActive2() {
        BankAccount account = new BankAccount(400, 0);
        assumingThat(account == null, () -> account.isActive());
    }
}
