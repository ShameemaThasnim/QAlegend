package org.qalegend.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.selenium.utilities.WebElementUtility;

public class AppUtility {
public static boolean selectValueFromRadioButton(List<WebElement> values, String value_to_select) {
		
		boolean status=false;
		for(WebElement value : values)
		{
			String text=value.getText();
			if(text.equals(value_to_select)) {
				value.click();
				status=WebElementUtility.isElementSelected(value);
				break;
			}
		}
		return status;
	}

}
