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
import pages.UsersPage;

public class UsersPageTest extends Base{
	@Test
	public void verifyManageUserTittle() throws IOException {
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
		UsersPage manage=home.clickOnUsers();
		UsersPage manageuser= new UsersPage(driver);
		String title_actual=manageuser.getTittle();
		String title_expected=ExcelUtility.readStringData(0, 0, Constants.MANAGE_USER_DATA);
		Assert.assertEquals(title_actual, title_expected,Messages.TITTLE_MISMATCH);
		
		
	}

}
