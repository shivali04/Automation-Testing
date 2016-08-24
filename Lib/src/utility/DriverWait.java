package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWait {
	
	private WebDriverWait wait;

	public WebDriverWait getWait(WebDriver driver) {
		wait=new WebDriverWait(driver, 10);
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

}
