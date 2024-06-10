package com.saucelabs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.actiondriver.Action;
import com.saucelabs.base.BaseClass;

public class YourInformation extends BaseClass {

Action action = new Action();
	
	@FindBy(className = "title")
	WebElement pageTitle;
	
	@FindBy(id = "first-name")
	WebElement firstNameField;
	
	@FindBy(id = "last-name")
	WebElement lastNameField;

	@FindBy(id = "postal-code")
	WebElement postalCodeField;
	
	@FindBy(id = "continue")
	WebElement continueButton;

	
	public  YourInformation() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public void enterDetails() {
		action.click(driver, firstNameField);
		action.type(firstNameField, prop.getProperty("firstName"));
		action.click(driver, lastNameField);
		action.type(lastNameField, prop.getProperty("lastName"));
		action.click(driver, postalCodeField);
		action.type(postalCodeField, prop.getProperty("postalCode"));	
	}
	
	public Overview clickContinueButton() {
		action.click(driver, continueButton);
		Overview op = new Overview();
		return op;
	}
}
