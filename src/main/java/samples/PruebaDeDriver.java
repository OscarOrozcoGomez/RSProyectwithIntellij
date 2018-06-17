package samples;

import com.google.common.base.Function;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class PruebaDeDriver {
    AppiumDriver<AndroidElement> driver;
//    @BeforeTest
//    public void setUP() throws MalformedURLException {
//        DesiredCapabilities d = new DesiredCapabilities();
//        //d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
//        d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
//        d.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//        d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
//        //d.setCapability(MobileCapabilityType.UDID, "A51FAB85-29AE-4069-8C62-E5471E593014");
//        d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//        d.setCapability("newCommandTimeout", "90");
//        d.setCapability(MobileCapabilityType.APP, "/Users/oscar orozco/Library/Developer/Xcode/DerivedData/Rousesales-fjsnynnpcpexfxahpccrdeeghcef/Build/Products/Develop-iphonesimulator/Rouse Sales.app");
//        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), d);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//    }
    @BeforeTest
    public void setUP() throws MalformedURLException, InterruptedException {
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability(MobileCapabilityType.DEVICE_NAME, "DeviceAndroid");
        d.setCapability(MobileCapabilityType.APP, "/Users/Application/RSMA-Green-DEV-Debug.apk");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), d);
    }

    @Test
    public void test() {
        FluentWait<AppiumDriver<AndroidElement>> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(WebDriverException.class);

        MobileElement element = wait.until((Function<MobileDriver, MobileElement>) driver -> {
            System.out.print("si jala");
            return (MobileElement) driver.findElement(By.id("et_auth_code"));
        });
            element.sendKeys("Tets");
    }

    @AfterTest
    public void tear() {
        driver.quit();
    }


}
