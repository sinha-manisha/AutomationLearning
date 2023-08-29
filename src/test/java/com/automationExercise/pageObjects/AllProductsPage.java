package com.automationExercise.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

public class AllProductsPage extends BaseClass{
	public AllProductsPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='features_items']/h2")
	WebElement allProduct_txt;
	@FindBy(xpath="//li/a[text()='View Product'][1]")
	WebElement first_product_view_btn;
	@FindBy(xpath="//div[@class='productinfo text-center']/img[@src='/get_product_picture/1']/following-sibling::p")
	WebElement First_product_name;
	@FindBy(xpath="//div[@class='productinfo text-center']/img[@src='/get_product_picture/2']/following-sibling::p")
	WebElement Second_pro_name;
	@FindBy(xpath="//div[@class='productinfo text-center']/img[@src='/get_product_picture/1']")
	public WebElement pro_img1;
	@FindBy(xpath="//div[@class='productinfo text-center']/img[@src='/get_product_picture/2']")
	public WebElement pro_img2;
	@FindBy(id="search_product")
	WebElement search;
	@FindBy(id="submit_search")
	WebElement search_btn;
	
	@FindBy(xpath="//div[@class='overlay-content']/a[@data-product-id='1']")
	public WebElement add_pro_1;
	@FindBy(xpath="//div[@class='overlay-content']/a[@data-product-id='2']")
	public WebElement add_pro_2;
	@FindBy(xpath="//p/a/u[text()='View Cart']")
	WebElement view_cart_link;
	@FindBy(xpath="//div/button[@data-dismiss='modal']")
	WebElement continue_btn;
	@FindBy(xpath="//li/a[contains(text(),'Cart')]")
	WebElement link_cart;
	//Brands
	@FindBy(xpath="//div[@class='brands_products']/h2")
	WebElement brands_txt;
	@FindBy(xpath="//div[@class='brands_products']/div/ul/li")
	List<WebElement> brand_items;
	@FindBy(xpath="//div[@class='brands_products']/div/ul/li[1]/a")
	WebElement getPolo_brand;
	
	public void verifyBrands(String folder) {
		if(brands_txt.getText().equalsIgnoreCase("Brands") && brand_items.size()>0)
		{
			scrollToElement(brands_txt);
			Log.info("Verified Brands are displayed");
			captureScreenshot(folder,"Brand_Product");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Verification of Brands displayed failed");
			captureScreenshot(folder,"Brand_Product_fail");
			Assert.assertTrue(false);
		}
	}
	public void clickBrandOne() {
		Log.info("Navigating to "+getPolo_brand.getText()+" Brand Page");
		getPolo_brand.click();
	}
	public void getCart() {
		waitForWebElementToCilckable(link_cart);
		link_cart.click();
	}
	public String getFPName() {
		return First_product_name.getText();
	}
	public String getSPName() {
		return Second_pro_name.getText();
	}
	public void verifyProPageNav(String testFolder) {
		String title=driver.getTitle();
		
		if(title.equalsIgnoreCase("Automation Exercise - All Products"))
		{
			Log.info("Navigated to All product page");
			Assert.assertTrue(true);
			if(allProduct_txt.getText().equalsIgnoreCase("All Products"))
			{
				Log.info("All Product Page Verification done!");
				captureScreenshot(testFolder,"Products_Text");
				Assert.assertTrue(true);
			}
			else
			{
				Log.info("All product page verification Failed");
				captureScreenshot(testFolder,"Products_text_fail");
				Assert.assertTrue(false);
			}
		}
		else
		{
			Log.info("Navigation to All Product page Failed");
			captureScreenshot(testFolder,"All_Product_Nav_Fail");
			Assert.assertTrue(false);
		}
	}
	public String getProduct(String folder) {
		scrollToProductTxt();
		String pro=First_product_name.getText();
		captureScreenshot(folder,"Product_View");
		first_product_view_btn.click();
		Log.info("Getting the First Product from the Product Page");
		return pro;
	}
	public void searchProduct(String proName) {
		search.sendKeys(proName);
		search_btn.click();
	}
	public void scrollToProductTxt() {
		scrollToElement(allProduct_txt);
	}
	public void hoverProduct(WebElement pImg) {
		scrollToElement(allProduct_txt);
		Actions action=new Actions(driver);
		action.moveToElement(pImg).perform();
		Log.info("Hovered on the product");
	}
	public void addProductToCart(WebElement ele) {
		Log.info("Adding product to cart");
		waitForWebElement(ele);
		ele.click();
	}
	public void clickContinueBtn() {
		Log.info("Continuing Shopping..");
		continue_btn.click();
	}
	public void clickViewCart(String folder) {
		Log.info("Navigating to Cart page");
		captureScreenshot(folder,"Product_added");
		view_cart_link.click();
	}
	
}
