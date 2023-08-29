package com.automationExercise.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationExcercise.base.BaseClass;

public class BrandsPage extends BaseClass{
	public BrandsPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='features_items']/h2")
	WebElement heading_txt;
	@FindBy(xpath="//div[@class='features_items']/div[@class='col-sm-4']")
	List<WebElement> brand_displayed;
	@FindBy(xpath="//div[@class='brands_products']/div/ul/li[1]/a")
	WebElement getPolo_brand;
	@FindBy(xpath="//div[@class='brands_products']/div/ul/li[5]/a")
	WebElement getBabyhug_brand;
	public void verifyBrandNav(String folder,String bnd) {
		if(heading_txt.getText().equalsIgnoreCase(bnd) && (brand_displayed.size()>0))
		{
			Log.info("Navigated to brand Page and items are displayed");
			captureScreenshot(folder,bnd+"Brand_page");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("Navigation to brand Page and items are displayed verifiction failed");
			captureScreenshot(folder,"Brand_page_fail");
			Assert.assertTrue(false);
		}
	}
	public void getAnotherBrand() {
		Log.info("Navigating to another brand");
		getBabyhug_brand.click();
	}
	

}
