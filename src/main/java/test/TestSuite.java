package test;

import com.relevantcodes.extentreports.LogStatus;
import help.CapabilitiesSetUp;
import help.ExcelReader;
import help.WebDriverFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestSuite {
    String globalValue;
    CapabilitiesSetUp capabilities = new CapabilitiesSetUp();
    DesiredCapabilities caps = new DesiredCapabilities();
    WebDriverFactory driver = new WebDriverFactory();
    @Test(dataProvider = "AdminFlows")
    public void run(String platformName, String tcName, String sheetName, String userName, String password){
    //We need to start with the SetUp annotations
        caps = capabilities.setUpCapabilirties(platformName);
        driver.initializeMobileDriver(platformName, caps);

    }
    @DataProvider(name = "AdminFlows")
    public Object[][] dataFeeder() throws IOException, InvalidFormatException {
        //This method will read the admin suite
        ExcelReader no = new ExcelReader();
        return no.gettingMatrixValues("AdminMatrix", "Matrix");
    }
}
