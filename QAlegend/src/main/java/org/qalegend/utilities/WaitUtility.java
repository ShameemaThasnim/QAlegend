package org.qalegend.utilities;



import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public static final long IMPLICIT_WAIT=10;
	public static final long PAGE_LOAD_WAIT=20;
	public static final long EXPLICIT_WAIT=20;
	
	
public static void waitUsingImplicitWait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		}

public void waitForElement(WebDriver driver, WebElement target) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    wait.until(ExpectedConditions.visibilityOf(target));
}
public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForElementToBeClickableUsingFluentWait(WebDriver driver, WebElement target) {
                 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT)).pollingEvery(Duration.ofSeconds(PAGE_LOAD_WAIT)).ignoring(NoSuchElementException.class);
                 fluentWait.until(ExpectedConditions.elementToBeClickable(target));		 
}
public void waitForClick(WebDriver driver, WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}
}
