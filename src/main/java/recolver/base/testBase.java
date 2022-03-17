/**
 * 
 */
package recolver.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resolver.utility.testUtil;
import resolver.utility.webEventListner;

/**
 * This is a test base class, developer can define common selenium methods to
 * achive resubility of the code
 *
 */
public class testBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static webEventListner eventListener;

	/**
	 * This is a constructor of testBase , will initialize config property
	 */
	public testBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\Resolver_Test\\src\\main\\java\\resolver\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("my 1st error :" + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("my 2st error :" + e);
			e.printStackTrace();
		}
	}

	/**
	 * This funtion will initialize browser, browser properties and drivers
	 */
	public static void initialization() {
		String browserName = prop.getProperty("browserName");

		System.out.println("BrowserName:" + browserName);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "..//Resolver_Test/driver/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "..//Resolver_Test/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new webEventListner();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String url = prop.getProperty("url");
		System.out.println(url);
		driver.get(url);
	}

	/**
	 * This funtion will take the screenshot ans save to desire location
	 * 
	 * @throws IOException
	 */
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println("MY SCREENSHOT AT ::::::::::" + currentDir);
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	/**
	 * This functions sets the implicit wait to 0 - WebDriver's default value
	 */
	protected void removeImplicitWait() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	/**
	 * This function sets the implicit wait to the PAGE_LOAD_TIMEOUT
	 */
	protected void resetImplicitWait() {
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	/**
	 * This function will wait for the field to be display and ignore exceptions for
	 * given time span
	 * 
	 * @param field    = this is a value of he field
	 * @param waitTime = this is a value of wait time
	 */
	public void webDriverWait(By field, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(field));
		} catch (Exception ex) {
			throw new NoSuchElementException("Failed to find the element , " + field.toString(), ex);
		}
	}

	/**
	 * This function sends text to a field
	 * 
	 * @param field      = This is the Selenium By node for the field that you want
	 *                   to send text to
	 * @param value      = This is the actual text that you want to send to the
	 *                   field
	 * @param clearField = This field determines if you want to clear the field
	 *                   before sending text to it
	 * @throws Exception
	 */
	protected void sendTextToField(By field, String value, Boolean clearField) throws Exception {
		try {

			// if the field needs to be cleared, then clear it
			if (clearField) {
				driver.findElement(field).clear();
				driver.findElement(field).sendKeys(Keys.CONTROL, Keys.BACK_SPACE);
			}
			driver.findElement(field).click();
			driver.findElement(field).sendKeys(value);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * This function determines whether or not the field exist in the current page.
	 * 
	 * @param field =This is the Selenium By node for the field that you want to
	 *              check whether or not the field exists in the page.
	 * @return If the field exist on the page, then this function returns TRUE.
	 *         Otherwise, the function returns false.
	 * @throws Exception
	 */
	protected boolean isElementPresent(By field) throws Exception {
		try {
			// Removing the implicit wait temporarily for searching for the record
			removeImplicitWait();

			// If element is visible and present return true
			if (driver.findElement(field).isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			resetImplicitWait();
			throw ex;
		}
	}

	/**
	 * This function determines whether or not the field is enable in the current
	 * page.
	 * 
	 * @param field =This is the Selenium By node for the field that you want to
	 *              check whether or not the field exists in the page.
	 * @return If the field enable on the page, then this function returns TRUE.
	 *         Otherwise, the function returns false.
	 * @throws Exception
	 */
	protected boolean isElementEnable(By field) throws Exception {
		try {
			// Removing the implicit wait temporarily for searching for the record
			removeImplicitWait();

			// If element is visible and present return true
			if (driver.findElement(field).isEnabled()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			resetImplicitWait();
			throw ex;
		}
	}

	/**
	 * This function clicks a field
	 * 
	 * @param field=This is the Selenium field that you want to click
	 * @throws Exception
	 */
	protected void clickField(By field) throws Exception {

		try {
			webDriverWait(field, testUtil.WEBDRIVER_WAIT);
			driver.findElement(field).click();
		} catch (Exception ex) {

			throw ex;
		}
	}

	/**
	 * This function will count all webelements on the page by given field path
	 * 
	 * @param field This is a value of field path
	 * @return returns number of webelements display on the page
	 * @throws Exception
	 */
	protected static int countWebElement(By field) throws Exception {

		try {
			List<WebElement> li = driver.findElements(field);
			return li.size();
		} catch (Exception ex) {

			throw ex;
		}
	}

	/**
	 * This function will get nth value from webelementlist for given field
	 * 
	 * @param field = This is a value of field
	 * @param count =This is a count of web element which we want to know value
	 * @return return value of desired web element
	 * @throws Exception
	 */
	protected String getValueFromElementList(By field, int count) throws Exception {

		try {
			List<WebElement> li = driver.findElements(field);
			return li.get(count - 1).getText();
		} catch (Exception ex) {

			throw ex;
		}
	}

	/**
	 * This function will get text from given element
	 * 
	 * @param field =This is a name of the field
	 * @return returns text from the given field
	 * @throws Exception
	 */
	protected String getValueFromElement(By field) throws Exception {

		try {
			return driver.findElement(field).getText();
		} catch (Exception ex) {

			throw ex;
		}
	}

	/**
	 * This function selects a record from a select list by text
	 * 
	 * @param field = This is a name of the field
	 * @param text  = This is the text that you want to select from the select list
	 * @throws Exception
	 */
	protected void selectElementFromSelectList(By field, String text) throws Exception {
		try {
			Select dropdown = new Select(driver.findElement(field));
			dropdown.selectByVisibleText(text.trim());
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * This function will get selected value from dropdown controller
	 * 
	 * @param field =This is a value of field
	 * @return selected value of dropdown
	 * @throws Exception
	 */
	protected String getSelectedValueFromDropDown(By field) throws Exception {
		try {
			Select dropdown = new Select(driver.findElement(field));
			return dropdown.getFirstSelectedOption().getText();
		} catch (Exception ex) {
			throw ex;
		}
	}
}