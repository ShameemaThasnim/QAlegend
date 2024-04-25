package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;

public class AddUserPageTest extends Base {
	@Test
	public void verifyAddUserTittle() throws IOException {
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
		AddUserPage adduser=manageuser.clickOnAddButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AddUserPage add_user= new AddUserPage(driver);
		String acutal_tittle=add_user.getTittle();
		String expected_tittle=ExcelUtility.readStringData(7, 0, Constants.ADD_USER_DATA);
		Assert.assertEquals(acutal_tittle, expected_tittle,Messages.TITTLE_MISMATCH);
		
		
	}
	@Test
public void verifyAddUser() throws IOException {
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
		AddUserPage adduser=manageuser.clickOnAddButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AddUserPage add_user= new AddUserPage(driver);
		String prefix=ExcelUtility.readStringData(0, 0, Constants.ADD_USER_DATA);
		String firstName= RandomDataUtility.getFirstName();
		String lastname= RandomDataUtility.getLastName();
		String email= firstName+"."+lastname+"123@gmail.com";
	    String pass_word=firstName+"."+lastname;
		String user_name=firstName;
		add_user.enterPrefix(prefix);
		add_user.enterFirstName(firstName);
		add_user.enterLastName(lastname);
		add_user.enterEmail(email);
		add_user.enterUserName(user_name);
		add_user.enterPassword(pass_word);
		add_user.enterConPassword(pass_word);
		UsersPage manage_s=add_user.clickOnSubmitButton();
		manageuser.clickOnSearch();
		String search_user=email;
		manageuser.enterSearchValue(search_user);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actual_user=manageuser.getSerachUser();
		
		Assert.assertEquals(actual_user, user_name,Messages.USER_CREATION_FAILED);
		}
	@Test
	public void verifyUserLoginWithNewlyAddedUser() throws IOException {
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
		AddUserPage adduser=manageuser.clickOnAddButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AddUserPage add_user= new AddUserPage(driver);
		//String prefix=ExcelUtility.readStringData(0, 0, Constants.ADD_USER_DATA);
		String firstName= RandomDataUtility.getFirstName();
		String lastname= RandomDataUtility.getLastName();
		String email= firstName+"."+lastname+"123@gmail.com";
		String pass_word=firstName+"."+lastname;
		String user_name=firstName;
		//add_user.enterPrefix(prefix);
		add_user.enterFirstName(firstName);
		add_user.enterLastName(lastname);
		add_user.enterEmail(email);
		add_user.enterUserName(user_name);
		add_user.enterPassword(pass_word);
		add_user.enterConPassword(pass_word);
		UsersPage manage_s=add_user.clickOnSubmitButton();
		manage.clickOnUserName();
		LoginPage relog=manageuser.clickOnLogOut();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String username_re=user_name;
		String password_re=pass_word;
		LoginPage login_re= new LoginPage(driver);
		login.enterUserName(username_re);
		login.enterPassword(password_re);
		HomePage home1= new HomePage(driver);
		HomePage home_2=login.clickOnLoginButton();
		//home.clickOnEndTour();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actual_user=home_2.getLoggedUser();
		String expected_user="Welcome "+firstName+",";
		Assert.assertEquals(actual_user, expected_user,Messages.RELOGIN_FAILED);
		
        
		
	}


}
