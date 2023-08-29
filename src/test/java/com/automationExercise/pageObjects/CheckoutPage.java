package com.automationExercise.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

import io.qameta.allure.Step;

public class CheckoutPage extends BaseClass{
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ol[@class='breadcrumb']/li[2]") WebElement checkout_breadcrumb;
	@FindBy(xpath="//div[@class='step-one'][1]/h2") WebElement heading_txt;
	@FindBy(xpath="//ul[@id='address_delivery']//li[1]") WebElement deliv_add_heading_txt;
	@FindBy(xpath="//ul[@id='address_delivery']//li[2]") WebElement title_n_name;
	@FindBy(xpath="//ul[@id='address_delivery']//li[3]") WebElement company;
	@FindBy(xpath="//ul[@id='address_delivery']//li[4]") WebElement address1;
	@FindBy(xpath="//ul[@id='address_delivery']//li[5]") WebElement address2;
	@FindBy(xpath="//ul[@id='address_delivery']//li[6]") WebElement city_state_pin;
	@FindBy(xpath="//ul[@id='address_delivery']//li[7]") WebElement country;
	@FindBy(xpath="//ul[@id='address_delivery']//li[8]") WebElement phone;
	
	@FindBy(xpath="//div[@class='step-one'][2]/h2") WebElement order_heading;
	@FindBy(xpath="//tr[@id='product-1']/td[2]//a") WebElement pro_name1;
	@FindBy(xpath="//tr[@id='product-1']/td[3]/p") WebElement pro_price1;
	@FindBy(xpath="//tr[@id='product-1']/td[4]/button") WebElement pro_qty1;
	@FindBy(xpath="//tr[@id='product-2']/td[2]//a") WebElement pro_name2;
	@FindBy(xpath="//tr[@id='product-2']/td[3]/p") WebElement pro_price2;
	@FindBy(xpath="//tr[@id='product-2']/td[4]/button") WebElement pro_qty2;
	@FindBy(xpath="//tr[3]/td[3]/h4") WebElement total_txt;
	@FindBy(xpath="//tr[3]/td[4]/p") WebElement cart_total;
	
	@FindBy(xpath="//div[@id='ordermsg']//textarea") WebElement order_msg;
	@FindBy(xpath="//div/a[@href='/payment']") WebElement place_order_btn;
	
	@FindBy(xpath="//div[@class='modal-body']//a")WebElement signup_popup;
	
	
	//Billing address
	@FindBy(xpath="//ul[@id='address_invoice']/li")
	List<WebElement> billing_address;
	@Step("Clicking 'Register / Login' button")
	public void clickSignUp() {
		signup_popup.click();
		Log.info("Navigating to SignUp page");
	}
	public void verifyBillingAddress(String u_title,String u_fname, String u_lname, String u_company,
			String u_address1, String u_address2, String u_city, String u_state, String u_pin,
			String u_country, String u_phone, String folder)
	{
		String name=u_title+" "+u_fname+" "+u_lname;
		String address3=u_city+" "+u_state+" "+u_pin;
		if(billing_address.get(1).getText().equalsIgnoreCase(name) && billing_address.get(2).getText().equalsIgnoreCase(u_company)
				&& billing_address.get(3).getText().equalsIgnoreCase(u_address1)
				&& billing_address.get(5).getText().equalsIgnoreCase(address3))
		{
			Log.info("Billing Address is verified");
			captureScreenshot(folder,"Billing_address");
			Assert.assertTrue(true);
			
		}
		else
		{
			Log.info("Billing address verification failed");
			captureScreenshot(folder,"Billing_address_fail");
			Assert.assertTrue(false);
		}
		
	}
	@Step(" Verifying Delivery Address Details")
	public void verifyAddress(String u_title,String u_fname, String u_lname, String u_company,
			String u_address1, String u_address2, String u_city, String u_state, String u_pin,
			String u_country, String u_phone, String folder) {
		String name=u_title+" "+u_fname+" "+u_lname;
		String address3=u_city+" "+u_state+" "+u_pin;
		if(name.equalsIgnoreCase(title_n_name.getText()) && u_company.equalsIgnoreCase(company.getText())
				&&	u_address1.equalsIgnoreCase(address1.getText()) && address3.equalsIgnoreCase(city_state_pin.getText())
				)
		{
			Log.info("Delivery Address is verified");
			captureScreenshot(folder,"Delivery_address");
			Assert.assertTrue(true);
			
		}
		else
		{
			Log.info("Delivery address verification failed");
			captureScreenshot(folder,"Delivery_address_fail");
			Assert.assertTrue(false);
		}
		
	}
	@Step("Verifying the Orders")
	public void verifyOrder(String pro1, String pro2,String folder)
	{
		waitForWebElement(pro_name1);
		waitForWebElement(pro_name2);
		if(pro_name1.getText().equalsIgnoreCase(pro1) && pro_name2.getText().equalsIgnoreCase(pro2))
		{
			Log.info("Verified the product in the checkout page");
			captureScreenshot(folder,"Order_In_Chkout");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Verification of the product in the checkout page failed");
			captureScreenshot(folder,"Order_In_Chkout_fail");
			Assert.assertTrue(false);
		}
	}
	@Step(" Entering description in comment text area and clicking 'Place Order'")
	public void setPlaceOrderData() {
		String msg="This is my order for colthes";
		order_msg.sendKeys(msg);
		Log.info("Verifyied place order message and clicking place order button");
		place_order_btn.click();
	}
}
