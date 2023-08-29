package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.CartPage;
import com.automationExercise.pageObjects.HomePage;

public class TC_017_RemoveProductsFromCartTest extends BaseClass{
	@Test
	
	public void verifyRemoveProductsFromCart() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("RemoveProductsFromCartTest");
		String[] arr= home.addProductsToCart();
		home.clickCart();
		String item1=arr[0];
		String item2=arr[1];
		CartPage cp=new CartPage();
		cp.verifyCartPage("RemoveProductsFromCartTest");
		cp.verifyCartItems(item1, item2,"RemoveProductsFromCartTest");
		Thread.sleep(1000);
		cp.removeProduct(item2);
		Thread.sleep(2000);
		cp.verifyProductRemoval(item1, "RemoveProductsFromCartTest");
	}

}
