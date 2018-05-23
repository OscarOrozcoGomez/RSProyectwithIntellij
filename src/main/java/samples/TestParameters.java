package samples;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
public class TestParameters{
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        d.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        d.setCapability(MobileCapabilityType.APP, "/Users/oscar orozco/Library/Developer/Xcode/DerivedData/Rousesales-cwuiotcndhvhofaaofegozkoskdb/Build/Products/QA-iphonesimulator/Rouse Sales.app");
        IOSDriver<IOSElement> driver = new IOSDriver<> (new URL("http://127.0.0.1:4723/wd/hub"), d);
        driver.quit();

    }

}
