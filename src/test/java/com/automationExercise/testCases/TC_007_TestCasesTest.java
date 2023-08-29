package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.TestPage;

public class TC_007_TestCasesTest extends BaseClass{
	@Test(priority=0)
	public void verifyTestCasePage() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("TestCaseTest");
		home.clickTest();
		TestPage tp=new TestPage();
		tp.verifyTestPage("TestCaseTest");
	}

}
