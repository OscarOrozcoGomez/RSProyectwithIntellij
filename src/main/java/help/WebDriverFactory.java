package help;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class WebDriverFactory extends CapabilitiesSetUp{
	WebDriver driver;
	IOSDriver<IOSElement> mobileDriver;
	String exception;
	String step;
	public WebDriver setDriver(String typeOfDriver){
		try {
			switch (typeOfDriver) {
			case "FireFox":
				driver = new FirefoxDriver();
				break;
			case "Chrome":
				driver = new ChromeDriver();
				break;
			case "IE":
				driver = new InternetExplorerDriver();
				break;
//			case "Appium":
//				driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), iOSCapabilities(DesiredCapabilitie{""}));
//				break;
				//		case "Android":
				//			driver = new AndroidDriver();
				//			break;
				//		case "iOS":
				//			driver = new iOSDri;
				//			break;
			default:
				driver = null;
				break;
			}
		} 
		catch(WebDriverException err){
			exception = err.getMessage();
			step = "Web Driver not initialized";
		}
		finally {
			step = "Web Driver initialized";
		}
		return driver;
	}
}
