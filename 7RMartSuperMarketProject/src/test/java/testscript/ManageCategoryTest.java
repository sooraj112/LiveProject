package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {

	@Test(description = "Verifying adding a new category in Manage Category page")
	public void verifyWhetherUserIsAbleToAddNewCategory() throws IOException {
		HomePage homepage;
		ManageCategoryPage managecategory;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		managecategory = homepage.clickOnManageCategoryLink();
		managecategory.clickOnManageCategoryNew();
		// String categoryname = ExcelUtility.getStringData(0, 0, "ManageCategoryPage");
		managecategory.enterNewCategoryOnTitleField().uploadImageManageCategory().pageScrollDown()
				.clickOnSaveButtonOfManageCategory();
		boolean isaddcategoryalertdisplayed = managecategory.addCategoryAlertDisplayed();
		Assert.assertTrue(isaddcategoryalertdisplayed, Messages.ADDNEWCATEGORYERROR);
	}

}
