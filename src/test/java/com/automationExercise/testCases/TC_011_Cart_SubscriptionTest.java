package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.CartPage;
import com.automationExercise.pageObjects.HomePage;

public class TC_011_Cart_SubscriptionTest extends BaseClass{

	@Test(priority=0)
	public void verifyCartSubscription() {
		HomePage home=new HomePage();
		home.verifyHomePage("CartSuscriptionTest");
		home.clickCart();
		CartPage cp=new CartPage();
		cp.getFooter();
		cp.cartVerifySubscrition();
		cp.setSubsData("CartSuscriptionTest");
		cp.verifyCartSubscriptionSuccessMsg();
	}
}
