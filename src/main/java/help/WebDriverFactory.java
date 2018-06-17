package help;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    private static String exception;

    public static AppiumDriver<MobileElement> getDriver(DesiredCapabilities caps, String typeOfChannel) {
        try {
            switch (typeOfChannel) {
                case "iOS":
                    return new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

                case "Android":
                     return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
                default:
                    return null;
            }
        } catch (MalformedURLException e) {
            exception = e.getMessage();
        }
        return null;
    }
}
