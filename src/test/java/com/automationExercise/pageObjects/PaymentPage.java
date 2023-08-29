package com.automationExercise.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

import io.qameta.allure.Step;

public class PaymentPage extends BaseClass{
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div/input[@data-qa='name-on-card']") WebElement name_on_card;
	@FindBy(xpath="//div/input[@data-qa='card-number']") WebElement card_number;
	@FindBy(xpath="//div/input[@data-qa='cvc']") WebElement cvc;
	@FindBy(xpath="//div/input[@data-qa='expiry-month']") WebElement exp_month;
	@FindBy(xpath="//div/input[@data-qa='expiry-year']") WebElement exp_year;
	@FindBy(xpath="//div/button[@data-qa='pay-button']") WebElement payment_btn;
	
	@FindBy(xpath="//div/div[@id='success_message']/div") WebElement success_msg;
	@Step("Entering payment details: Name on Card, Card Number, CVC, Expiration date and Clicking 'Pay and Confirm Order' button")
	public void setPaymentData(String name, String c_no, String c_cvc, String c_expMM, String c_expYYYY, String folder,String testName)
	{
		name_on_card.sendKeys(name);
		card_number.sendKeys(c_no);
		cvc.sendKeys(c_cvc);
		exp_month.sendKeys(c_expMM);
		exp_year.sendKeys(c_expYYYY);
		captureScreenshot(folder,testName);
		payment_btn.click();
		Log.info("Card details filled and Clicked Payment button");
	}
	public void verifySuccessMsg(String folder) {
		if (success_msg.getText().equals("Your order has been placed successfully!"))
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
