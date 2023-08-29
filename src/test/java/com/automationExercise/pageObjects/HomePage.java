package com.automationExercise.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

import io.qameta.allure.Step;



public class HomePage extends BaseClass{

	public HomePage() 
	{
		PageFactory.initElements(driver,this);	
	}
	@FindBy(xpath="//div[@class='logo pull-left']/a/img") WebElement logo;
	@FindBy(xpath="//li/a[contains(text(),'Home')]") WebElement link_home;
	@FindBy(xpath="//li/a[contains(text(),'Products')]") WebElement link_products;
	@FindBy(xpath="//li/a[contains(text(),'Cart')]") WebElement link_cart;
	@FindBy(xpath="//li/a[contains(text(),'Login')]")WebElement link_signup;
	@FindBy(xpath="//li/a[contains(text(),'Contact us')]") WebElement link_contactUs;
	@FindBy(xpath="//li/a[contains(text(),'Test Cases')]") WebElement link_testCases;
	
	@FindBy(xpath="//li/a[contains(text(),' Logged in as ')]") WebElement logged;
	
	@FindBy(xpath="//li/a[contains(text(),'Delete')]") WebElement delete_Acc;
	@FindBy(xpath="//div/h2/b[text()='Account Deleted!']") WebElement delete_msg;
	@FindBy(xpath="//div/a[@data-qa='continue-button']") WebElement del_continue;
	@FindBy(xpath="//li/a[contains(text(),'Logout')]") WebElement link_logout;
	//category
	@FindBy(xpath="//div[@class='left-sidebar']/h2") WebElement category_txt;
	@FindBy(xpath="//div[@id='accordian']/div") List<WebElement> category_items;
	@FindBy(xpath="//div[@id='accordian']/div[1]/div/h4/a") WebElement women;
	@FindBy(xpath="//div[@id='Women']//li") List<WebElement> women_items;
	@FindBy(xpath="//div[@id='Women']//li[1]/a") WebElement women_dress;
	//Footer for subscription
	@FindBy(xpath="//div [@class='single-widget']/h2") WebElement subs_head; 
	@FindBy(id="susbscribe_email") WebElement subs_input;
	@FindBy(id="subscribe") WebElement subs_btn;
	@FindBy(id="success-subscribe") WebElement subs_txt;
	//Recommended products
	@FindBy(xpath="//div[@class='recommended_items']/h2")
	WebElement recom_txt;
	@FindBy(xpath="//div/button[@data-dismiss='modal']")
	WebElement continue_btn;
	@FindBy(xpath="//div[@id='recommended-item-carousel']//div[@class='col-sm-4']//a")
	List<WebElement> recom_prods;
	@FindBy(xpath="//div[@id='recommended-item-carousel']//div[@class='col-sm-4']//p")
	List<WebElement> recom_prod_name;
	@FindBy(xpath="//p/a/u[text()='View Cart']")
	WebElement view_cart_link;
	//Products in home
	@FindBy(xpath="//div[@class='features_items']/h2")
	WebElement feature_txt;
	@FindBy(xpath="//div[@class='features_items']//a[text()='Add to cart']")
	List<WebElement> add_to_cart_btn;
	@FindBy(xpath="//div[@class='features_items']//div[@class='productinfo text-center']/p")
	List<WebElement> product_name;
	//ScrollUp arrow
	@FindBy(xpath="//a[@id='scrollUp']") 
	WebElement ScrollUpArrow;
	@FindBy(xpath="//div[@class='carousel-inner']//div[@class='col-sm-6']/h2")
	WebElement carousel_txt;
	@Step("Adding products to the cart")
	public String[] addProductsToCart() {
		scrollToElement(feature_txt);
		String[] arr=new String[2];
		int count=0;
		for(int i=0; i<3;i=i+2)
		{
			//waitForWebElementToCilckable(add_to_cart_btn.get(i));
			add_to_cart_btn.get(i).click();
			arr[count]=product_name.get(count).getText();
			continue_btn.click();
			System.out.println("Item :"+arr[count]);
			count++;
			
		}
		Log.info("Added products from home page to the cart");
		return arr;
	}
	public void verifyRecomTxt(String folder) {
		scrollToElement(recom_txt);
		if(recom_txt.getText().equalsIgnoreCase("RECOMMENDED ITEMS"))
		{
			Log.info("Scrolled to the Recommended section and verified text");
			captureScreenshot(folder,"Recommended_section");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Scrolled to the Recommended section and text verification failed");
			captureScreenshot(folder,"Recommended_section_fail");
			Assert.assertTrue(false);
		}
	}
	public String addRecommProd() {
			waitForWebElementToCilckable(recom_prods.get(0));
			recom_prods.get(0).click();
			String pro1= recom_prod_name.get(0).getText();
			view_cart_link.click();
		Log.info("Added recommended product to the cart and navigating to cart");
		return pro1;
	}
	public void verifyCatgoryTxt(String folder) {
		scrollToElement(category_txt);
		if(category_txt.getText().equalsIgnoreCase("Category"))
		{
			Log.info("Category is visible");
			captureScreenshot(folder,"Category_Txt");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Catogory text verification failed");
			captureScreenshot(folder,"Category_Txt_fail");
			Assert.assertTrue(false);
		}
	}
	public void clickWomenCategory() {
		women.click();
		Log.info("Getting "+women.getText()+" Category items");
	}
	public void clickWomenDress() {
		waitForWebElementToCilckable(women_dress);
		women_dress.click();
		Log.info("Getting "+women_dress.getText()+" from the catgory");
	}
	public boolean getLogo() {
		return logo.isDisplayed();
	}
	public void clickHome() {
		link_home.click();
	}
	public void deleteAcc() {
		delete_Acc.click();
		Log.info("Clicked Delete Account");
	}
	public void clickProduct() throws InterruptedException {
		Log.info("Navigating to product page");
		link_products.click();
		Thread.sleep(3000);
	}
	@Step("Navigating to Cart Page")
	public void clickCart() {
		Log.info("Navigating to cart page");
		link_cart.click();
	}
	public void clickSignup() {
		Log.info("Navigating to signup page");
		link_signup.click();
	}
	public void clickContactUs() {
		Log.info("Navigating to contact us page");
		link_contactUs.click();
	}
	public String getLoggedMsg() {
		return logged.getText();
	}
	@Step("Clicking 'Delete Account' button")
	public void clickDeleteAcc() {
		delete_Acc.click();
	}
	public String deleteMsg() {
		return delete_msg.getText();
	}
	public void clickDelContinue() {
		del_continue.click();
	}
	public void clickLogout() {
		link_logout.click();
		Log.info("Logged out");
	}
	public void clickTest() throws InterruptedException {
		Log.info("Navigating to Test Cases page");
		link_testCases.click();
		Thread.sleep(3000);
	}
	@Step("Verifying the Home Page")
	public void verifyHomePage(String testFolder) {
//		//Getting url
		String title=driver.getTitle();
		if(title.equalsIgnoreCase(homeTitle))
		{
			//capturing screenshot to verify home page
			captureScreenshot(testFolder,"hometest");
			Log.info("Home Page Verified");
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(testFolder,"hometest_fail");
			Log.info("Home Page Verification Failed");
			Assert.assertTrue(false);
		}
	}
	
