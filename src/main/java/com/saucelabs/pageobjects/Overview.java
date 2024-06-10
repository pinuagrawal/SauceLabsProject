package com.saucelabs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.actiondriver.Action;
import com.saucelabs.base.BaseClass;

public class Overview extends BaseClass {
	
Action action = new Action();
	
	@FindBy(className = "title")
	WebElement pageTitle;
	
	@FindBy(id = "item_4_title_link")
	WebElement item1Name;
	
	@FindBy(id = "item_0_title_link")
	WebElement item2Name;

	@FindBy(id = "item_1_title_link")
	WebElement item3Name;
	
	@FindBy(xpath = "//*[@data-test=\"payment-info-label\"]")
	WebElement paymentInfolabel;
	
	@FindBy(xpath = "//*[@data-test=\"shipping-info-label\"]")
	WebElement shippingInfoLabel;
	
	@FindBy(xpath = "//*[@data-test=\"total-info-label\"]")
	WebElement totalPriceLable;
	
	@FindBy(id = "finish")
	WebElement finishButton;

	
	public  Overview() {
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
	
	public String getPaymentInfoLabel()  {
		String name = paymentInfolabel.getText();
		return name;	
	}
	
	public String getShippingInfoLabel()  {
		String name = shippingInfoLabel.getText();
		return name;	
	}
	
	public String getTotalPriceLabel()  {
		String name = totalPriceLable.getText();
		return name;	
	}
	
	public CheckoutComplete clickContinueButton() {
		action.click(driver, finishButton);
		CheckoutComplete cc = new CheckoutComplete();
		return cc;
	}

}
