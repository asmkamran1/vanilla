package amazon.Utilities;

import java.util.Set;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {

	// create WEBDRIVER Instance and Initialize
	public static WebDriver driver;

	// Initialize Properties object which will be used to read data from properties file
	public Properties prop;

	// ................................Maximize Page..............................................//
	public void maxPage() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.err.println("issue with :" + e.getMessage());

		}
	}

	// .............................................. GET CURRENT URL......................//
	public void getURL() {
		try {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);

		} catch (Exception e) {
			System.err.println("issue is:" + e.getMessage());

		}
	}

	// .....................................IMPLICIT WAIT..............................//
	public void waitByImplicit(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println("issue with :" + e.getMessage());

		}
	}

	// .......................................HANDLE MULTIPLE WINDOW................................//
	public void windowHandler(String locators) {
		try {
			driver.findElement(By.xpath(locators)).click();
			waitByThread(3000);

			// for handle multiple windows
			Set<String> winH = driver.getWindowHandles();
			Iterator<String> itH = winH.iterator();

			String mainWin = itH.next();
			String childWin = itH.next();
			System.out.println(mainWin + " " + childWin);

			driver.switchTo().window(childWin);
			System.out.println(driver.getTitle());

			waitByThread(3000);
			driver.switchTo().window(mainWin);
			System.out.println(driver.getTitle());

		} catch (Exception e) {
			System.err.println("issue with :" + e.getMessage());

		}
	}


	// ....................................THREAD....................................//
	public void waitByThread(int time) throws InterruptedException {
		Thread.sleep(time);
	}

}
