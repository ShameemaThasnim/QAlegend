package test;

import java.io.IOException;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.LoginPage;
import pages.ResetPage;

public class ResetPageTest extends Base{
	@Test
	public void verifyResetPageTittle() throws IOException{
		
		
		LoginPage login= new LoginPage(driver);
		ResetPage rest_page=login.clickOnForgetPassword();
		String actual_tittle=driver.getTitle();
		String expected_tittle=ExcelUtility.readStringData(0, 0, Constants.RESET_PAGE_DATA);
		Assert.assertEquals(actual_tittle, expected_tittle,Messages.TITTLE_MISMATCH);
		
	}
	@Test
	public void verifyErrorMessageWithInvalidEmailid() throws IOException{
		
		
		  LoginPage login= new LoginPage(driver);
		  ResetPage rest_page=login.clickOnForgetPassword();
		  ResetPage reset= new ResetPage(driver);
		  String email=ExcelUtility.readStringData(0, 1, Constants.RESET_PAGE_DATA);
		  reset.enterEmail(email);
		  reset.clickOnResetLink();
		  String actual_error_message=reset.getEmailErrorMessage();
		  String expected_error_message=ExcelUtility.readStringData(0, 2, Constants.RESET_PAGE_DATA);
		  Assert.assertEquals(actual_error_message, expected_error_message,Messages.EMAIL_ERROR_MISMATCH);
		  }



}
