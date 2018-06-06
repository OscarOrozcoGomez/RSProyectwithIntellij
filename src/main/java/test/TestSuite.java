package test;

import help.CapabilitiesSetUp;
import help.ExcelReader;
import help.WebDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import help.StepExecuter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestSuite {
    String globalValue;
    CapabilitiesSetUp capabilities = new CapabilitiesSetUp();
    DesiredCapabilities caps = new DesiredCapabilities();
    AppiumDriver driver;
    ExcelReader excelReader = new ExcelReader();
    StepExecuter stepExecuter;

    @Test(dataProvider = "AdminFlows")
    public void run(String platformName, String tcName, String excelSuiteFileName, String sheetName) {
        try {
            //We need to start with the SetUp annotations
            caps = capabilities.setUpCapabilirties(platformName);
            driver = WebDriverFactory.getDriver(caps, platformName);
            for(Object[] steps :excelReader.gettingMatrixValues(excelSuiteFileName, sheetName)){
                stepExecuter = new StepExecuter(driver);
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                stepExecuter.stepReceiver(steps[0].toString(), steps[1].toString(), steps[2].toString(),steps[3].toString(), steps[4].toString());
                /*for(Object stepText: steps){
                    stepExecuter = new StepExecuter(driver);
                    stepExecuter.stepReceiver(stepText[0].toString(), steps[1].toString(), steps[2].toString(),steps[3].toString(), steps[4].toString());
                }*/
            }
        }/*catch (FileNotFoundException err){
            globalValue = err.getMessage();
        } */catch (Exception e) {
            e.printStackTrace();
        }

    }

    @DataProvider(name = "AdminFlows")
    public Object[][] dataFeeder() {
        //This method will read the admin suite
        return excelReader.gettingMatrixValues("AdminMatrix", "Matrix");
    }
@AfterTest
    public void tearDown(){
        driver.closeApp();
        driver.quit();
}
}