	public void verifyLogo() {
		if(getLogo())
		{
			Log.info("Logo is displayed");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Logo is not present");
			Assert.assertTrue(false);
		}
	}
	@Step("Verifying ' Logged in as username' at top")
	public void verifyLoginMsg(String uname,String testFolder) throws InterruptedException {
		//Checking logged in msg
		if(getLoggedMsg().equalsIgnoreCase("Logged in as "+uname))
		{
			Log.info("Login message verification successful");
			captureScreenshot(testFolder,"Login_Msg");
			Assert.assertTrue(true);
		}
		else
		{
			Log.warn("Login message verification failed");
			captureScreenshot(testFolder, "Login_Msg_fail");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);
	}
	@Step("Verifying 'ACCOUNT DELETED!' and clicking 'Continue' button")
	public void verifyDeleteAccount() throws InterruptedException {
	//Click delete account
	//clickDeleteAcc();
	
	
	if(deleteMsg().equalsIgnoreCase(accountDeleted))
	{
		clickDelContinue();
		Log.info("Deletion of account confirmation message received and clicked Continue..");
	}
	else
	{
		Log.info("Not Deleted");
	}
	Thread.sleep(1000);

}

	public void scrollToFooter() throws InterruptedException {
		scrollToElement(subs_input);
		Thread.sleep(2000);
	}
	public void subs_input(String folder) {
		subs_input.sendKeys(randomstring()+"@gmail.com");
		captureScreenshot(folder,"Subscription_Data");
		subs_btn.click();
	}
	public void subs_success() {
		if(subs_txt.getText().equalsIgnoreCase("You have been successfully subscribed!"))
		{
			Log.info("Verified for Subscription success");
		}
		else
		{
			Log.info("Subscription verification Failed");
		}
	}
	@Step("Scrolling down till end without arrow key")
	public void scrollDown(String folder) throws InterruptedException {
		Actions a = new Actions(driver);
		//scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println("Page down......");
		scrollToElement(subs_head);
		Log.info("Scrolled down to footer suscription section");
		captureScreenshot(folder,"Scroll_To_Subscription");
		Thread.sleep(1000);
	}
	@Step("Scrolling Up Using Up arrow button")
	public void scrollUp(String folder) throws InterruptedException
	{
		ScrollUpArrow.click();
		
		if(carousel_txt.isDisplayed())
		{
			Log.info("Scrolling up using Up Arrow button and verified");
			captureScreenshot(folder,"Scroll_up_button");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Scrolling up using Up Arrow button verification failed");
			captureScreenshot(folder,"Scroll_up_button_fail");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);
		
	}
	@Step("Scrolling up to top without arrow key")
	public void scrollUpWithoutUpButton(String folder) throws InterruptedException {
		scrollToElement(logo);
		Log.info("Scrolling up using Up and verified");
		captureScreenshot(folder,"Scroll_Up");
//		Thread.sleep(1000);
	}

}
