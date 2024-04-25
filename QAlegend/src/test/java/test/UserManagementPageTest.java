package test;

import java.io.IOException;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.utilities.ExcelUtility;

import pages.HomePage;
import pages.LoginPage;

public class UserManagementPageTest extends Base{
	public void verifyUserManagementOPtion() throws IOException{
	String username=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
	String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
	LoginPage login= new LoginPage(driver);
	login.enterUserName(username);
	login.enterPassword(password);
	HomePage home= new HomePage(driver);
	HomePage home_=login.clickOnLoginButton();
	}
}
