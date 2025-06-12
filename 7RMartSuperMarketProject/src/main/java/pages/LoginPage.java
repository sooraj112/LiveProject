package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")private
	WebElement dashboardtile;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")private
	WebElement invaidcredentialalertmessage;

	public void enterUsernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginbutton.click();
	}
	public boolean dashboardtiledisplayed() {
		return dashboardtile.isDisplayed();
	}

	public String getDashboardText() {
		return dashboardtile.getText();
	}

	public boolean alertDisplayed() {
		return invaidcredentialalertmessage.isDisplayed();
	}


}
