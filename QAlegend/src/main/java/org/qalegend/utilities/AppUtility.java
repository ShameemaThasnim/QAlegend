package org.qalegend.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;


public class AppUtility {
public static boolean verifyOptionsUnderUserManagementIsEnabled(List<WebElement> values, String value_to_select) {
		
		boolean status=false;
		for(WebElement value : values)
		{
			String text=value.getText();
			if(text.equals(value_to_select)) {
				//value.click();
				status=WebElementUtility.isElementEnabled(value);
				break;
			}
		}
		return status;
	}


}
