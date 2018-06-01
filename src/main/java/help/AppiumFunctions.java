package help;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class AppiumFunctions extends ObjectIdentifier {
    private AppiumDriver driver;
    private WebElement element;
    private String errorText;
    private boolean flag = false;

    public AppiumFunctions(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean clickOnElemtent(String identifier, String identifierValue) {
        try {
            element = driver.findElement(defineTypeOfIdentifier(identifier, identifierValue));
            element.click();
            flag = true;
        } catch (ElementNotFoundException notFound) {
            errorText = notFound.toString();
        }
        return flag;
    }
}
