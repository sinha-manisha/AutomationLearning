package com.automationExercise.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

public class TestPage extends BaseClass{
	public TestPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div/h2/b[contains(text(),'Test Cases')]")WebElement testPageTxt;
	public void verifyTestPage(String folder) {
		String title=driver.getTitle();
		if(title.equalsIgnoreCase(testPageTitle))
		{
			Log.info("Test Cases Page Title is verified");
			Assert.assertTrue(true);
			if(testPageTxt.getText().equalsIgnoreCase("Test Cases"))
			{
				Log.info("Navigated to Test Cases Page and verified");
				Assert.assertTrue(true);
				captureScreenshot(folder,"Test_Cases_Page");
			}
			else
			{
				Log.info("Test cases Page Verification failed");
				captureScreenshot(folder,"Test_Cases_Page_Fail");
				Assert.assertTrue(false);
				
			}
		}
		else
		{
			Log.info("Test Cases page title verification failed");
			Assert.assertTrue(false);
		}
	}

}
