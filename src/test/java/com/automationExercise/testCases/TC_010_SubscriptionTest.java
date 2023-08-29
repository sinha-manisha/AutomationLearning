package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;

public class TC_010_SubscriptionTest extends BaseClass{
	@Test(priority=0)
	public void verifySubscriptionHome() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("SubscriptionTest");
		home.scrollToFooter();
		home.subs_input("SubscriptionTest");
		home.subs_success();
	}

}
