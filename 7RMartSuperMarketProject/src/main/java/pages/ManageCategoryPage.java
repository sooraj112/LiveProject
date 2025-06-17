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

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	private WebElement managecategorylink;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement managecategorynew;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement newcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement categoryimageupload;
	@FindBy(xpath = "//button[@name='create'and @class='btn btn-danger']")
	private WebElement categorysavebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement addcategoryalert;
	@FindBy(xpath="//h4[text()='Search List Categories']")private WebElement searchlist;

	public void clickOnManageCategoryLink() {
		managecategorylink.click();
	}

	public void clickOnManageCategoryNew() {
		managecategorynew.click();
	}

	public void enterNewCategoryOnTitleField() {
		newcategory.sendKeys("Apple");
	}

	public void uploadImageManageCategory() {
		categoryimageupload.sendKeys(Constant.IMAGEDATAFILE);
	}

	public void pageScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void clickOnSaveButtonOfManageCategory() {

		categorysavebutton.click();
	}
	public boolean addCategoryAlertDisplayed()
	{
		return addcategoryalert.isDisplayed();
}
	public boolean serachListCategory()
	{
		return searchlist.isDisplayed();
	}

}
