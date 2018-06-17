package help;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;

public class ObjectIdentifier{
    private String errorString;

    public By xpath(String xpathValue) {
        return By.xpath(xpathValue);
    }

    public By id(String idValue) {
        return By.id(idValue);
    }

    public By name(String nameValue) {
        return By.name(nameValue);
    }

    public By classObj(String classValue) {
        return By.className(classValue);
    }

    public By tagName(String tagName) {
        return By.tagName(tagName);
    }

    public By defineTypeOfIdentifier(String identifierType, String identifierValue) {
        try {
            switch (identifierType) {
                case "Xpath":
                    return xpath(identifierValue);
                case "Id":
                    return id(identifierValue);
                case "name":
                    return name(identifierValue);
                case "tag":
                    return tagName(identifierValue);
                default:
                    return null;
            }
        } catch (InvalidSelectorException e) {
            errorString = e.getMessage();
        }
        return null;
    }
}
