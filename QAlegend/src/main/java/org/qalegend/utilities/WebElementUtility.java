package org.qalegend.utilities;

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


}
