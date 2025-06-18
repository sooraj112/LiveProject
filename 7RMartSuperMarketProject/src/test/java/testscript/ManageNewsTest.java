package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test(description = "Verifying adding a new news in Manage News page")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		HomePage homepage;
		ManageNewsPage managenews;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		managenews = homepage.clickOnmanagenewslink();
		managenews.clickOnmanagenewsnew();
		String newsn = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		managenews.enterNewNewsOnNewsField(newsn).clickOnSaveButtonOfNewNews();
		boolean isnewnewsaddalertisdisplayed = managenews.addNewsAlertDisplayed();
		Assert.assertTrue(isnewnewsaddalertisdisplayed, Messages.ADDNEWNEWSERROR);

	}

	@Test(description = "Verifying searching a new news in Manage News page")
	public void verifyWhetherUserIsAbleToSearchANews() throws IOException {
		HomePage homepage;
		ManageNewsPage managenews;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		managenews = homepage.clickOnmanagenewslink();
		managenews.clickOnManagenewsSearch();
		String sernews = ExcelUtility.getStringData(1, 0, "AdminUserPage");
		managenews.enterNewsTitleOnSearchField(sernews).clickOnSearchButtonOfNewNews();
		boolean issearchnewsdisplayed = managenews.serachManageNews();
		Assert.assertTrue(issearchnewsdisplayed, Messages.NEWSSERACHERROR);

	}

}
