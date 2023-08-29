package com.automationExercise.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.utilities.ExtentReport;
@Listeners({ExtentReport.class})
public class TC_000_HomePageTest extends BaseClass{
	
	@Test(priority=0)
	public void verifyHomePage() {
		HomePage home=new HomePage();
		home.verifyHomePage("HomeTest");
		home.verifyLogo();
	}

}
