package com.saucelabs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.actiondriver.Action;
import com.saucelabs.base.BaseClass;

public class CheckoutComplete extends BaseClass{
	
Action action = new Action();
	
	@FindBy(className = "title")
	WebElement pageTitle;
	
	@FindBy(className = "complete-header")
	WebElement thankYouText;
	
	@FindBy(className = "complete-text")
	WebElement orderCompleteText;
	
	public  CheckoutComplete() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public String getThankyouText() {
		String title = thankYouText.getText();
		return title;
	}
	
	public String getOrderCompleteText() {
		String title = orderCompleteText.getText();
		return title;
	}
	



}
