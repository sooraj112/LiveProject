package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class ManageCategoryPage {

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement managecategorynew;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement newcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement categoryimageupload;
	@FindBy(xpath = "//button[@name='create'and @class='btn btn-danger']")
	private WebElement categorysavebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement addcategoryalert;
	@FindBy(xpath = "//h4[text()='Search List Categories']")
	private WebElement searchlist;

	public ManageCategoryPage clickOnManageCategoryNew() {
		managecategorynew.click();
		return this;
	}

	public ManageCategoryPage enterNewCategoryOnTitleField() {
		newcategory.sendKeys("Apple");
		return this;
	}

	public ManageCategoryPage uploadImageManageCategory() {
		categoryimageupload.sendKeys(Constant.IMAGEDATAFILE);
		return this;
	}

	public ManageCategoryPage pageScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		return this;
	}

	public ManageCategoryPage clickOnSaveButtonOfManageCategory() {

		categorysavebutton.click();
		return this;
	}

	public boolean addCategoryAlertDisplayed() {
		return addcategoryalert.isDisplayed();
	}

	public boolean serachListCategory() {
		return searchlist.isDisplayed();
	}

}
