package help;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory extends CapabilitiesSetUp {
    IOSDriver<IOSElement> iOSDriver;
    AndroidDriver<AndroidElement> androidDriver;
    String exception;
    String step;

    public AndroidDriver<AndroidElement> getAndroidDriver(DesiredCapabilities caps) {
        try {
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }catch (MalformedURLException e) {

        }
        return androidDriver;
    }
    public IOSDriver<IOSElement> getiOSDriver(DesiredCapabilities caps) {
        try {
            iOSDriver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {

        }
        return iOSDriver;
    }
}
