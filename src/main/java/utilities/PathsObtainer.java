package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PathsObtainer {
	private Properties properties;
	private FileInputStream fileInputStream;
	private  String errorinFile;

	protected String getMatrixPath(){
		File file = getPathsFromPropertiesFile();
		try{
			fileInputStream = new FileInputStream(file.getAbsolutePath() + "/Paths.properties");
			properties = new Properties(System.getProperties());
			properties.load(fileInputStream);
		}catch(IOException err){
			errorinFile = err.getMessage();
		}
		return properties.getProperty("Matrix");
	}
	/***
	 * @return - This method returns the path for the iOS capabilities 
	 */
	public  String getIosCapabilitiesPathFile() {
		File file = getPathsFromPropertiesFile();
		try {
			fileInputStream = new FileInputStream(file.getAbsolutePath() + "/Paths.properties");
			properties = new Properties(System.getProperties());
			properties.load(fileInputStream);
		} catch (Exception e) {
			errorinFile = e.getMessage();
		}
		return file.getAbsolutePath() + properties.getProperty("iOSCapabilitiesFile");
	}
	/***
	 * @return - This method returns the path for the iOS capabilities 
	 */
	public  String getAndroidCapabilitiesPathFile() {
		try {
			File file = getPathsFromPropertiesFile();
			fileInputStream = new FileInputStream(file);
			properties = new Properties(System.getProperties());
			properties.load(fileInputStream);
		} catch (Exception e) {
			errorinFile = e.getMessage();
		}
		return properties.getProperty("iOSCapabilitiesFile");
	}
	
	protected File getPathsFromPropertiesFile() {
		File srcFolder = new File("src/main/java/utilities");
		return srcFolder;
	}

}