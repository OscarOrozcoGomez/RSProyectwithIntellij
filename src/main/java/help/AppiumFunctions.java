package help;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AppiumFunctions extends ObjectIdentifier {
    private AppiumDriver driver;
    private WebElement element;
    private String errorText;
    private boolean flag = false;

    public AppiumFunctions(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean clickOnElemtent(String byObject, String byObjectValue) {
        try {
            element = driver.findElement(defineTypeOfIdentifier(byObject, byObjectValue));
            element.click();
            return true;
        } catch (ElementNotFoundException notFound) {
            errorText = notFound.toString();
        }
        return false;
    }

    public boolean typeTextIntoTextField(String byObject, String byObjectValue, String parameter) {
        try {
            element = driver.findElement(defineTypeOfIdentifier(byObject, byObjectValue));
            element.sendKeys(parameter);
            return true;
        } catch (ElementNotFoundException notFound) {
            errorText = notFound.toString();
        }
        return false;
    }
}
