package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.AllProductsPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.SingleProductDetailPage;

public class TC_008_ProductPageTest extends BaseClass{
	String productName;
	@Test(priority=0)
	public void verifyProductPage() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("ProductsTest");
		home.clickProduct();
		AllProductsPage app=new AllProductsPage();
		app.verifyProPageNav("ProductsTest");
		productName=app.getProduct("ProductsTest");
		SingleProductDetailPage spdp=new SingleProductDetailPage();
		spdp.verifySinglePro(productName,"ProductsTest");
	}
	
}
