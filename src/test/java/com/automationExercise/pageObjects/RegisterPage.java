package com.automationExercise.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

import io.qameta.allure.Step;

public class RegisterPage extends BaseClass{
	
	public RegisterPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='signup-form']/h2")WebElement RegConfirm;
	
	@FindBy(xpath="//form/input[@name='name']") WebElement name;
	@FindBy(xpath="//form/input[@data-qa='signup-email']") WebElement email;
	@FindBy(xpath="//form/button[@data-qa='signup-button']") WebElement signupbtn;
	@FindBy(xpath="//div[@class='login-form']/h2/b")WebElement chk_signup_page;
	
	@FindBy(id="id_gender1")	WebElement male;
	@FindBy(id="id_gender2")	WebElement female;
	@FindBy(id="password")		WebElement password;
	@FindBy(id="days")			WebElement dob_day;
	@FindBy(id="months")		WebElement dob_month;
	@FindBy(id="years")			WebElement dob_year;
	@FindBy(id="newsletter")	WebElement newsletter;
	@FindBy(id="optin")			WebElement offers;
	
	@FindBy(id="first_name")	WebElement f_name;
	@FindBy(id="last_name")		WebElement l_name;
	@FindBy(id="company")		WebElement u_company;
	@FindBy(id="address1")		WebElement u_add1;
	@FindBy(id="address2")		WebElement u_add2;
	@FindBy(id="country")		WebElement u_country;
	@FindBy(id="state")			WebElement u_state;
	@FindBy(id="city")			WebElement u_city;
	@FindBy(id="zipcode")		WebElement u_pin;
	@FindBy(id="mobile_number")	WebElement u_mobile;
	
	@FindBy(xpath="//button[text()='Create Account']")WebElement btn_submit;
	
	@FindBy(xpath="//div/h2/b")	WebElement acc_create_msg;
	@FindBy(xpath="//div/a[text()='Continue']") WebElement btn_continue;
	
	@FindBy(xpath="//form[@action='/signup']/p") WebElement already_register_msg;
	
	
	public String getConfirmMsg() {
		return RegConfirm.getText();
	}
	public void setName(String uname) {
		name.sendKeys(uname);
	}
	public void setEmail(String uemail) {
		email.sendKeys(uemail);
	}
	public void clickSignUp() {
		signupbtn.click();
	}
	public String getSignUpText() {
		return chk_signup_page.getText();
	}
	public void setTitle(String utitle) {
		if(utitle.equalsIgnoreCase("Mr."))
			male.click();
		else
			female.click();	
	}
	public void setPassword(String upassword) {
		password.sendKeys(upassword);
	}
	public void setdobDay(String day) {
		dob_day.sendKeys(day);
	}
	public void setdobMonth(String month) {
		dob_month.sendKeys(month);
	}
	public void setdobYear(String year) {
		dob_year.sendKeys(year);
	}
	public void clickNewsletter() {
		newsletter.click();
	}
	public void clickOffer() {
		offers.click();
	}
	
	public void setFName(String fname) {
		f_name.sendKeys(fname);
	}
	public void setLName(String lname) {
		l_name.sendKeys(lname);
	}
	public void setCompany(String ucompany) {
		u_company.sendKeys(ucompany);
	}
	public void setAddress1(String uaddress1) {
		u_add1.sendKeys(uaddress1);
	}
	public void setAddress2(String uaddress2) {
		u_add2.sendKeys(uaddress2);
	}
	public void setCountry(String ucountry) {
		u_country.sendKeys(ucountry);
	}
	public void setState(String ustate) {
		u_state.sendKeys(ustate);
	}
	public void setCity(String ucity) {
		u_city.sendKeys(ucity);
	}
	public void setZip(String upin) {
		u_pin.sendKeys(upin);
	}
	public void setMobile(String umobile) {
		u_mobile.sendKeys(umobile);
	}
	public void clickSubmit() {
		btn_submit.click();
	}
	public String createAccMsg() {
		return acc_create_msg.getText();
	}
	
	public void clickContnueBtn() {
		btn_continue.click();
	}
	public void verifySignUpPage(String testFolder) {
		
		if(getConfirmMsg().equalsIgnoreCase(signupText))
			{
				captureScreenshot(testFolder,"SignUp");
				Log.info("Navigated to Signup/Register page");
				Assert.assertTrue(true);
			}
			else {
				captureScreenshot(testFolder,"SignUp_fail");
				Log.info("Sign up page verification failed");
				Assert.assertTrue(false);
			}
	}
	@Step("Filling all details in Signup and create account")
	public void setNameEmail(String un,String folder) throws InterruptedException
	{
		setName(un);
		String email=randomstring()+"@gmail.com";
		setEmail(email);
		captureScreenshot(folder,"SignUp_data");
		Thread.sleep(2000);
		//Clicking Signup
		clickSignUp();
		Log.info("Provided Name and Email and clicked Signup button");
	}
	
	public void verifySignUpText() {
		//checking for signup form text
		if(getSignUpText().equals(signupForm))
		{
			Log.info("Signup form text visible and verified");
			Assert.assertTrue(true);
		}
		else {
			Log.info("Signup page  text verification failed");
			Assert.assertTrue(false);
		}
	}
	public void setSignUpData(String ut,String upass,String ud
			,String um,String uy,String un,String uln
			,String ucom,String uadd1,String uadd2,String ucountry,String ustate,String ucity
			,String upin,String umobile, String folder
			) throws InterruptedException
	{
		//entering form data
		
		setTitle(ut);
		setPassword(upass);
		//setting DoB
		setdobDay(ud);
		setdobMonth(um);
		setdobYear(uy);
		clickNewsletter();
		clickOffer();
		Log.info("Provided Title,Password,DoB, and checked check boxes");
		Thread.sleep(2000);
		
		//setting name company address country state city zipcode mobile number
		setFName(un);
		setLName(uln);
		setCompany(ucom);
		setAddress1(uadd1);
		setAddress2(uadd2);
		setCountry(ucountry);
		setState(ustate);
		setCity(ucity);
		setZip(upin);
		setMobile(umobile);
		Log.info("Provided Name,company, address,country, state,city,pincode,mobile no");
		captureScreenshot(folder,"Register_data");
		Thread.sleep(2000);
		//submitting the form
		clickSubmit();
		Log.info("Submitted the registration form");
	}
	@Step("Verifying 'ACCOUNT CREATED!' and clicking 'Continue' button")
	public void verifyAccountCreation(String folder) throws InterruptedException {
		//Checking account created
		if(createAccMsg().equalsIgnoreCase(accountCreated))
		{
			Log.info("Account is created");
			clickContnueBtn();
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Account is not created, Something went wrong");
			captureScreenshot(folder,"AccCre_Vari_fail");
			Assert.assertTrue(false);
		}
	}
	public void setAlreadyRegisteredData(String name,String email,String folder) throws InterruptedException
	{
		setName(name);
		setEmail(email);
		captureScreenshot(folder,"Registered_data");
		//Clicking Signup
		clickSignUp();
		Log.info("Provided Name and already Registered Email and clicked Signup button");
	}
	public void getRegisteredMsg(String folder) {
		if(already_register_msg.getText().equalsIgnoreCase("Email Address already exist!"))
				{
					Log.info("Email Already exist message received");
					captureScreenshot(folder,"Email_Exist");
					Assert.assertTrue(true);
				}
		else {
			Log.info("Email Already exist message not received");
			captureScreenshot(folder,"Email_ExistMsg_fail");
			Assert.assertTrue(false);
			
		}
	}

}
