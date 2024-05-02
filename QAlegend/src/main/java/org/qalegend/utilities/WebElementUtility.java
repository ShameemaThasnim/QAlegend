package org.qalegend.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtility {
public static void clickOnElement(WebElement element) 
       {
			element.click();
		}
public static void enterValue(WebElement element, String value_to_eneter)
{
	element.sendKeys(value_to_eneter);
}
public static String getText(WebElement element)
{
	return element.getText();
}
public static boolean isClicked(WebElement element) {
	try {
	element.click();
	return true;
	}
	catch(Exception e){
		return false;
	}
}
public static void scrollAndClick(WebDriver driver,WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	int x=0;
	while(!isClicked(element))
	{
		js.executeScript("window.scrollBy(0,"+x+")");
		x=x+2;
	}
}
public static boolean isElementEnabled(WebElement element)
{
	boolean status=element.isEnabled();
	return status;
}
}
