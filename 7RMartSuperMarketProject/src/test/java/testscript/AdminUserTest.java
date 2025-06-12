package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {

	@Test(description = "Verifying adding a new user in Admin User page",retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser.clickOnadminuserlink();
		adminuser.clickOnadminusernew();
		FakerUtility fakerutility = new FakerUtility();
		String user = fakerutility.createRandomUsername();
		String pass = fakerutility.createRandomPassword();
		adminuser.enterNewUsernameOnUsernameField(user);
		adminuser.enterNewPasswordOnPasswordField(pass);
		adminuser.clickOnSelectUserType();
		adminuser.clickOnSaveButtonOfNew();
		boolean isadminuseralertdisplayed=adminuser.adminuserAlertDisplayed();
		Assert.assertTrue(isadminuseralertdisplayed,Messages.ADDNEWADMINUSERERROR);

	}

	@Test(description = "Verifying searching a user in Admin User page")
	public void verifyWhetherUserIsAbleToSearchAUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser.clickOnadminuserlink();
		adminuser.clickOnadminusersearch();
		String seruser = ExcelUtility.getStringData(1, 0, "AdminUserPage");
		adminuser.enterSearchUsernameOnUsernameField(seruser);
		adminuser.clickOnSearchSelectUserType();
		adminuser.clickOnSearchButton();
		String expected="Orange";
		String actual=adminuser.getSerachUser();
		Assert.assertEquals(actual,expected,Messages.ADMINUSERSEARCHERROR);
	}

}
