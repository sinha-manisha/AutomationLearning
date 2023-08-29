package com.automationExercise.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

public class SingleProductDetailPage extends BaseClass{
	public SingleProductDetailPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='product-information']/h2") WebElement product_name;
	@FindBy(xpath="//div[@class='product-information']/p[contains(text(),'Category')]") WebElement product_category;
	@FindBy(xpath="//div[@class='product-information']/p/b[contains(text(),'Availability')]/parent::*") WebElement product_availability;
	@FindBy(xpath="//div[@class='product-information']/p/b[contains(text(),'Condition')]/parent::*") WebElement product_condition;
	@FindBy(xpath="//div[@class='product-information']/p/b[contains(text(),'Brand')]/parent::*") WebElement product_brand;
	@FindBy(xpath="//span/span") WebElement product_price;
	@FindBy(id="quantity") WebElement product_quantity;
	@FindBy(xpath="//span/button") WebElement AddToCart_btn;
	
	@FindBy(xpath="//div[@class='modal-body']/p/a") WebElement viewcart_link;
	
	//Review
	@FindBy(xpath="//div[@class='col-sm-12']/ul/li/a") 
	WebElement review_txt;
	@FindBy(xpath="//input[@id='name']") 
	WebElement name;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//textarea[@id='review']")
	WebElement review_msg;
	@FindBy(xpath="//button[@id='button-review']")
	WebElement review_btn;
	@FindBy(xpath="//div[@class='alert-success alert']/span")
	WebElement success_msg;
	public void verifyReviewTxt(String folder) {
		scrollToElement(review_txt);
		if(review_txt.getText().equalsIgnoreCase("Write Your Review"))
		{
			Log.info("Review Text heading's dispaly is verified");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Review Text heading's dispaly  verification failed");
			captureScreenshot(folder,"Review_Txt_fail");
			Assert.assertTrue(false);
		}
	}
	public void setReviewData(String folder) {
		name.sendKeys("Manisha");
		email.sendKeys("qazsw@gmail.com");
		review_msg.sendKeys("This is my review message");
		captureScreenshot(folder,"Review_data");
		review_btn.click();
		Log.info("Review form filled and sbumitted");
	}
	public void verifyRevSucMsg() {
		if(success_msg.getText().equalsIgnoreCase("Thank you for your review."))
		{
			Log.info("Review Success message verified");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Review Success message verification failed");
			Assert.assertTrue(false);
		}
	}
	public void clickAddToCart_btn() {
		AddToCart_btn.click();
	}
	public void setProductQuantity(String qty,String folder) {
		product_quantity.clear();
		Log.info("Setting the Quantity to 4");
		product_quantity.sendKeys(qty);
		captureScreenshot(folder,"Qty_set");
	}
	public void clickAddToCart() {
		AddToCart_btn.click();
	}
	public void getViewCart() {
		waitForWebElement(viewcart_link);
		viewcart_link.click();
	}
	public String getProName() {
		return product_name.getText();
	}
	public String getProCategory() {
		return product_category.getText();
	}
	public String getProAvil()
	{
		return product_availability.getText();
	}
	public String getProCondition() {
		return product_condition.getText();
	}
	public String getProBrand() {
		return product_brand.getText();
	}
	public String getProPrice() {
		return product_price.getText();
	}
	public void verifySinglePro(String pro,String folder) {
		
		if(getProName().equals(pro))
		{
			Log.info("Navigated to selected Single Product page ");
			Assert.assertTrue(true);
			captureScreenshot(folder,"Single_Product_page");
			
			if(getProName().isEmpty() && getProCategory().isEmpty() && getProAvil().isEmpty()
					&& getProCondition().isEmpty() && getProBrand().isEmpty() &&getProPrice().isEmpty())
			{
				Log.info("Products details verification failed");
				Assert.assertTrue(false);
			}
			else
			{
				
				Log.info("Products details are verified");
				Assert.assertTrue(true);
			}
		}
		else
		{
			Log.info("Navigated to wrong page navigation failed");
			captureScreenshot(folder,"Single_product_Fail");
			Assert.assertTrue(false);
		}
	}

}
