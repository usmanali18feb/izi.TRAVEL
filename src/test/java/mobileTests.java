import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class mobileTests {

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

     //  AppiumDriver<MobileElement> driver = null;
        driver = new AppiumDriver<>(new URL("http://127.0.1.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority=1)

    public void testConsentHandling() throws NullPointerException, InterruptedException {
        Thread.sleep(5000);
        MobileElement yesRelevantAd = (MobileElement) driver.findElement(MobileBy.id("travel.opas.client:id/user_consent_more_relevant"));
        Thread.sleep(500);
        Assert.assertEquals(yesRelevantAd.isDisplayed(), true, "Notfound");
        yesRelevantAd.click();
    }

    @Test(priority=2)

    public void testAroundMeFunctionality() throws InterruptedException {
        Thread.sleep(3000);
        MobileElement arroundMe = (MobileElement) driver.findElement(MobileBy.id("travel.opas.client:id/text_around"));
        Thread.sleep(500);
        Assert.assertEquals(arroundMe.isDisplayed(), true, "Notfound");
        arroundMe.click();
    }

    @Test(priority=3)

    public void testLocationPermissionHandling() throws InterruptedException {
        Thread.sleep(3000);
        MobileElement allowLocation = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        Thread.sleep(500);
        Assert.assertEquals(allowLocation.isDisplayed(), true, "Notfound");
        allowLocation.click();
    }

    @Test(priority=4)

    public void testSelectingSchool() throws InterruptedException {
        Thread.sleep(5000);
        MobileElement unitedSchool = (MobileElement) driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView"));
        Thread.sleep(500);
        Assert.assertEquals(unitedSchool.isDisplayed(), true, "Notfound");
        unitedSchool.click();
    }

    @Test(priority=5)

    public void testPlayingAudio() throws InterruptedException {
        Thread.sleep(3000);
        MobileElement playAudio = (MobileElement) driver.findElement(MobileBy.id("travel.opas.client:id/play_audio"));        playAudio.click();
        Thread.sleep(500);
        Assert.assertEquals(playAudio.isDisplayed(), true, "Notfound");
        playAudio.click();
        Thread.sleep(5000);
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
