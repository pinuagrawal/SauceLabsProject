package com.saucelabs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.actiondriver.Action;
import com.saucelabs.base.BaseClass;

public class YourCart extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(className = "title")
	WebElement pageTitle;
	
	@FindBy(id = "item_4_title_link")
	WebElement item1Name;
	
	@FindBy(id = "item_0_title_link")
	WebElement item2Name;

	@FindBy(id = "item_1_title_link")
	WebElement item3Name;
	
	@FindBy(id = "checkout")
	WebElement checkoutButton;

	
	public  YourCart() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public String getItem1Name()  {
		String name = item1Name.getText();
		return name;	
	}
	
	public String getItem2Name()  {
		String name = item2Name.getText();
		return name;	
	}
	
	public String getItem3Name()  {
		String name = item3Name.getText();
		return name;	
	}
	
	public YourInformation clickCheckoutButton() {
		action.click(driver, checkoutButton);
		YourInformation yi = new YourInformation();
		return yi;
		
	}

}
