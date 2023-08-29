package com.automationExercise.testCases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.ContactPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.utilities.ReadTestData;

public class TC_006_ContactUsTest extends BaseClass{
	ReadTestData testData=new ReadTestData();
	public String u_name=testData.getContactName();
	public String u_email=testData.getContactEmail();
	public String u_sub=testData.getConatactSub();
	public String u_Cmsg=testData.getContactMsg();
	public String u_file=testData.getContactFileUpload();
			
	@Test(priority=0)
	public void verifyContactUs() throws InterruptedException, AWTException {
		HomePage home=new HomePage();
		home.verifyHomePage("ContactUsTest");
		home.clickContactUs();
		ContactPage cp=new ContactPage();
		cp.verifyContactUsPageText("ContactUsTest");
		cp.setContactFormData(u_name,u_email,u_sub, u_Cmsg,u_file);
		cp.handleOKpopup();
		cp.verifyContactFormConfirmation("ContactUsTest");
		cp.returnHome();	
		Thread.sleep(1000);
		home.verifyHomePage("ContactUsTest");
	}
}
