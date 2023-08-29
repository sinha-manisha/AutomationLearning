package com.automationExercise.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

import io.qameta.allure.Step;

public class CartPage extends BaseClass{
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='single-widget']/h2") WebElement subs_txt; 
	@FindBy(id="susbscribe_email") WebElement subs_email;
	@FindBy(id="subscribe") WebElement subs_btn;
	@FindBy(id="success-subscribe") WebElement subs_confirm_msg;
	
	@FindBy(xpath="//tr[1]/td[2]/h4/a") WebElement cart_pro_name1;
	@FindBy(xpath="//tr[2]/td[2]/h4/a") WebElement cart_pro_name2;
	@FindBy(xpath="//tr[@id='product-1']/td[3]/p") WebElement cart_pro_price1;
	@FindBy(xpath="//tr[@id='product-2']/td[3]/p") WebElement cart_pro_price2;
	@FindBy(xpath="//tr[@id='product-1']/td[4]/button") WebElement cart_pro_qty1;
	@FindBy(xpath="//tr[@id='product-2']/td[4]/button") WebElement cart_pro_qty2;
	@FindBy(xpath="//tr[@id='product-1']/td[5]/p") WebElement cart_pro_total1;
	@FindBy(xpath="//tr[@id='product-2']/td[5]/p") WebElement cart_pro_total2;
	@FindBy(xpath="//tr[@id='product-1']/td[6]/a") WebElement pro_remove1;
	@FindBy(xpath="//tr[@id='product-2']/td[6]/a") WebElement pro_remove2;
	
	@FindBy(xpath="//section[@id='do_action']//div/a") WebElement checkout_link;
	@FindBy(xpath="//div[@id='checkoutModal']//a") WebElement checkout_reg_link;
	@FindBy(xpath="//ol[@class='breadcrumb']/li[2]") WebElement chk_breadcrumb;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr") List<WebElement> items;
	@FindBy(xpath="//li/a[contains(text(),'Login')]") WebElement link_signup;
	public void getSignUp() {
		link_signup.click();
		Log.info("Navigating to SignUp page");
	}
	public void verifyItemsInCart(int pros, String folder) {
		if(items.size()==pros)
		{
			Log.info("Cart is verified for all the products added after search");
			captureScreenshot(folder,"Search_AddAll");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Cart verification for all the products added after search failed"+items.size()+"  "+pros);
			captureScreenshot(folder,"Search_AddAll_fail");
			Assert.assertTrue(false);
		}
	}
	public void removeProduct(String pro) {
		if(cart_pro_name1.getText().equalsIgnoreCase(pro))
			pro_remove1.click();
		else
			pro_remove2.click();
		Log.info("Removed "+pro+" from the cart");
	}
	public void verifyProductRemoval(String pro,String folder) {
		int s=items.size();
		if(s==1 && cart_pro_name1.getText().equalsIgnoreCase(pro))
		{
			Log.info("Verified Product removal from cart ");
			captureScreenshot(folder,"Product_Removal");
			Assert.assertTrue(true);	
		}
		
		else
		{
			Log.info("Verification of Product removal from cart failed");
			captureScreenshot(folder,"Product_Removal_fail");
			Assert.assertTrue(false);
		}
	}
	@Step("Clicking Proceed To Checkout")
	public void getCheckout() {
		Log.info("Navigating to checkout");
		checkout_link.click();
	}
	public void getRegisterPage() {
		 waitForWebElement(checkout_reg_link);
		 checkout_reg_link.click();
		 Log.info("Navigating to Registration/SignUp page");
	}
	public void getFooter() {
		scrollToElement(subs_txt);
	}
	public String getProductQty()
	{
		return cart_pro_qty1.getText();
	}
	public void verifyProductQty(String qty ,String folder) {
		if(qty.equals("4"))
		{
			Log.info("Product quantity in Cart verified");
			captureScreenshot(folder,"Quantity_In_cart");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Product quantity in Cart verification failed");
			captureScreenshot(folder,"Quantity_In_cart_fail");
			Assert.assertTrue(false);
		}
	}
	public void cartVerifySubscrition()
	{
		if(subs_txt.getText().equals("SUBSCRIPTION"))
		{
			Log.info("Subscription text verifyed");
			Assert.assertTrue(true);
			
		}
		else
		{
			Log.info("Subscription text verifiction failed");
			captureScreenshot("CartSuscriptionTest","Cart_subscription _fail");
			Assert.assertTrue(false);
		}
	}
	public void setSubsData(String folder)
	{
		subs_email.sendKeys(randomstring()+"@gamil.con");
		captureScreenshot(folder,"Cart_subscription_data");
		subs_btn.click();
		Log.info("Entered email id and clicked the button");
	}
	public void verifyCartSubscriptionSuccessMsg() {
		if (subs_confirm_msg.getText().equalsIgnoreCase("You have been successfully subscribed!"))
		{
			Log.info("Subscription success message verified");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Subscription success message verification failed");
			Assert.assertTrue(false);
		}
	}
	public void verifyCartItems(String pro_name1, String pro_name2,String folder) {
		if((cart_pro_name1.getText().equalsIgnoreCase(pro_name1)) && (cart_pro_name2.getText().equalsIgnoreCase(pro_name2)))
		{
			Log.info("Verified Cart Page for product added");
			captureScreenshot(folder,"Product_In_Cart");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Verified Cart Page for product added failed");
			captureScreenshot(folder,"Product_In_Cart_fail");
			Assert.assertTrue(false);
		}
	}
	public void verifyCartPrice() {
		if(((cart_pro_price1.getText().equalsIgnoreCase("Rs. 500")) && (cart_pro_qty1.getText().equals("1"))) &&
				((cart_pro_price2.getText().equalsIgnoreCase("Rs. 400")) && (cart_pro_qty2.getText().equals("1"))))
		{
			Log.info("Verified Price, Quantity And Total price");
			Assert.assertTrue(true);
		}
				
		else
		{
			Log.info("Verification of product price, quantity and Total price failed");
			Assert.assertTrue(false);
		}
				
	}
	@Step("Verifying Cart Page")
	public void verifyCartPage(String folder) {
		if(chk_breadcrumb.getText().equalsIgnoreCase("Shopping Cart"))
		{
			Log.info("Cart page verified");
			captureScreenshot(folder,"Product_added_TOCart");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Cart page verification failed");
			captureScreenshot(folder,"Product_added_TOCart_fail");
			Assert.assertTrue(false);
		}
	}
	public void verifyRecomItemToCart(String pro, String folder) {
		if(cart_pro_name1.getText().equalsIgnoreCase(pro))
		{
			Log.info("Verified recommened product addition to the cart");
			captureScreenshot(folder,"Recommended_Product");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Verification of recommened product addition to the cart failed");
			captureScreenshot(folder,"Recommended_Product_fail");
			Assert.assertTrue(false);
		}
	}

}
