package test;

import java.io.IOException;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base{
	@Test
	public void verifyHomePageTittle() throws IOException {
		String username=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		String actual_tittle=home.getTittle();
		String expected_tittle=ExcelUtility.readStringData(0, 0, Constants.HOME_PAGE_DATA);
		Assert.assertEquals(actual_tittle, expected_tittle,Messages.TITTLE_MISMATCH);
	   }
	@Test
	public void verifyUserLoginDate() throws IOException{
		String username=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		String actual_logindate = home.getLoginDate();
		String expected_logindate = home.getCurrentDate();
		Assert.assertEquals(actual_logindate, expected_logindate, Messages.LOGIN_DATE_FAILED);
		
	}
	
}
