package help;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class StepExecuter extends AppiumFunctions{
    private AppiumDriver driver;
    private String actualResult;
    public StepExecuter(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }
    //public boolean stepReceiver(String cellValue, String typeOfObject, String objectValue) throws Exception {
    public boolean stepReceiver(String keyWord, String byObject, String byObjectValue, String parameter, String testCaseStep) {
        try {
            switch (keyWord){
                case "Click": return clickOnElemtent(byObject, byObjectValue);
                case "SendText": return typeTextIntoTextField(byObject, byObjectValue, parameter);
                default: return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
