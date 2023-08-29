package com.automationExercise.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.RegisterPage;
import com.automationExercise.utilities.ReadTestData;
import com.automationExercise.utilities.ExtentReport;
@Listeners({ExtentReport.class})
public class TC_001_RegisterUserTest extends BaseClass{
	
	ReadTestData tdata=new ReadTestData();
	public String u_title=tdata.getTitle();
	public String u_name=tdata.getName();
	public String u_password=tdata.getPassword();
	public String u_dob_day=tdata.getDoBDay();
	public String u_dob_month=tdata.getDobMonth();
	public String u_dob_year=tdata.getDobYear();
	public String u_lname=tdata.getLName();
	public String u_company=tdata.getCompany();
	public String u_address1=tdata.getAddress1();
	public String u_address2=tdata.getAddress2();
	public String u_country=tdata.getCountry();
	public String u_state=tdata.getState();
	public String u_city=tdata.getCity();
	public String u_pin=tdata.getPin();
	public String u_mobile=tdata.getMobile();
	
	@Test(priority=0)
	public void verifyRegisterPage() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("RegisterUserTest");
		home.verifyLogo();
		home.clickSignup();
		RegisterPage reg=new RegisterPage();
		reg.verifySignUpPage("RegisterUserTest");
		reg.setNameEmail(u_name,"RegisterUserTest");
		reg.verifySignUpText();
		reg.setSignUpData(u_title, u_password, u_dob_day, u_dob_month,
				u_dob_year, u_name, u_lname, u_company, u_address1, u_address2,
				u_country, u_state, u_city, u_pin, u_mobile,"RegisterUserTest");
		reg.verifyAccountCreation("RegisterUserTest");
		home.verifyLoginMsg(u_name,"RegisterUserTest");
		home.deleteAcc();
		home.verifyDeleteAccount();
	}

}
