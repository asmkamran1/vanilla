package homepage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon.PageObjects.PageObjects;
import amazon.Utilities.Base;

public class AmazonTest extends Base {

// Scenario 1: Verify that user is able to go to landing page	

	@Test
	public void landingPage() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("url"));
		System.out.println("Passed: user is able to access landing page");

	}

// Scenario 2: Verify that user is able to scroll to Shop by Department and click on Television department

	@Test(dependsOnMethods = { "landingPage" })
	public void shopByDepartment() throws IOException {
		PageObjects obj = new PageObjects(driver);
		obj.clickHamburgerMenu();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", obj.TVAppliancesElectronicsLink());
		obj.clickOnTVAppliancesElectronicsLink();
		obj.clickOnTelevisionLink();

	}

//Scenario 3: verify that user is able to select Samsung brand TV under shop by department

	@Test(dependsOnMethods = { "shopByDepartment" })
	public void shopSamsungTV() throws InterruptedException {
		PageObjects obj = new PageObjects(driver);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", obj.SamsungBrand());
		obj.clickOnSamsungBrand();

	}

// Scenario 4: Verify that user is able to sort the search result from high to low

	@Test(dependsOnMethods = { "shopSamsungTV" })
	public void sortHighToLow() {
		PageObjects obj = new PageObjects(driver);
		obj.clickDropdown();
		obj.clicksortHighToLow();
	}

//Scenario 5: Verify that user is able to choose the 2nd search result of Samsung TV

	@Test(dependsOnMethods = { "sortHighToLow" })
	public void select2ndSearchResult() throws InterruptedException {
		PageObjects obj = new PageObjects(driver);
		// It will return the parent window name as a String
		String parentWin = driver.getWindowHandle();
		obj.clickOnsecondHighestSamsungTV();
		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parentWin.equals(child_window)) {
				driver.switchTo().window(child_window);

				// Now verify that "About this item" element is displayed in the page
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("arguments[0].scrollIntoView(true);", obj.aboutThisItem());
				boolean b = obj.aboutThisItem().isDisplayed();
				Assert.assertTrue(b);
				waitByThread(3000);

			}

		}
	}
}
