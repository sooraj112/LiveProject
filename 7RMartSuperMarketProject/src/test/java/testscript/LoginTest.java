package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description = "", priority = 1)
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		boolean isdashboarddisplayed=loginpage.dashboardtiledisplayed();
		//Assert.assertTrue(isdashboarddisplayed,Messages.VALIDCREDENTIALERROR);
		String expected="Dashboard";
		String actual=loginpage.getDashboardText();
		Assert.assertEquals(actual, expected,Messages.VALIDCREDENTIALERROR);
	}

	@Test(description = "Verifying user login with invalid username", priority = 2)
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		boolean isalertdisplayed=loginpage.alertDisplayed();
		Assert.assertTrue(isalertdisplayed,Messages.INVALIDUSERNAMEANDVAILDPASSWORDERROR);
	}

	@Test(description = "Verifying user login with invalid password", priority = 3)
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		boolean  isalertdisplayed=loginpage.alertDisplayed();
		//Assert.assertFalse(isdashboarddisplayed,Messages.VALIDUSERNAMEANDINVAILDPASSWORDERROR);
		Assert.assertTrue(isalertdisplayed,Messages.VALIDUSERNAMEANDINVAILDPASSWORDERROR);
	}

	@Test(description = "Verifying user login with invalid credentials", priority = 4)
	public void verifyUserLoginWithInvalidCredential() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		boolean  isalertdisplayed=loginpage.alertDisplayed();
		Assert.assertTrue(isalertdisplayed,Messages.INVALIDCREDENTIALERROR);
	}

}
