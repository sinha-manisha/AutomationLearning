package com.automationExercise.pageObjects;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

import io.qameta.allure.Step;

public class OrderConfirmationPage extends BaseClass{
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li/a[contains(text(),'Delete')]") WebElement delete_Acc;
	@FindBy(xpath="//div/a[@data-qa='continue-button']") WebElement continue_link;
	@FindBy(xpath="//div/a[text()='Download Invoice']") WebElement download_invoice_link;
	@FindBy(xpath="//div/p[contains(text(),'Congratulations')]") WebElement order_conf_msg;
	 @Step("Clicking 'Download Invoice' button")
	public void downloadInvoice() {
		download_invoice_link.click();
		Log.info("Downloading the invoice");
	}
	 @Step("Verifying invoice is downloaded successfully")
	public void verifyFileDownload() throws InterruptedException {
		Thread.sleep(3000);
		String path=".//DownloadFile";
		File folder=new File(path);
		File[] files=new File(folder.getPath()).listFiles();
		int s=files.length;
		if(s>0)
		{
			Log.info("File is downloaded successfully and verified");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("File is not downloaded verification failed");
			Assert.assertTrue(false);
		}
		
	}
	@Step("Clicking 'Continue' button")
	public void clickContinue() {
		Log.info("Clicking continue...");
		continue_link.click();
	}
	@Step("Clicking 'Delete Account' button")
	public void deleteAcc() {
		Log.info("Clicking Account Delete button");
		delete_Acc.click();
	}
	@Step("Verifying success message")
	public void oderConfirmMsg(String folder) {
		if(order_conf_msg.getText().equalsIgnoreCase("Congratulations! Your order has been confirmed!"))
		{
			Log.info("Verified payment success message");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Verification of payment success message failed");
			captureScreenshot(folder,"payment_success_msg_fail");
			Assert.assertTrue(false);
		}
	}
}
