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

	@FindBy(xpath = "//i[@class='fas fa-arrow-circle-right']")
	private WebElement adminuserlink;
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

	public void clickOnadminuserlink() {
		adminuserlink.click();
	}

	public void clickOnadminusernew() {
		adminusernew.click();
	}

	public void enterNewUsernameOnUsernameField(String user) {
		newusername.sendKeys(user);
	}

	public void enterNewPasswordOnPasswordField(String pass) {
		newpassword.sendKeys(pass);
	}

	public void clickOnSelectUserType() {
		selectusertype.click();
		Select select = new Select(selectusertype);
		select.selectByValue("staff");
	}

	public void clickOnSaveButtonOfNew() {
		savebutton.click();
	}

	public void clickOnadminusersearch() {
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, adminusersearch);
		adminusersearch.click();
	}

	public void enterSearchUsernameOnUsernameField(String seruser) {
		searchusername.sendKeys(seruser);
	}

	public void clickOnSearchSelectUserType() {
		selectsearchusertype.click();
		Select select = new Select(selectsearchusertype);
		select.selectByValue("staff");
	}

	public void clickOnSearchButton() {
		searchbutton.click();
	}
	
	public boolean adminuserAlertDisplayed() {
		return adminuseralert.isDisplayed();
	}

	public String getSerachUser() {
		return userserach.getText();
	}

}
