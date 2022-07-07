import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class BankAccountConditionalTests {

    @Test
    @EnabledOnOs({OS.MAC})
    public void testMac() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testWindows()  {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_18})
    public void enableJRE() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_18})
    public void  testNoJRE16() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "rickdickulous")
    public void envVars() {

    }
}
