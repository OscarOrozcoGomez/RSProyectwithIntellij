package help;

import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

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
