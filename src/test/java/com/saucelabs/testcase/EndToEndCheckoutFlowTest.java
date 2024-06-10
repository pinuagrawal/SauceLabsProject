package com.saucelabs.testcase;

import org.testng.Assert;
import org.testng.annotations.*;

import com.saucelabs.base.BaseClass;
import com.saucelabs.constants.TestDataConstants;
import com.saucelabs.pageobjects.CheckoutComplete;
import com.saucelabs.pageobjects.LoginPage;
import com.saucelabs.pageobjects.Overview;
import com.saucelabs.pageobjects.ProductList;
import com.saucelabs.pageobjects.YourCart;
import com.saucelabs.pageobjects.YourInformation;
import com.saucelabs.utility.Log;

public class EndToEndCheckoutFlowTest extends BaseClass {
	
	private LoginPage lp;
	private ProductList pl;
	private YourCart yc;
	private YourInformation yi;
	private Overview op;
	private CheckoutComplete cc;
	
	@BeforeMethod
	public void setup(){
		launchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void endToEndCheckoutFlowTest() {
		Log.startTestCase("endToEndCheckoutFlowTest");
		lp = new LoginPage();
		Log.info("Validating user has landed to Login page");
		Assert.assertEquals(lp.getPageTitle(), TestDataConstants.LOGIN_LOGO);
		Log.info("Entering the login credentials");
		pl = lp.performLogin();
		Log.info("Validating user has landed to product list page");
		Assert.assertEquals(pl.getPageTitle(), TestDataConstants.PRODUCT_LIST_PAGE_TITLE);
		Log.info("Adding Items in cart");
		pl.addItemsToCart();
		Log.info("Verifying the number of items in cart");
		Assert.assertEquals(pl.getItemsCountInCart(),TestDataConstants.ITEM3_COUNT);
		yc = pl.clickOnCartLink();
		Log.info("Validating user has landed to Your cart page");
		Assert.assertEquals(yc.getPageTitle(), TestDataConstants.YOUR_CART_PAGE_TITLE);
		Log.info("Verifying the item details");
		Assert.assertEquals(yc.getItem1Name(), TestDataConstants.ITEM1_NAME);
		Assert.assertEquals(yc.getItem2Name(), TestDataConstants.ITEM2_NAME);
		Assert.assertEquals(yc.getItem3Name(), TestDataConstants.ITEM3_NAME);
		yi = yc.clickCheckoutButton();
		Log.info("Validating user has landed to Your info page");
		Assert.assertEquals(yi.getPageTitle(), TestDataConstants.YOUR_INFO_PAGE_TITLE);
		Log.info("Entering the details");
		yi.enterDetails();
		op = yi.clickContinueButton();
		Log.info("Validating user has landed to Overview page");
		Assert.assertEquals(op.getPageTitle(), TestDataConstants.OVERVIEW_PAGE_TITLE);
		Log.info("Verifying the item details and other labels in Overview page");
		Assert.assertEquals(op.getItem1Name(), TestDataConstants.ITEM1_NAME);
		Assert.assertEquals(op.getItem2Name(), TestDataConstants.ITEM2_NAME);
		Assert.assertEquals(op.getItem3Name(), TestDataConstants.ITEM3_NAME);
		Assert.assertEquals(op.getPaymentInfoLabel(), TestDataConstants.PAYMENT_INFO_LABEL);
		Assert.assertEquals(op.getShippingInfoLabel(), TestDataConstants.SHIPPING_INFO_LABEL);
		Assert.assertEquals(op.getTotalPriceLabel(), TestDataConstants.TOTAL_PRICE_LABEL);
		cc = op.clickContinueButton();
		Log.info("Validating user has completed the checkout");
		Assert.assertEquals(cc.getPageTitle(), TestDataConstants.CHECKOUT_COMPLETE_PAGE_TITLE);
		Assert.assertEquals(cc.getThankyouText(), TestDataConstants.THANKYOU_LABEL);
		Assert.assertEquals(cc.getOrderCompleteText(), TestDataConstants.ORDER_COMPLETE_LABEL);
		Log.endTestCase("endToEndTest");
		
	}
	
}