package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description = "Verifying successful user logout")
	public void verifyWhetherUserIsAbleToLogoutSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminLink();
		homepage.clickOnLogoutlink();
		boolean istitledisplayed=homepage.titleDisplayed();
		Assert.assertTrue(istitledisplayed,Messages.HOMEPAGEERROR);
	}

}
