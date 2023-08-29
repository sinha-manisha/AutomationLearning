package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.LoginPage;
import com.automationExercise.utilities.ReadTestData;

public class TC_004_LogOutTest extends BaseClass{
ReadTestData tdata=new ReadTestData();
	
	public String loginId=tdata.getLoginId();
	public String loginPassword=tdata.getLoginPassword();
	public String u_name=tdata.getLoginName();
	
	@Test
	public void verifyLogout() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("LogoutTest");
		home.clickSignup();
		LoginPage lp=new LoginPage();
		lp.verifyLoginPage();
		lp.setValidLoginData(loginId, loginPassword,"LogoutTest");
		home.verifyLoginMsg(u_name,"LogoutTest");
		home.clickLogout();
		lp.verifyLoginPage();
	}

}
