package scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.PersonalPageRepo;
import utility.Authentication;
import utility.Browser;
import utility.Fixture;

public class Homeshop18 {

	private static WebDriver driver = null;
	private static WebDriverWait wait = null;
	private ArrayList<String> expectedList;
	private ArrayList<String> actualList;

	private List<WebElement> options;

	// private String BaseWindowHandle= null;

	@BeforeClass
	public void setUp() {
		driver = Fixture.setFixture();
		Browser.getWait().getWait(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void loginTest() throws ClientProtocolException, IOException,
			InterruptedException {

		Authentication.doLogin(driver);

	}

	@Test(priority = 2)
	public void allCategories() {

		expectedList = new ArrayList<String>();
		expectedList.add("All Stores");
		expectedList.add("Accessories");
		expectedList.add("Appliances");
		expectedList.add("Automobiles");
		expectedList.add("Cameras");
		expectedList.add("Clothing");
		expectedList.add("Computers");
		expectedList.add("Electronics");
		expectedList.add("Food & Groceries");
		expectedList.add("Footwear");
		expectedList.add("Gifts");
		expectedList.add("Health & Beauty");
		expectedList.add("Home & Kitchen");
		expectedList.add("Jewellery");
		expectedList.add("Kids & Toys");
		expectedList.add("Mobiles");
		expectedList.add("Sports & Fitness");
		expectedList.add("Stationery");
		expectedList.add("Watches");

		actualList = new ArrayList<String>();

		try {

			Select select = new Select(driver.findElement(By
					.id(PersonalPageRepo.allStoreDropdownID)));
			options = select.getOptions();
			for (WebElement element : options) {

				actualList.add(element.getText());
				System.out.println("" + element.getText());

			}

			Assert.assertEquals(actualList, expectedList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// -------------------
	@Test(priority = 3)
	public void personalInformationDetils() {

		try {

			wait = new WebDriverWait(driver, 30);

			System.out.println("Title::" + driver.getTitle());

			String expectedTitle = "Online Shopping India - Shop Online for Mobiles, Cameras, Home & Kitchen, Appliances, Jewellery, Fashion, Health & Beauty – HomeShop18.com";

			Assert.assertEquals(driver.getTitle(), expectedTitle);

			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By
							.id(PersonalPageRepo.myAccountlinkID)))).click();
			wait.until(
					ExpectedConditions.elementToBeClickable(driver.findElement(By
							.cssSelector(PersonalPageRepo.personalInfoButtonCSS))))
					.click();
			/*
			 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement
			 * (By.cssSelector(PersonalPageRepo.photoCSS)))).click();
			 * wait.until(
			 * ExpectedConditions.elementToBeClickable(driver.findElement
			 * (By.cssSelector(PersonalPageRepo.browsePhotoCSS)))).sendKeys(
			 * "C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");
			 * wait.until
			 * (ExpectedConditions.elementToBeClickable(driver.findElement
			 * (By.cssSelector(PersonalPageRepo.uploadimageCSS)))).click();
			 */

			selectDropDownValueByVisibleText(
					driver.findElement(By.id(PersonalPageRepo.salutationID)),
					"Mr.");
			textBoxSet(By.id(PersonalPageRepo.firstNameID), "abc");
			textBoxSet(By.id(PersonalPageRepo.lastNameID), "abc");
			selectDropDownValueByVisibleText(
					driver.findElement(By.id(PersonalPageRepo.genderID)),
					"Male");
			buttonClick(By.cssSelector(PersonalPageRepo.saveButtonCSS));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Succes:::"+wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(PersonalPageRepo.successMesaageCSS)))).getText());

		// ------------------------------------------------
		/*
		 * 
		 * 
		 * 
		 * /*
		 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id
		 * (PersonalPageRepo.cartID)))).click();
		 * wait.until(ExpectedConditions.visibilityOf
		 * (driver.findElement(By.id(PersonalPageRepo
		 * .startShoppingCSS)))).click(); System.out.println("TEXT:::"+
		 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(
		 * PersonalPageRepo.allProductCSS)))).getText());
		 */

	}
	
	@Test(priority=4)
	public void Logout(){
		
		buttonClick(By.cssSelector(PersonalPageRepo.signOutCSS));
	}

	protected void buttonClick(By address) {
		driver.findElement(address).click();
	}

	protected void textBoxSet(By address, String value) {
		driver.findElement(address).click();
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(value);
	}

	public void selectDropDownValueByVisibleText(WebElement element,
			String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	/*
	 * @AfterClass(alwaysRun = true) public void tearDown() {
	 * Fixtures.tearDownFixture(driver); }
	 */

}
