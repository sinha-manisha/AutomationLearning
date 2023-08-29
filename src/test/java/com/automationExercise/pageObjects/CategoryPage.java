package com.automationExercise.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

public class CategoryPage extends BaseClass{
	public CategoryPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ol/li[2]") WebElement category_breadcrumb;
	@FindBy(xpath="//div[@class='features_items']/h2") WebElement category_txt;
	@FindBy(xpath="//div[@id='accordian']/div") List<WebElement> category_items;
	@FindBy(xpath="//div[@id='accordian']/div[2]/div/h4/a") WebElement men;
	@FindBy(xpath="//div[@id='Men']//li[2]/a") WebElement men_jeans;
	
	public void verifyCategoryPage(String folder) throws InterruptedException {
		if(driver.getTitle().equalsIgnoreCase("Automation Exercise - Dress Products"))
		{
			Log.info("Navigated to Category page");
			captureScreenshot(folder,"Category_page");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Navigation to Category page failed");
			captureScreenshot(folder,"Category_page_fail");
			Assert.assertTrue(false);
		}
	}
	public void verifyWomenCategTxt() {
		if(category_txt.getText().contains("WOMEN - DRESS PRODUCTS"))
		{
			Log.info("Confirmed category text");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Confirmation of category text failed");
			Assert.assertTrue(false);
		}
	}
	public void verifyMenCategNav(String folder) throws InterruptedException {
		
		men.click();
		waitForWebElementToCilckable(men_jeans);
		men_jeans.click();
		Thread.sleep(1000);
		if(driver.getTitle().equalsIgnoreCase("Automation Exercise - Jeans Products"))
		{
			Log.info("Navigated to Men's Jeans category page");
			captureScreenshot(folder,"Men's_Category");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Navigation to Men's Jeans category page failed");
			captureScreenshot(folder,"Men's_Category_fail");
			Assert.assertTrue(false);
		}
	}

}
