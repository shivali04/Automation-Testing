package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static Properties prop=new Properties();
	public static String propertyFilepath=System.getProperty("user.dir")+"/Configurations/Config.properties";
	public static WebDriver driver=null;
	public static GlobalSetup GlobalSetup=new GlobalSetup();
	public static DriverWait driverwait= new DriverWait();
	
	public static String getPropertyFromConfigFile(String property) {
		
		try {
			prop.load(new FileInputStream(propertyFilepath));
			return prop.getProperty(property);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public static DriverWait getWait() {
		return driverwait;
	}
	public static GlobalSetup getGlobalSetup() {
		return GlobalSetup;
	}
	
	public static WebDriver initialiseWebdriver() {
		return initialiseWebdriver(getPropertyFromConfigFile(ConfigProperties.BROWSER));
		
	}
	
	public static WebDriver initialiseWebdriver(String browser) {
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=Firefox.getFirefoxDriver();
		}
		return driver;
		
	}
	
	
	static class Firefox{
		public static WebDriver getFirefoxDriver() {
			return new FirefoxDriver();
			
		}
		
	}

}
