package test;

import java.io.IOException;
import java.time.Duration;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserManagementPage;

public class UserManagementPageTest extends Base{
	@Test(priority=12,groups="Regression")
	public void verifyUserManagementOPtionUsers() 
	{
	String username=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
	String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
	LoginPage login= new LoginPage(driver);
	login.enterUserName(username);
	login.enterPassword(password);
	HomePage home= new HomePage(driver);
	HomePage home_=login.clickOnLoginButton();
	home.clickOnEndTour();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	home.clickOnUserManagement();
	UserManagementPage usermanagementpage_obj= new UserManagementPage(driver);
	boolean user_status=usermanagementpage_obj.isUserEnable();
	Assert.assertTrue(user_status, Messages.USER_MANAGEMENT_OPTION_STATUS);
	}
	@Test(priority=13,groups="Regression")
	public void verifyUserManagementOPtionRoles() 
	{
		String username=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		home.clickOnEndTour();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		home.clickOnUserManagement();
		UserManagementPage usermanagementpage_obj= new UserManagementPage(driver);
		boolean roles_status=usermanagementpage_obj.isRoleEnable();
		Assert.assertTrue(roles_status, Messages.USER_MANAGEMENT_OPTION_STATUS);
		}
	@Test(priority=14,groups="Sanity")
	public void verifyUserManagementOPtionSales() 
	{
		String username=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		home.clickOnEndTour();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		home.clickOnUserManagement();
		UserManagementPage usermanagementpage_obj= new UserManagementPage(driver);
		boolean sales_status=usermanagementpage_obj.isSaleEnable();
		Assert.assertTrue(sales_status, Messages.USER_MANAGEMENT_OPTION_STATUS);
		}
}
