import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class FreeWalking {
    private  AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set desired capabilities for Android
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
      //  capabilities.setCapability("deviceName", "34251751090002X");
        capabilities.setCapability("app", "/home/qa/Downloads/izi.TRAVEL.apk");
        capabilities.setCapability("appPackage", "travel.opas.client");
        capabilities.setCapability("automationName", "UiAutomator2"); // Use UiAutomator2 for Android
        // Enable GPS mocking for Android
        capabilities.setCapability("gpsEnabled", true);

        driver = new AppiumDriver<>(new URL("http://127.0.1.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // Remove implicit wait

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, 10);

        // Mock the initial location (e.g., coordinates for a specific location)
        double initialLatitude = 48.8584;
        double initialLongitude = 2.2945;
        driver.setLocation(new Location(initialLatitude, initialLongitude, 0));
    }
    @Test(priority=1)
    public void testConsentHandling() throws NullPointerException, InterruptedException {
        // Variables for ID and XPath
        String consentButtonId = "travel.opas.client:id/user_consent_more_relevant";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(consentButtonId)));
        MobileElement yesRelevantAd = (MobileElement) driver.findElement(MobileBy.id(consentButtonId));
        yesRelevantAd.click();
    }
    @Test(priority=2)
    public void testFeelingLuckyFunctionality() throws InterruptedException {
        String feelingLuckyButtonId = "travel.opas.client:id/text_lucky";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(feelingLuckyButtonId)));
        MobileElement feelingLucky = (MobileElement) driver.findElement(MobileBy.id(feelingLuckyButtonId));
        feelingLucky.click();
    }
    @Test(priority=3)
    public void testGuideHandling() throws InterruptedException {
//        First next on guide
        String nextButtonId = "travel.opas.client:id/next_button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(nextButtonId)));
        MobileElement guide = (MobileElement) driver.findElement(MobileBy.id(nextButtonId));
        guide.click();

        //2nd next on guide
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(nextButtonId)));
        MobileElement guideNext = (MobileElement) driver.findElement(MobileBy.id(nextButtonId));
        guideNext.click();

        //Got it on guide
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(nextButtonId)));
        MobileElement gotIT = (MobileElement) driver.findElement(MobileBy.id(nextButtonId));
        gotIT.click();
    }
    @Test(priority=4)
    public void testLocationPermissionHandling() throws InterruptedException {
        String allowLocationButtonId = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(allowLocationButtonId)));
        MobileElement allowLocation = (MobileElement) driver.findElement(MobileBy.id(allowLocationButtonId));
        allowLocation.click();
    }
    @Test(priority=5)
    public void testStartAutoPlay() throws InterruptedException {
        String autoPlayButtonId = "travel.opas.client:id/auto_play_start_btn";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(autoPlayButtonId)));
        MobileElement autoPlay = (MobileElement) driver.findElement(MobileBy.id(autoPlayButtonId));
        autoPlay.click();
    }
    @Test(priority=6)

    public void assertPlayingAudio() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("travel.opas.client:id/action_button")));

//        MobileElement assertPlayAudio = (MobileElement) driver.findElement(MobileBy.id("travel.opas.client:id/action_button"));
//        Thread.sleep(500);
//        Assert.assertEquals(assertPlayAudio.isDisplayed(), true, "Notfound");

    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
