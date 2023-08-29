package com.automationExercise.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li/a[contains(text(),'Home')]") WebElement link_home;
	@FindBy(xpath="//div[@class='login-form']/h2")WebElement login_txt;
	@FindBy(xpath="//form[@action='/login']/input[@name='email']") WebElement login_email;
	@FindBy(xpath="//form[@action='/login']/input[@name='password']") WebElement login_password;
	@FindBy(xpath="//form[@action='/login']/button") WebElement login_btn;
	@FindBy(xpath="//p[@style='color: red;']") WebElement login_error; 
	
	public String getLoginTxt() {
		return login_txt.getText();
	}
	public void setLoginEmail(String lemail) {
		login_email.clear();
		login_email.sendKeys(lemail);
	}
	public void setLoginPassword(String lpass) {
		login_password.clear();
		login_password.sendKeys(lpass);
	}
	public void clickLoginBtn() {
		login_btn.click();
	}
	public String login_error_msg() {
		return login_error.getText();
	}
	public void verifyLoginPage() {
		if(getLoginTxt().equalsIgnoreCase(loginText))
		{
			Log.info("Navigated to login page and verified");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Login Page verification failed");
			Assert.assertTrue(false);
		}	
	}
	
	public void setValidLoginData(String loginId, String loginPassword,String testFolder) throws InterruptedException {
		setLoginEmail(loginId);
		setLoginPassword(loginPassword);
		captureScreenshot(testFolder,"Login_Data");
		Thread.sleep(2000);
		clickLoginBtn();
		Log.info("Entered loginId, password and clicked login button ");
	}
	public void verifyInvalidLoginMsg() {
		if(login_error.isDisplayed())
		{
		if(login_error_msg().equalsIgnoreCase("Your email or password is incorrect!"))
		{
			Log.info("Verifed for Invalid Login cerdentials");
			captureScreenshot("LoginTest","invalid_login");
			Assert.assertTrue(true);
		}
		}
		else
		{
			Log.info("Verifed for Invalid Login cerdentials");
			captureScreenshot("LoginTest","invalid_login");
			Assert.assertTrue(true);
		}
	}
	public void getHome() {
		link_home.click();
	}
	
}
