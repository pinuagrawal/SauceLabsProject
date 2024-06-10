package com.saucelabs.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	//Added all user actions abstract methods to achieve Abstraction  
	public void click(WebDriver ldriver, WebElement ele);
	public boolean isDisplayed(WebDriver ldriver, WebElement ele);
	public boolean type(WebElement ele, String text);
	public boolean findElement(WebDriver ldriver, WebElement ele);
	public boolean isSelected(WebDriver ldriver, WebElement ele);
	public boolean isEnabled(WebDriver ldriver, WebElement ele);
	

}
