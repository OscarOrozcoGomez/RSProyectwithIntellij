package help;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    String exception;
    private AppiumDriver getDriver(DesiredCapabilities caps, String typeOfChannel) {
        try {
            switch(typeOfChannel){
                case "iOS": AppiumDriver<IOSElement> iOSdriver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
                    return iOSdriver;

                case "Android": AppiumDriver<AndroidElement> AndroidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
                    return AndroidDriver;
                default: return null;
            }
        } catch (MalformedURLException e) {
            exception = e.getMessage();
        }
        return null;
    }
}
