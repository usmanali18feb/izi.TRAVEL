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

public class mobileTests {
    private  AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set desired capabilities for Android
        capabilities.setCapability("platformName", "Android");
      //  capabilities.setCapability("deviceName", "34251751090002X");
        capabilities.setCapability("deviceName", "emulator-5554");
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
        double initialLatitude = 37.7749;
        double initialLongitude = -122.4194;
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

    public void testAroundMeFunctionality() throws InterruptedException {
        String aroundMeButtonId = "travel.opas.client:id/text_around";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(aroundMeButtonId)));
        MobileElement arroundMe = (MobileElement) driver.findElement(MobileBy.id(aroundMeButtonId));
        arroundMe.click();
    }

    @Test(priority=3)

    public void testLocationPermissionHandling() throws InterruptedException {
        String locationPermissionButtonId = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(locationPermissionButtonId)));
        MobileElement allowLocation = (MobileElement) driver.findElement(MobileBy.id(locationPermissionButtonId));
        allowLocation.click();
    }

    @Test(priority=4)

    public void testSelectingSchool() throws InterruptedException {
        String selectingSchoolButtonXPath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(selectingSchoolButtonXPath)));
        MobileElement allowLocation = (MobileElement) driver.findElement(MobileBy.xpath(selectingSchoolButtonXPath));
        allowLocation.click();
    }

    @Test(priority=5)

    public void testPlayingAudio() throws InterruptedException {
        String playAudioButtonId = "travel.opas.client:id/play_audio";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(playAudioButtonId)));
        MobileElement allowLocation = (MobileElement) driver.findElement(MobileBy.id(playAudioButtonId));
        allowLocation.click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
