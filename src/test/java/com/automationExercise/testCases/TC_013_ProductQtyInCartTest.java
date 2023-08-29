package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.AllProductsPage;
import com.automationExercise.pageObjects.CartPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.SingleProductDetailPage;

public class TC_013_ProductQtyInCartTest extends BaseClass{
	@Test
	public void verifyProductQtyInCart() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("ProductQtyInCartTest");
		home.clickProduct();
		AllProductsPage app=new AllProductsPage();
		String pro=app.getProduct("ProductQtyInCartTest");
		SingleProductDetailPage spdp=new SingleProductDetailPage();
		spdp.verifySinglePro(pro,"ProductQtyInCartTest");
		spdp.setProductQuantity("4","ProductQtyInCartTest");
		spdp.clickAddToCart();
		spdp.getViewCart();
		CartPage cp=new CartPage();
		String qty=cp.getProductQty();
		cp.verifyProductQty(qty,"ProductQtyInCartTest");
	}

}
