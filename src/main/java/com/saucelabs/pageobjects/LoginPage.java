package com.saucelabs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.actiondriver.Action;
import com.saucelabs.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(className="login_logo")
	WebElement loginLogo;
	
	@FindBy(id="user-name")
	WebElement userNameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	
	public  LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductList performLogin() {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		action.type(userNameField, username);
		action.type(passwordField, password);
		action.click(driver, loginButton);
		ProductList pl = new ProductList();
		return pl;
	}
		
	public String getPageTitle() {
		String title = loginLogo.getText();
		return title;
	}
}
