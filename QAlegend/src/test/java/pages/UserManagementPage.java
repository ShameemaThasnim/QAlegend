package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {
	WebDriver driver;
	public UserManagementPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Users')]")
	WebElement user;
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Roles')]")
	WebElement roles;
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Sales Commission Agents')]")
	WebElement sales_commission_agents;
}
