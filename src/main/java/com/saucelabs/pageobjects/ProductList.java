package com.saucelabs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.actiondriver.Action;
import com.saucelabs.base.BaseClass;

public class ProductList extends BaseClass {
	
	Action action = new Action();
	 
	@FindBy(className = "title")
	WebElement pageTitle;
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement item1AddToCart;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement item2AddToCart;

	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement item3AddToCart;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cartLink;

	@FindBy(className = "shopping_cart_badge")
	WebElement itemsCountInCart;
	
	public  ProductList() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public void addItemsToCart() {
		action.click(driver, item1AddToCart);
		action.click(driver, item2AddToCart);
		action.click(driver, item3AddToCart);
	}
	
	public String getItemsCountInCart() {
		String count = itemsCountInCart.getText();
		return count;
	}
	
	public YourCart clickOnCartLink() {
		action.click(driver, cartLink);
		YourCart yc = new YourCart();
		return yc;
	}

}
