package com.automationExercise.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.utilities.AllureReport;
@Listeners({AllureReport.class})
public class TC_025_ScrollUsingArrowKeyTest extends BaseClass{
	
	@Test
	public void verifyScrollUsingArrowKey() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("ScrollUsingArrowKeyTest");
		home.scrollDown("ScrollUsingArrowKeyTest");
		home.scrollUp("ScrollUsingArrowKeyTest");
	}

}
