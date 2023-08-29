package com.automationExercise.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

public class ContactPage extends BaseClass{
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='contact-form']/h2") WebElement contactPageMsg;
	@FindBy(xpath="//div/input[@name='name']") WebElement name;
	@FindBy(xpath="//div/input[@name='email']") WebElement email;
	@FindBy(xpath="//div/input[@name='subject']") WebElement subject;
	@FindBy(id="message") WebElement message;
	@FindBy(xpath="//input[@type='file']") WebElement uploadFile;
	@FindBy(xpath="//div/input[@name='submit']") WebElement submit_btn;
	
	@FindBy(xpath="//div/div[@class='status alert alert-success']") WebElement success_msg;
	@FindBy(xpath="//div/a[@class='btn btn-success']") WebElement home_btn;
	
	public void verifyContactUsPageText(String testFolder) {
		if(contactPageMsg.getText().equalsIgnoreCase(contactUsText))
		{
			Log.info("Navigated to Contact us Page");
			captureScreenshot("Contact_Us",testFolder);
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Contact Us page Verification Failed");
			captureScreenshot("Contact_Us_failed",testFolder);
			Assert.assertTrue(false);
		}
	}
	public void setContactFormData(String uname, String uemail,String usubject,String umsg ,String ufileupload) throws InterruptedException, AWTException
	{
		
		name.sendKeys(uname);
		email.sendKeys(uemail);
		subject.sendKeys(usubject);
		message.sendKeys(umsg);
		Log.info("Uploading the file");
//		uploadFile.sendKeys(ufileupload);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uploadFile);
		Robot rb= new Robot();
		
		StringSelection ss =new StringSelection(ufileupload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		rb.delay(3000);
		//press Ctrl
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		//key release
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		//press Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		captureScreenshot("ContactUsTest","ContactUs_data");
//		uploadFile.sendKeys();
		submit_btn.click();
		Log.info("Contact us form filled and clicked submit button");
		Thread.sleep(2000);
	}
	public void handleOKpopup() {
		driver.switchTo().alert().accept();
		Log.info("Accepted the popup");
	}
	public void verifyContactFormConfirmation(String folder) {
		if(success_msg.getText().equalsIgnoreCase("Success! Your details have been submitted successfully."))
		{
			Log.info("Verified the Contact Us page Confirmation message");
			Assert.assertTrue(true);
			captureScreenshot(folder,"Contact_Us_Msg");
		}
		else
		{
			Log.info("Conatct us confirmation message verification Failed");
			Assert.assertFalse(false);
			captureScreenshot(folder,"Contact_Us_Msg_Fail");
		}
	}
	public void returnHome() {
		Log.info("Navigated back to home page");
		home_btn.click();
	}

}
