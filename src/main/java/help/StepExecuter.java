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
    public boolean stepReceiver(String cellValue, String typeOfObject, String objectValue) throws Exception {
        try {
            switch (cellValue){
                case "Click": return clickOnElemtent(typeOfObject, objectValue);
                case "SendText": ;
                    return true;
            }
        }catch (Exception e){
            throw new Exception("The string received was not found.");
        }
        return true;
    }

}
