package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPageRepo;

public class Authentication {
	
	public static String getUserName()
	{
		return Browser.getPropertyFromConfigFile(ConfigProperties.Username);
	}
	
	public static String getPassword()
	{
		return Browser.getPropertyFromConfigFile(ConfigProperties.Password);
	}
	
	public static void doLogin(WebDriver driver)
	{
		doLogin(driver,getUserName(), getPassword());
	}

	public static void doLogin(WebDriver driver, String userName,
			String password) {
		
		
		driver.findElement(By.id(LoginPageRepo.signInLinkID)).click();
		driver.findElement(By.id(LoginPageRepo.userNameID)).sendKeys(userName);
		driver.findElement(By.id(LoginPageRepo.passwordID)).sendKeys(password);
		driver.findElement(By.id(LoginPageRepo.signInID)).click();
	}

}
