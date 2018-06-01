package help;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;

public class ObjectIdentifier {
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

    protected By defineTypeOfIdentifier(String identifierType, String identifierValue) {
        try {
            switch (identifierType) {
                case "Xpath":
                    return xpath(identifierValue);
                case "Id":
                    return id(identifierValue);
                default:
                    return null;
            }
        } catch (InvalidSelectorException e) {
            errorString = e.getMessage();
        }
        return null;
    }
}
