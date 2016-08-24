package utility;

import org.openqa.selenium.WebDriver;

public class GlobalSetup {
	
	private boolean setUp=false;
	private WebDriver driver;
	
	public void GlobalSetupMethod() {
		
		
		if(isSetUp()==false)
		{
			setDriver(Browser.initialiseWebdriver());
			setSetUp(true);
		}
		else {
			//setDriver(Browser.initialiseWebdriver());
			
		}
	}
	
	
	public boolean isSetUp() {
		return setUp;
	}
	public void setSetUp(boolean setUp) {
		this.setUp = setUp;
	}
	public WebDriver getDriver() {
		GlobalSetupMethod();
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	

}
