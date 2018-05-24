package help;

import java.io.FileInputStream;
import java.util.Properties;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utilities.PathsObtainer;

public class CapabilitiesSetUp extends PathsObtainer {
	private DesiredCapabilities capa = new DesiredCapabilities();
	private Properties propertiesFile;
	private FileInputStream file;
	private String errorinFile;
	private String devName;
    private String platfName;
    private String autoName;
    private String appPath;
//This class is to set up the capabilities needed
	protected void setiOSCapabilities(){
		try {
			file = new FileInputStream(getIosCapabilitiesPathFile());
			propertiesFile = new Properties(System.getProperties());
			propertiesFile.load(file);
			this.devName = propertiesFile.getProperty("DEVICE_NAME");
			this.platfName = propertiesFile.getProperty("PLATFORM_NAME");
			this.appPath = propertiesFile.getProperty("Root_app_path");
		} catch (Exception e) {
			errorinFile = e.getMessage();
		}
	}
	protected void setAndroidCapabilities(){
		try {
			file = new FileInputStream(getAndroidCapabilitiesPathFile());
			propertiesFile = new Properties(System.getProperties());
			propertiesFile.load(file);
			this.devName = propertiesFile.getProperty("DEVICE_NAME");
			this.appPath = propertiesFile.getProperty("App_path");
		} catch (Exception e) {
			errorinFile = e.getMessage();
		}
	}
	public DesiredCapabilities getiOSCapabilitiess(){
		try {
			setiOSCapabilities();
			capa.setCapability(MobileCapabilityType.DEVICE_NAME, devName);
			capa.setCapability(MobileCapabilityType.PLATFORM_NAME, platfName);
			capa.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			capa.setCapability(MobileCapabilityType.APP, appPath);
		} catch (Exception e) {
			errorinFile = e.getMessage();
		}
        return capa;
	}
	public DesiredCapabilities getAndroidCapabilities(){
		try {
			setAndroidCapabilities();
			capa.setCapability(MobileCapabilityType.DEVICE_NAME, devName);
			capa.setCapability(MobileCapabilityType.APP, appPath);
		} catch (NullPointerException e){
            errorinFile = e.getMessage();
        }
        return capa;
	}

	public DesiredCapabilities setUpCapabilirties(String platform){
		/*if (platform.equalsIgnoreCase("Android")){
            getAndroidCapabilities();
		}else if(platform.equalsIgnoreCase("iOS")) {
            getiOSCapabilitiess();
		}
		else{

        }*/
		switch (platform){
            case "iOS": return  getiOSCapabilitiess();
            case "Android": return getAndroidCapabilities();
            default: return null;
        }
    }

	public static void main(String[] args) {
		CapabilitiesSetUp no = new CapabilitiesSetUp();
		no.getAndroidCapabilities();
	}
}
