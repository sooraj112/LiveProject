package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test(description = "Verifying adding a new news in Manage News page")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnmanagenewslink();
		managenews.clickOnmanagenewsnew();
		String newsn = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		managenews.enterNewNewsOnNewsField(newsn);
		managenews.clickOnSaveButtonOfNewNews();

	}

	@Test(description = "Verifying searching a new news in Manage News page")
	public void verifyWhetherUserIsAbleToSearchANews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnmanagenewslink();
		managenews.clickOnManagenewsSearch();
		String sernews = ExcelUtility.getStringData(1, 0, "AdminUserPage");
		managenews.enterNewsTitleOnSearchField(sernews);
		managenews.clickOnSearchButtonOfNewNews();

	}

}
