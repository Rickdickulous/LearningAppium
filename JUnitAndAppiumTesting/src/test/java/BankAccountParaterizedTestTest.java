import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParaterizedTestTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(int amount, BankAccount account) {
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    public void testDayOfWeek(DayOfWeek day) {
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    //@CsvSource({"100, BigBadBootyDaddy", "200, Breezey", "300, Poster", "400, Shillings"})
    @CsvFileSource(resources = "details.csv")
    public void depositAndNameTest(double amount, String name, BankAccount account) {
        account.deposit(amount);
        account.setHolderName(name);
        assertEquals(amount, account.getBalance());
        assertEquals(name, account.getHolderName());
    }
}
