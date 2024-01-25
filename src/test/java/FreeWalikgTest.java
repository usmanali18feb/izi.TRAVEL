import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class FreeWalikgTest {
    private  AppiumDriver<MobileElement> driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set desired capabilities for Android
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "34251751090002X");
        capabilities.setCapability("app", "/home/qa/Downloads/izi.TRAVEL.apk");
        capabilities.setCapability("appPackage", "travel.opas.client");
        capabilities.setCapability("automationName", "UiAutomator2"); // Use UiAutomator2 for Android
        // Enable GPS mocking for Android
        capabilities.setCapability("gpsEnabled", true);
        //  AppiumDriver<MobileElement> driver = null;
        driver = new AppiumDriver<>(new URL("http://127.0.1.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Mock the initial location (e.g., coordinates for a specific location)
        double initialLatitude = 48.8584;
        double initialLongitude = 2.2945;
        driver.setLocation(new Location(initialLatitude, initialLongitude,0));
    }
    @Test(priority=1)
    public void testConsentHandling() throws NullPointerException, InterruptedException {
        Thread.sleep(2500);
        MobileElement yesRelevantAd = (MobileElement) driver.findElement(MobileBy.id("travel.opas.client:id/user_consent_more_relevant"));
        Thread.sleep(500);
        Assert.assertEquals(yesRelevantAd.isDisplayed(), true, "Notfound");
        yesRelevantAd.click();
    }
    @Test(priority=2)
    public void testFeelingLuckyFunctionality() throws InterruptedException {
        Thread.sleep(2500);
        MobileElement feelingLucky = (MobileElement) driver.findElement(MobileBy.id("travel.opas.client:id/text_lucky"));
        Thread.sleep(500);
        Assert.assertEquals(feelingLucky.isDisplayed(), true, "Notfound");
        feelingLucky.click();
    }
    @Test(priority=3)
    public void testGuideHandling() throws InterruptedException {
        Thread.sleep(2500);
        //First next on guide
        MobileElement guide = (MobileElement) driver.findElementById("travel.opas.client:id/next_button");
        Thread.sleep(500);
        Assert.assertEquals(guide.isDisplayed(), true, "Notfound");
        guide.click();

        //2nd next on guide
        Thread.sleep(500);
        MobileElement guideNext = (MobileElement) driver.findElementById("travel.opas.client:id/next_button");
        Thread.sleep(500);
        Assert.assertEquals(guideNext.isDisplayed(), true, "Notfound");
        guideNext.click();

        //Got it on guide
        Thread.sleep(500);
        MobileElement gotIT = (MobileElement) driver.findElementById("travel.opas.client:id/next_button");
        Thread.sleep(500);
        Assert.assertEquals(gotIT.isDisplayed(), true, "Notfound");
        gotIT.click();
    }
    @Test(priority=4)
    public void testLocationPermissionHandling() throws InterruptedException {
        Thread.sleep(2500);
        MobileElement allowLocation = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        Thread.sleep(500);
        Assert.assertEquals(allowLocation.isDisplayed(), true, "Notfound");
        allowLocation.click();

    }
    @Test(priority=5)
    public void testStartAutoPlay() throws InterruptedException {
        Thread.sleep(2500);
        MobileElement autoPlay = (MobileElement) driver.findElementById("travel.opas.client:id/auto_play_start_btn");
        Thread.sleep(500);
        Assert.assertEquals(autoPlay.isDisplayed(), true, "Notfound");
        autoPlay.click();
        Thread.sleep(5000);
    }
    @Test(priority=6)

    public void assertPlayingAudio() throws InterruptedException {
        MobileElement assertPlayAudio = (MobileElement) driver.findElement(MobileBy.id("travel.opas.client:id/action_button"));
        Thread.sleep(500);
        Assert.assertEquals(assertPlayAudio.isDisplayed(), true, "Notfound");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
