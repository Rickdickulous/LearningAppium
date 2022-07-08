import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;


public class AppiumTest {
    private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.10.0/TheApp-v1.10.0.app.zip";
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    private IOSDriver driver;
    Duration ten_sec_timeout = Duration.ofSeconds(10);
    WebDriverWait wait;


    @BeforeEach
    public void testSetUp() throws Exception  {
        System.out.println("testSetUp");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "15.5");
        caps.setCapability("deviceName", "iPhone 8");
        caps.setCapability("udid", "9FF75984-1F09-4BF5-A667-F02C85A2FE6D");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("app", APP);

        caps.setCapability("wdaStartupRetries", "4");
        caps.setCapability("iosInstallPause","8000" );
        caps.setCapability("wdaStartupRetryInterval", "20000");

        driver = new IOSDriver(new URL(APPIUM), caps);
        wait = new WebDriverWait(driver, ten_sec_timeout);

        System.out.println("driver initialized");
    }

    @AfterEach
    public void testTearDown() {
        System.out.println("testTearDown");
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void basicLogin() {
        System.out.println("Click Login Screen button");

        WebElement screen = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.accessibilityId("Login Screen")));
        screen.click();

        System.out.println("Type 'alice' into username field");
        WebElement username = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.accessibilityId("username")));
        username.sendKeys("alice");

        System.out.println("Type 'mypassword' into password field");
        WebElement password = driver.findElement(
                AppiumBy.accessibilityId("password"));
        password.sendKeys("mypassword");

        // get page source

        // try {Thread.sleep(1000);} catch (Exception ignore) {}
        // System.out.println(driver.getPageSource());

        System.out.println("Click Login button");
        WebElement login = driver.findElement(
                AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`label == \"loginBtn\"`][2]"));
        login.click();

        WebElement loginText = wait.until(

                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.accessibilityId("You are logged in as alice")));

        assert(loginText.getText().contains("alice"));
    }

    @Test
    public void touchAndScrollActions() {
        WebElement listDemoButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("List Demo")));
        listDemoButton.click();

        // create pointer object that simulates a finger touching the screen
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Altostratus")));
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // build actions the finger takes
        Interaction moveToStart = finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 133, 544);
        Interaction pressDown = finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg());
        Interaction moveToEnd = finger.createPointerMove(Duration.ofMillis(750), PointerInput.Origin.viewport(), 146, 265);
        Interaction liftFinger = finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg());

        // build the sequence
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(moveToStart);
        swipe.addAction(pressDown);
        swipe.addAction(moveToEnd);
        swipe.addAction(liftFinger);

        driver.perform(Arrays.asList(swipe));

        driver.findElement(AppiumBy.accessibilityId("Stratus"));

    }

}
