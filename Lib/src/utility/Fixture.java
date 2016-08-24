package utility;

import org.openqa.selenium.WebDriver;

public class Fixture {
	
	public static WebDriver setFixture() {
		
		WebDriver driver=Browser.getGlobalSetup().getDriver();
		
		driver.get(Browser.getPropertyFromConfigFile(ConfigProperties.IP));
		return driver;
		
		
	}

}
