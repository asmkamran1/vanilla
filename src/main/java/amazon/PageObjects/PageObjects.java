package amazon.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObjects {

	public WebDriver driver;

	public PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"nav-hamburger-menu\"]")
	WebElement hamburgerMenu;

	public WebElement hamburgerMenu() {
		return hamburgerMenu;
	}

	public void clickHamburgerMenu() {
		hamburgerMenu.click();
	}

	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a/div")

	WebElement TVAppliancesElectronicsLink;

	public WebElement TVAppliancesElectronicsLink() {
		return TVAppliancesElectronicsLink;
	}

	public void clickOnTVAppliancesElectronicsLink() {
		TVAppliancesElectronicsLink.click();
	}

	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[9]/li[3]/a")
	WebElement TelevisionLink;

	public WebElement TelevisionLink() {
		return TelevisionLink;
	}

	public void clickOnTelevisionLink() {
		TelevisionLink.click();
	}

	@FindBy(xpath = "//*[@id=\"s-refinements\"]/div[21]/ul/li[4]/span/a/div/label/i")
	WebElement SamsungBrand;

	public WebElement SamsungBrand() {
		return SamsungBrand;
	}

	public void clickOnSamsungBrand() {
		SamsungBrand.click();
	}

	@FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"]/span[2]")
	WebElement sortByDropdown;

	public WebElement sortByDropdown() {
		return sortByDropdown;
	}

	public void clickDropdown() {
		sortByDropdown.click();
	}

	@FindBy(xpath = "//*[@id=\"s-result-sort-select_2\"]")
	WebElement sortHighToLow;

	public WebElement sortHighToLow() {
		return sortHighToLow;
	}

	public void clicksortHighToLow() {
		sortHighToLow.click();
	}

	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div[2]/div[1]/h2/a")
	WebElement secondHighestSamsungTV;

	public WebElement SecondHighestSamsungTV() {
		return secondHighestSamsungTV;
	}

	public void clickOnsecondHighestSamsungTV() {
		secondHighestSamsungTV.click();
	}

	@FindBy(xpath = "//*[@id=\"feature-bullets\"]/h1")
	WebElement aboutThisItem;

	public WebElement aboutThisItem() {
		return aboutThisItem;

	}

}
