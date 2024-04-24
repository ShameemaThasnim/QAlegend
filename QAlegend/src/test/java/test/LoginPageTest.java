package test;

import java.io.IOException;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import data_provider.DataProviders;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends Base{
	@Test
	
	public void verifyLoginPageTittle() throws IOException{
		
		String actual_tittle=driver.getTitle();
		String expected_tittle=ExcelUtility.readStringData(0, 0, Constants.LOGIN_PAGE_DATA);
		Assert.assertEquals(actual_tittle, expected_tittle,Messages.TITTLE_MISMATCH);
		
		
	}
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException{
		
		
		String username=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		String user_name=home.getLoggedUser();
		String expected_username=ExcelUtility.readStringData(0, 3, Constants.LOGIN_PAGE_DATA);
		Assert.assertEquals(user_name, expected_username,Messages.LOGIN_MISMATCH);
		
		
	
		
	}
	@Test(dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void verifyErrorMessageWhileLoggingWithInvalidCredentials(String username,String password) throws IOException{
		
		String expected_error=ExcelUtility.readStringData(1, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		//HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		String actual_error=login.getloginErrorMessage();
		Assert.assertEquals(actual_error, expected_error,Messages.LOGIN_MISMATCH);
		
		
		
		
		
	}

}
