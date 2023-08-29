package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.AllProductsPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.SingleProductDetailPage;

public class TC_021_ReviewOnProductTest extends BaseClass{
	public String productName;
	@Test
	public void verifyReviewOnProduct() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("ReviewOnProductTest");
		home.clickProduct();
		AllProductsPage app=new AllProductsPage();
		app.verifyProPageNav("ReviewOnProductTest");
		productName=app.getProduct("ReviewOnProductTest");
		SingleProductDetailPage spdp=new SingleProductDetailPage();
		spdp.verifySinglePro(productName,"ReviewOnProductTest");
		spdp.verifyReviewTxt("ReviewOnProductTest");
		spdp.setReviewData("ReviewOnProductTest");
		spdp.verifyRevSucMsg();
	}

}
