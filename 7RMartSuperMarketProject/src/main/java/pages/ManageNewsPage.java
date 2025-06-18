package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement managenewsnew;
	@FindBy(xpath = "//textarea[@name='news'and @id='news']")
	private WebElement newnews;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement savebutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement managenewssearch;
	@FindBy(xpath = "//input[@class='form-control'and @placeholder='Title']")
	private WebElement serachnews;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement addnewsalert;
	@FindBy(xpath = "//h4[text()='Search Manage News']")
	private WebElement searchnews;

	public ManageNewsPage clickOnmanagenewsnew() {
		managenewsnew.click();
		return this;
	}

	public ManageNewsPage enterNewNewsOnNewsField(String newsn) {
		newnews.sendKeys(newsn);
		return this;
	}

	public ManageNewsPage clickOnSaveButtonOfNewNews() {
		savebutton.click();
		return this;
	}

	public ManageNewsPage clickOnManagenewsSearch() {
		managenewssearch.click();
		return this;
	}

	public ManageNewsPage enterNewsTitleOnSearchField(String sernews) {
		serachnews.sendKeys(sernews);
		return this;
	}

	public ManageNewsPage clickOnSearchButtonOfNewNews() {
		searchbutton.click();
		return this;
	}

	public boolean addNewsAlertDisplayed() {
		return addnewsalert.isDisplayed();
	}

	public boolean serachManageNews() {
		return searchnews.isDisplayed();
	}

}
