package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.RegisterPage;
import com.automationExercise.utilities.ReadTestData;

public class TC_005_RegisteredEmailTest extends BaseClass{
ReadTestData tdata=new ReadTestData();
	
	public String loginId=tdata.getLoginId();
	public String u_name=tdata.getLoginName();
	@Test(priority=0)
	public void verifyRegisteredEmail() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("RegisteredEmailTest");
		home.clickSignup();
		RegisterPage reg=new RegisterPage();
		reg.verifySignUpPage("RegisteredEmailTest");
		reg.setAlreadyRegisteredData(u_name, loginId,"RegisteredEmailTest");	
		reg.getRegisteredMsg("RegisteredEmailTest");
	}

}
