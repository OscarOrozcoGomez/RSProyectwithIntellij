package test;

import help.CapabilitiesSetUp;
import help.ExcelReader;
import help.WebDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestSuite {
    String globalValue;
    CapabilitiesSetUp capabilities = new CapabilitiesSetUp();
    DesiredCapabilities caps = new DesiredCapabilities();
    AppiumDriver appiumDriver;
    AppiumDriver driver;
    ExcelReader no;
    @Test(dataProvider = "AdminFlows")
    public void run(String platformName, String tcName, String excelSuiteFileName, String sheetName){
    //We need to start with the SetUp annotations
        caps = capabilities.setUpCapabilirties(platformName);
        driver = WebDriverFactory.getDriver(caps, platformName);
        if (driver != null) {
            //no.stepsReader(no.gettingMatrixValues(excelSuiteFileName, sheetName));

            driver.findElement(By.id("Allow")).click();
            driver.findElement(By.xpath("//XCUIElementTypeTextField[@type='XCUIElementTypeTextField']")).sendKeys("test");
            driver.findElement(By.name("CONTINUE")).click();
        }
        }

    @DataProvider(name = "AdminFlows")
    public Object[][] dataFeeder() throws IOException, InvalidFormatException {
        //This method will read the admin suite
        no = new ExcelReader();
        return no.gettingMatrixValues("AdminMatrix", "Matrix");
    }
}
