package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.AllProductsPage;
import com.automationExercise.pageObjects.CartPage;
import com.automationExercise.pageObjects.HomePage;

public class TC_012_AddProductsToCartTest extends BaseClass{
	@Test
	
	public void verifyAddProductINCart() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("AddProductsToCartTest");
		home.clickProduct();
		AllProductsPage app=new AllProductsPage();
		app.scrollToProductTxt();
		app.hoverProduct(app.pro_img1);
		app.addProductToCart(app.add_pro_1);
		app.clickContinueBtn();
		Thread.sleep(1000);
		app.scrollToProductTxt();
		app.hoverProduct(app.pro_img2);
		app.addProductToCart(app.add_pro_2);
		String item1=app.getFPName();
		String item2 =app.getSPName();
		app.clickViewCart("AddProductsToCartTest");
		Thread.sleep(2000);
		CartPage cp=new CartPage();
		cp.verifyCartItems(item1, item2,"AddProductsToCartTest");
		cp.verifyCartPrice();
	}

}
