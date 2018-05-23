package help;

import java.io.FileInputStream;
import java.util.Properties;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utilities.PathsObtainer;

public class CapabilitiesSetUp extends PathsObtainer {
	private DesiredCapabilities capa;
	private Properties propertiesFile;
	private FileInputStream file;
	private String errorinFile;
	static String devName;
	static String platfName;
	static String autoName;
	static String appPath;
//This class is to set up the capabilities needed
	protected void iOSCapabilities(String devName, String platfName, String autoName, String appPath){
		try {
			file = new FileInputStream(getIosCapabilitiesPathFile());
			//file = new FileInputStream(getIosCapabilitiesPathFile());
			propertiesFile = new Properties(System.getProperties());
			propertiesFile.load(file);
			devName = propertiesFile.getProperty("DEVICE_NAME");
			platfName = propertiesFile.getProperty("PLATFORM_NAME");
			autoName = propertiesFile.getProperty("AUTOMATION_NAME");
			appPath = propertiesFile.getProperty("Root_app_path");
		} catch (Exception e) {
			errorinFile = e.getMessage();
		}
	}
	protected DesiredCapabilities androidCapabilities(String devName, String platfName, String autoName, String appPath){
		try {
			capa = new DesiredCapabilities();
			file = new FileInputStream(getIosCapabilitiesPathFile());
			propertiesFile = new Properties(System.getProperties());
			propertiesFile.load(file);
			devName = propertiesFile.getProperty("DEVICE_NAME");
			platfName = propertiesFile.getProperty("PLATFORM_NAME");
			autoName = propertiesFile.getProperty("AUTOMATION_NAME");
			appPath = propertiesFile.getProperty("Root_app_path");
		} catch (Exception e) {
			errorinFile = e.getMessage();
		}
		return capa;
	}
	public void iOSCapabilitiess(DesiredCapabilities caps){
		try {
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, this.devName);
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, this.platfName);
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			caps.setCapability(MobileCapabilityType.APP, this.appPath);
		} catch (Exception e) {
			errorinFile = e.getMessage();
		}
	}
}
