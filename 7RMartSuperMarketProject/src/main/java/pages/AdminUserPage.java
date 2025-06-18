package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUserPage {
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	private WebElement adminusernew;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement newusername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement newpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectusertype;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectoption;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement savebutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement adminusersearch;
	@FindBy(xpath = "//input[@id='un'and @class='form-control']")
	private WebElement searchusername;
	@FindBy(xpath = "//select[@id='ut'and @class='form-control']")
	private WebElement selectsearchusertype;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchbutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement adminuseralert;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//following::td[text()='Orange']")
	private WebElement userserach;

	public AdminUserPage clickOnadminusernew() {
		adminusernew.click();
		return this;
	}

	public AdminUserPage enterNewUsernameOnUsernameField(String user) {
		newusername.sendKeys(user);
		return this;
	}

	public AdminUserPage enterNewPasswordOnPasswordField(String pass) {
		newpassword.sendKeys(pass);
		return this;
	}

	public AdminUserPage clickOnSelectUserType() {
		selectusertype.click();
		Select select = new Select(selectusertype);
		select.selectByValue("staff");
		return this;
	}

	public AdminUserPage clickOnSaveButtonOfNew() {
		savebutton.click();
		return this;
	}

	public AdminUserPage clickOnadminusersearch() {
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, adminusersearch);
		adminusersearch.click();
		return this;
	}

	public AdminUserPage enterSearchUsernameOnUsernameField(String seruser) {
		searchusername.sendKeys(seruser);
		return this;
	}

	public AdminUserPage clickOnSearchSelectUserType() {
		selectsearchusertype.click();
		Select select = new Select(selectsearchusertype);
		select.selectByValue("staff");
		return this;
	}

	public AdminUserPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}

	public boolean adminuserAlertDisplayed() {
		return adminuseralert.isDisplayed();
	}

	public String getSerachUser() {
		return userserach.getText();
	}

}
