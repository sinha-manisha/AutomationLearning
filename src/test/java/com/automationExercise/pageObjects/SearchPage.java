package com.automationExercise.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

public class SearchPage extends BaseClass{
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='features_items']/h2")
	WebElement search_heading;
	@FindBy(xpath="//div[@class='productinfo text-center']/p")
	List<WebElement> search_pro;
	@FindBy(xpath="//div[@class='features_items']//a[text()='Add to cart']")
	List<WebElement> items;
	@FindBy(xpath="//div/button[@data-dismiss='modal']")
	WebElement continue_btn;
	@FindBy(xpath="//li/a[contains(text(),'Cart')]")
	WebElement link_cart;
	
	public int AddAllToCart() {
		int count=0;
		for(int i=0;i<items.size();i=i+2)
		{
			items.get(i).click();
			continue_btn.click();
//			System.out.println("Clicked!!");
			count++;
		}
		Log.info("Total items added to cart is :"+count);
		return count;
	}
	public void searchResult(String folder){
		int count=0;
		for(WebElement item:search_pro)
		{
			if(item.getText().contains("Top")|| item.getText().contains("Shirt"))
			{
				count++;
			}
			
		}
		if(count==search_pro.size())
		{
			captureScreenshot(folder,"Search_result");
			Log.info("Verified the search result");
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(folder,"Search_result_Fail");
			Log.info("Search result verification failed");
			Assert.assertTrue(false);
		}
		
	}
	public void getCart() {
		waitForWebElementToCilckable(link_cart);
		link_cart.click();
	}

}
