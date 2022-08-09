package amazon.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends GenericMethods {

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();

		// Code to Load the properties file and read properties from the file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\kamra\\eclipse-workspace\\Git\\vanilla\\src\\main\\java\\vanillaData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		maxPage();
		waitByImplicit(10);
		return driver;

	}

	@AfterClass
	public void tearDown() {
		driver.close();
		System.out.println("Browser is closed.");
	}
}
