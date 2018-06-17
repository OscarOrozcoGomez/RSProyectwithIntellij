package help;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StepExecuter extends AppiumFunctions{
    //public boolean stepReceiver(String cellValue, String typeOfObject, String objectValue) throws Exception {
    public boolean stepReceiver(AppiumDriver<MobileElement> driver, String keyWord, String byObject, String byObjectValue, String parameter, String testCaseStep) {
        try {
            switch (keyWord){
                case "Click": return clickOnElemtent(driver, byObject, byObjectValue);
                case "SendText": return typeTextIntoTextField(driver, byObject, byObjectValue, parameter);
                default: return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
