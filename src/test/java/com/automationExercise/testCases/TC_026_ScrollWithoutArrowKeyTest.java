package com.automationExercise.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.utilities.AllureReport;
@Listeners({AllureReport.class})
public class TC_026_ScrollWithoutArrowKeyTest extends BaseClass {
	@Test
	public void verifyScrollWithoutArrowKey() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("ScrollWithoutArrowKeyTest");
		home.scrollDown("ScrollWithoutArrowKeyTest");
		home.scrollUpWithoutUpButton("ScrollWithoutArrowKeyTest");
	}

}
