package samples;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PruebaDeDriver {
    IOSDriver<IOSElement> driver;
    @BeforeTest
    public void setUP() throws MalformedURLException {
        DesiredCapabilities d = new DesiredCapabilities();
        //d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        d.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
        //d.setCapability(MobileCapabilityType.UDID, "A51FAB85-29AE-4069-8C62-E5471E593014");
        d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        d.setCapability(MobileCapabilityType.APP, "/Users/oscar orozco/Library/Developer/Xcode/DerivedData/Rousesales-fjsnynnpcpexfxahpccrdeeghcef/Build/Products/Develop-iphonesimulator/Rouse Sales.app");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), d);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test() {
        try {
            driver.findElementById("Allow").click();
            driver.findElementByXPath("//XCUIElementTypeTextField").sendKeys("test");
            driver.findElementByName(("Continue")).click();
        }catch (ElementNotFoundException e){
            System.out.println(e);
        }

    }

    @AfterTest
    public void tear() {
        driver.quit();
    }


}
