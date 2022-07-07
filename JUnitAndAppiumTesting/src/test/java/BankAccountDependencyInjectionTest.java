import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDependencyInjectionTest {

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(BankAccount account) {
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }
}
