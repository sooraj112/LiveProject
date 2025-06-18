package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description = "", priority = 1, groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		boolean isdashboarddisplayed = loginpage.dashboardtiledisplayed();
		// Assert.assertTrue(isdashboarddisplayed,Messages.VALIDCREDENTIALERROR);
		String expected = "Dashboard";
		String actual = loginpage.getDashboardText();
		Assert.assertEquals(actual, expected, Messages.VALIDCREDENTIALERROR);
	}

	@Test(description = "Verifying user login with invalid username", priority = 2)
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordField(password).clickOnLoginButton();
		boolean isalertdisplayed = loginpage.alertDisplayed();
		Assert.assertTrue(isalertdisplayed, Messages.INVALIDUSERNAMEANDVAILDPASSWORDERROR);
	}

	@Test(description = "Verifying user login with invalid password", priority = 3)
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordField(password).clickOnLoginButton();
		boolean isalertdisplayed = loginpage.alertDisplayed();
		// Assert.assertFalse(isdashboarddisplayed,Messages.VALIDUSERNAMEANDINVAILDPASSWORDERROR);
		Assert.assertTrue(isalertdisplayed, Messages.VALIDUSERNAMEANDINVAILDPASSWORDERROR);
	}

	@Test(description = "Verifying user login with invalid credentials", priority = 4, groups = {
			"smoke" }, dataProvider = "logindata")
	public void verifyUserLoginWithInvalidCredential(String username, String password) throws IOException {
		// String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		// String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordField(password).clickOnLoginButton();
		boolean isalertdisplayed = loginpage.alertDisplayed();
		Assert.assertTrue(isalertdisplayed, Messages.INVALIDCREDENTIALERROR);
	}

	@DataProvider(name = "logindata")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "test", "test1" }, new Object[] { "test1", "test2" }, new Object[] {
				ExcelUtility.getStringData(3, 0, "LoginPage"), ExcelUtility.getStringData(3, 1, "LoginPage") } };
	}

}
