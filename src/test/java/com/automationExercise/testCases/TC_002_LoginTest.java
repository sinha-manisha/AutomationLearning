package com.automationExercise.testCases;


import org.testng.annotations.Listeners;
import com.automationExercise.utilities.ExtentReport;
import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.LoginPage;
import com.automationExercise.utilities.ReadTestData;
@Listeners({ExtentReport.class})
public class TC_002_LoginTest extends BaseClass{
	ReadTestData tdata=new ReadTestData();
	
	public String loginId=tdata.getLoginId();
	public String loginPassword=tdata.getLoginPassword();
	public String u_name=tdata.getLoginName();
	
	@Test
	public void verifyLogin() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("LoginTest");
		home.verifyLogo();
		home.clickSignup();
		LoginPage lp=new LoginPage();
		lp.verifyLoginPage();
		lp.setValidLoginData(loginId, loginPassword,"LoginTest");
		home.verifyLoginMsg(u_name,"LoginTest");
		//home.deleteAcc();
		//home.verifyDeleteAccount();
	}
}
