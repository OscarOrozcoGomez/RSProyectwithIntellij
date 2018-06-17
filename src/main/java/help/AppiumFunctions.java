package help;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class AppiumFunctions extends ObjectIdentifier {
    public MobileElement element;
    private String errorText;
    private boolean flag = false;

    public boolean clickOnElemtent(AppiumDriver<MobileElement> driver, String byObject, String byObjectValue){
        FluentWait<AppiumDriver<MobileElement>> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
         element = wait.until(new Function<MobileDriver, MobileElement>() {
            @Override
            public MobileElement apply(MobileDriver driver) {
                System.out.print("si jala");
                return (MobileElement) driver.findElement(By.id("et_auth_code"));
            }
        });
            if(element.isDisplayed()){
                element.sendKeys("Tets");
                return true;
            }
        return false;
    }

    public boolean typeTextIntoTextField(MobileDriver driver, String byObject, String byObjectValue, String parameter){
            if(element.isDisplayed()){
                element.sendKeys(parameter);
                return true;
            }
            return false;
    }
}
