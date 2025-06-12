package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	
	@Test(description = "Verifying adding a new category in Manage Category page")
	public void verifyWhetherUserIsAbleToAddNewCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickOnLoginButton();
		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		managecategory.clickOnManageCategoryLink();
		managecategory.clickOnManageCategoryNew();
		//String categoryname = ExcelUtility.getStringData(0, 0, "ManageCategoryPage");
		managecategory.enterNewCategoryOnTitleField();
		managecategory.uploadImageManageCategory();
		managecategory.pageScrollDown();
		managecategory.clickOnSaveButtonOfManageCategory();
	}

}
