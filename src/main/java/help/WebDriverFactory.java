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

    private void getAndroidDriver(DesiredCapabilities caps) {
        try {
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }catch (MalformedURLException e) {

        }
    }
    private void getiOSDriver(DesiredCapabilities caps) {
        try {
            iOSDriver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {

        }
    }
    public void initializeMobileDriver(String typeOfDriver, DesiredCapabilities caps){
        if (typeOfDriver.equalsIgnoreCase("iOS")){
            getiOSDriver(caps);
        }else if (typeOfDriver.equalsIgnoreCase("Android")){
            getAndroidDriver(caps);
        }
    }
}
